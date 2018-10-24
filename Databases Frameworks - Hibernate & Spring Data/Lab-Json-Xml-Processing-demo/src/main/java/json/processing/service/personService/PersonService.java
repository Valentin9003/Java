package json.processing.service.personService;

import json.processing.model.entity.Person;

import java.util.List;

public interface PersonService {

    void create (Person person);

    List<Person> findByCountry(String country);
}
