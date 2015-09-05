package provider;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import provider.controller.ServiceProviderController;
import provider.domain.ServiceProvider;
import provider.domain.UserServiceRequest;
import provider.services.ProviderService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class ServiceControllerTests {
    @Mock
    private ProviderService providerService;
    @Before
    public void Setup() {
        initMocks(this);
    }

    @Test
    //services/
    public void testShouldBeAbleToGetAllServiceProvidersWithAccreditedUsers() {

        List<ServiceProvider> serviceProviders = new ArrayList<>();
        serviceProviders.add(new ServiceProvider());

        when(providerService.getServiceProvidersWithAccreditations(anyInt())).thenReturn(serviceProviders);

        ServiceProviderController serviceProviderController = new ServiceProviderController(providerService);

        int categoryId = 3;

        List<ServiceProvider> serviceProviderList = serviceProviderController.getAccreditedServiceProvidersByCategory(categoryId);
        assertThat(serviceProviderList.size(), is(1));
    }

    @Test
    //services/
    public void testShouldBeAbleToGetAllServices() {

        ServiceProviderController serviceProviderController = new ServiceProviderController(providerService);

      //  List<ServiceProvider> serviceProviderList = serviceProviderController.getAllServiceProviders();

        //assertThat(serviceProviderList, is(notNull()));
    }

    @Test
    //services/category/{categoryId}/reviews?filter=highest
    public void testShouldGetServiceWithHighestReviews() throws InvalidArgumentException {

        ServiceProviderController serviceProviderController = new ServiceProviderController(providerService);

        int categoryId = 1;
        String filter = "highest";
        List<ServiceProvider> serviceProviderList = serviceProviderController.getServicesReviewsByServiceCategory(categoryId, filter);

        assertThat(serviceProviderList, is(notNull()));
    }

    @Test
    //services/category/{categoryId}/ratings?filter=highest
    public void testShouldGetServiceWithHighestRatings() throws InvalidArgumentException {

        ServiceProviderController serviceProviderController = new ServiceProviderController(providerService);

        int categoryId = 1;
        String filter = "highest";
        List<ServiceProvider> serviceProviderList = serviceProviderController.getServicesRankingsByServiceCategory(categoryId, filter);

        assertThat(serviceProviderList, is(notNull()));
    }

    @Test
    //services/{ServiceId}/
    public void testShouldGetServiceById() throws InvalidArgumentException {

        ServiceProviderController serviceProviderController = new ServiceProviderController(providerService);

        long serviceId = 1L;
        ServiceProvider serviceProviderList = serviceProviderController.getProviderById(serviceId);

        assertThat(serviceProviderList, is(notNull()));
    }


    @Test
    //services/{serviceId}/distance
    public void testShouldBeAbleToGetClosestServices() {

        ServiceProviderController serviceProviderController = new ServiceProviderController(providerService);

        //services/category/
        UserServiceRequest userLocation = new UserServiceRequest();
        userLocation.setLongitude(20.3);
        userLocation.setLatitude(20.3);
        userLocation.setRadiusInKilometers(10);
        userLocation.setServiceId(3);

        List<ServiceProvider> serviceProviderList = serviceProviderController.getClosestServiceProvider(userLocation);
        assertThat(serviceProviderList, is(notNull()));
    }


}
