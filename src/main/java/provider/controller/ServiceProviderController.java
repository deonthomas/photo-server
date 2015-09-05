package provider.controller;


import com.sun.javaws.exceptions.InvalidArgumentException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import provider.domain.ServiceProvider;
import provider.domain.UserServiceRequest;
import provider.models.ServiceProviderResponse;
import provider.services.ProviderService;

import java.util.ArrayList;
import java.util.List;

import static Utils.StringUtils.isNullOrEmpty;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController()
@RequestMapping(value = "/services")
@Api(value = "/services", description = "SReturns all service providers")
public class ServiceProviderController {

    private ProviderService providerService;

    @Autowired
    public ServiceProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @ApiOperation(value = "Returns all service providers", notes = "Service providers to be returned", response = ServiceProvider.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 404, message = "No rating found for the given album id"),
    @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping()
    public ResponseEntity<ServiceProviderResponse> getAllServiceProviders() {

        ServiceProviderResponse response ;
        List<ServiceProvider> serviceProviders   = providerService.findAll();
        response  = new ServiceProviderResponse(serviceProviders);
        response.add(linkTo(methodOn(ServiceProviderController.class).getAllServiceProviders()).withSelfRel());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping("id")
    public ServiceProvider getProviderById(@ApiParam(value = "Specify the service provider id", required = false)
                                               @PathVariable("id") Long id) throws InvalidArgumentException {
        if (isNullOrEmpty(id.toString()) == false) {
            return providerService.fineOneServiceProvider(id);
        }
        throw new InvalidArgumentException(new String[]{"Id"});
    }

    @RequestMapping(value = "distance", method = RequestMethod.POST)
    public List<ServiceProvider> getClosestServiceProvider(@RequestBody UserServiceRequest userLocation) {
        return null;
    }

    @RequestMapping("category/{categoryId}/ratings")
    public List<ServiceProvider> getServicesRankingsByServiceCategory(@PathVariable("categoryId") int categoryId,
                                                                      @RequestParam(value = "filter", defaultValue = "highest", required = false) String filter) {
        return new ArrayList<ServiceProvider>();
    }

    @RequestMapping("category/{categoryId}/reviews")
    public List<ServiceProvider> getServicesReviewsByServiceCategory(@PathVariable("categoryId") int categoryId,
                                                                     @RequestParam(value = "filter", defaultValue = "highest", required = false) String filter) {
        return new ArrayList<ServiceProvider>();
    }

    @RequestMapping("category/{categoryId}/accredited")
    public List<ServiceProvider> getAccreditedServiceProvidersByCategory(@PathVariable("categoryId") int categoryId) {
        if (categoryId > 0) {
            return providerService.getServiceProvidersWithAccreditations(categoryId);
        }
        return new ArrayList<>();
    }
}