package provider.services;

import provider.domain.Accreditation;
import provider.domain.ServiceProvider;
import provider.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    public ProviderServiceImpl(){

    }

    @Autowired
    private ProviderRepository personRepository;

    public ProviderServiceImpl(ProviderRepository userRepository) {
        this.personRepository = userRepository;
    }

    @Override
    public List<ServiceProvider> findAll() {
        return personRepository.findAll();
    }

    @Override
    public ServiceProvider fineOneServiceProvider(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public  List<ServiceProvider> getServiceProvidersWithAccreditations(int categoryId) {
        return null;
    }

    @Override
    public List<Accreditation> getServiceProviderAccreditations(int serviceProviderId) {
        return null;
    }
}