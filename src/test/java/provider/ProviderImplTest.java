package provider;

import provider.domain.Provider;
import provider.repository.ProviderRepository;
import provider.services.ProviderService;
import provider.services.ProviderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.rmi.server.ExportException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProviderImplTest {

    @Mock
    private ProviderRepository providerRepo;

    private ProviderService userService;

    public void setUp() {
        userService = new ProviderServiceImpl(providerRepo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFindAllProviders() {

        when(providerRepo.findAll()).thenReturn(null);
        ProviderServiceImpl service = new ProviderServiceImpl(providerRepo);
        service.fineOneServiceProvider(null);
    }

}