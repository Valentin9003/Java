package json.processing.service.personService;

import json.processing.model.entity.Person;
import json.processing.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void create(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> findByCountry(String country) {
        return this.personRepository.findByCountry(country);
    }
}
