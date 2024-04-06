package com.example.backend.Controller;

import com.example.backend.Model.Person;
import com.example.backend.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entities")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllEntities() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getEntity(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public void createEntity(@RequestBody Person newEntity) {
        personService.addPerson(newEntity);
    }

    @PutMapping("/{id}")
    public void updateEntity(@PathVariable int id, @RequestBody Person updatedEntity) {
        personService.updatePerson(id, updatedEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable int id) {
        personService.deletePerson(id);
    }
}
