package demo.repository;

import demo.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();
}