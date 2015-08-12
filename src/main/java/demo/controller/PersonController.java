package demo.controller;


import demo.domain.Person;
import demo.repository.PersonRepository;
import demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personRepository;

    @ResponseBody
    @RequestMapping("/person")
    public List<Person> test() {
        return personRepository.findAll();
    }
}