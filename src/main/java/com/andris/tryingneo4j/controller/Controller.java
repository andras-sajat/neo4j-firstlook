package com.andris.tryingneo4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

import com.andris.tryingneo4j.domain.Person;
import com.andris.tryingneo4j.service.PersonService;

@CrossOrigin()
@RestController
class Controller {

    @Autowired
    private PersonService personService;
   
    @GetMapping(value="/persons")
    public List<Person> findPersons(@RequestParam(value="name", required=false) String partOfName) {
        return personService.findByName(Optional.ofNullable(partOfName));
    }

    @PostMapping(value="/persons")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @DeleteMapping(value="/persons/{id}")
    public void addPerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @PutMapping(value="/persons/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Optional<Person> modifiedPerson = personService.updatePerson(id, person);
        if(modifiedPerson.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   
}