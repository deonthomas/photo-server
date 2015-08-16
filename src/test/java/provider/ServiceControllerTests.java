package provider;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import provider.controller.ServiceProviderController;
import provider.domain.ServiceProvider;
import provider.domain.UserServiceRequest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.notNull;

@RunWith(MockitoJUnitRunner.class)
public class ServiceControllerTests
{
    @Test
    //services/
    public void testShouldBeAbleToGetAllServiceProvidersWithCertifiedUsers() {

        ServiceProviderController serviceProviderController = new ServiceProviderController();

        String categoryId = "2";
        List<ServiceProvider> serviceProviderList = serviceProviderController.getServiceProvidersWithCertifiedUsers(categoryId);

        assertThat(serviceProviderList,is(notNull()));
    }


    @Test
    //services/
    public void testShouldBeAbleToGetAllServices() {

        ServiceProviderController serviceProviderController = new ServiceProviderController();

        List<ServiceProvider> serviceProviderList = serviceProviderController.getAllServiceProviders();

        assertThat(serviceProviderList,is(notNull()));
    }

    @Test
    //services/category/{categoryId}/reviews?filter=highest
    public void testShouldGetServiceWithHighestReviews() throws InvalidArgumentException {

        ServiceProviderController serviceProviderController = new ServiceProviderController();

        int categoryId = 1;
        String filter = "highest";
        List<ServiceProvider> serviceProviderList = serviceProviderController.getServicesReviewsByServiceCategory(categoryId, filter);

        assertThat(serviceProviderList, is(notNull()));
    }

    @Test
    //services/category/{categoryId}/ratings?filter=highest
    public void testShouldGetServiceWithHighestRatings() throws InvalidArgumentException {

        ServiceProviderController serviceProviderController = new ServiceProviderController();

        int categoryId = 1;
        String filter = "highest";
        List<ServiceProvider> serviceProviderList = serviceProviderController.getServicesRankingsByServiceCategory(categoryId, filter);

        assertThat(serviceProviderList, is(notNull()));
    }

    @Test
    //services/{ServiceId}/
    public void testShouldGetServiceById() throws InvalidArgumentException {

        ServiceProviderController serviceProviderController = new ServiceProviderController();

        long serviceId = 1L;
        ServiceProvider serviceProviderList = serviceProviderController.getProviderById(serviceId);

        assertThat(serviceProviderList, is(notNull()));
    }


    @Test
    //services/{serviceId}/distance
    public void testShouldBeAbleToGetClosestServices()  {

        ServiceProviderController serviceProviderController = new ServiceProviderController();

        //services/category/
        UserServiceRequest userLocation = new UserServiceRequest();
        userLocation.setLongitude(20.3);
        userLocation.setLatitude(20.3);
        userLocation.setRadiusInKilometers(10);
        userLocation.setServiceId(3);

        List<ServiceProvider> serviceProviderList = serviceProviderController.getClosestServiceProvider(userLocation);
        assertThat(serviceProviderList,is(notNull()));
    }


}
