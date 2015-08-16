package provider.services;

import provider.domain.ServiceProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProviderService {
    List<ServiceProvider> findAll();
    ServiceProvider fineOneServiceProvider(Long id);
}
