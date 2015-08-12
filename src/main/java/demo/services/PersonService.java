package demo.services;

import demo.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService  {
    List<Person> findAll();
}
