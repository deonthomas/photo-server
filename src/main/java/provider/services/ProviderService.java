package provider.services;

import provider.domain.Provider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProviderService {
    List<Provider> findAll();
    Provider fineOneServiceProvider(Long id);
}
