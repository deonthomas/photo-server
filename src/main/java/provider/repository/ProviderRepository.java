package provider.repository;

import provider.domain.ServiceProvider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends CrudRepository<ServiceProvider, Long> {

    List<ServiceProvider> findAll();
}