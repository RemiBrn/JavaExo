package service;

import org.example.demo_jpa.dao.PersonRepository;
import org.example.demo_jpa.entity.Person;

import java.util.List;

public class PersonService {
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(int id) {
        return personRepository.findById(id).orElse(null) ;

    }

    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    public void delete(Person person) {
        personRepository.delete(person);
    }
}
