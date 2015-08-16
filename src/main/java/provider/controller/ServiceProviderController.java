package provider.controller;


import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.web.bind.annotation.*;
import provider.domain.UserServiceRequest;
import provider.domain.ServiceProvider;
import provider.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static Utils.StringUtils.isNullOrEmpty;

@RestController()
@RequestMapping(value = "/services")
public class ServiceProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping()
    public List<ServiceProvider> getAllServiceProviders() {
        return providerService.findAll();
    }

    @RequestMapping("id")
    public ServiceProvider getProviderById(@PathVariable("id") Long id) throws InvalidArgumentException {
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

    @RequestMapping("category/{categoryId}/users/certified")
    public List<ServiceProvider> getServiceProvidersWithCertifiedUsers( @PathVariable("categoryId") String categoryId) {
        return new ArrayList<ServiceProvider>();
    }
}