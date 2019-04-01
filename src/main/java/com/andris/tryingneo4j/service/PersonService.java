package com.andris.tryingneo4j.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.andris.tryingneo4j.domain.Person;
import com.andris.tryingneo4j.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public List<Person> findByName(Optional<String> partialName) {
        return partialName.isEmpty() ? 
            this.findAll() 
            : 
            Lists.newArrayList(repository.findByPartialName(partialName.get()));
    }

    public Person addPerson(Person person) {
        return repository.save(person);
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }

    public Optional<Person> updatePerson(Long id, Person newData) {
        Optional<Person> person = repository.findById(id);
        if(person.isEmpty()) {
            return Optional.ofNullable(null);
        }
        person.get().setBorn(newData.getBorn());
        person.get().setName(newData.getName());
        repository.save(person.get());
        return person;
    }

}