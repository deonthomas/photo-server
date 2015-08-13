package provider.services;

import provider.domain.Provider;
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
    public List<Provider> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Provider fineOneServiceProvider(Long id) {
        return personRepository.findOne(id);
    }
}