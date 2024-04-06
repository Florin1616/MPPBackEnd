package com.example.backend.Service;

import com.example.backend.Model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    public PersonService() {
        persons.add(new Person(1, "Richard", 25, "Software Engineer", "Nairobi", "/how_to_become_a_software_engineer.avif"));
        persons.add(new Person(2, "John", 30, "Doctor", "Kisumu", "/126bb5bb843340039d0ba92683ea5e99.jpeg"));
        persons.add(new Person(3, "Jane", 28, "Nurse", "Mombasa", "/istockphoto-1400090330-612x612.jpg"));
        persons.add(new Person(4, "Mary", 35, "Teacher", "Nakuru", "/istockphoto-1292554747-612x612.jpg"));
        persons.add(new Person(5, "Peter", 21, "Student", "Eldoret", "/360_F_182819273_Ig0j1upMGsj2kUcrm9a2OIsotsYsufs3.jpg"));
        persons.add(new Person(6, "Ion", 21, "Student", "Calafat", "/360_F_182819273_Ig0j1upMGsj2kUcrm9a2OIsotsYsufs3.jpg"));
    }

    private List<Person> persons = new ArrayList<>();

    public List<Person> getAllPersons() {
        return persons;
    }

    public Person getPerson(int id) {
        return persons.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    public void addPerson(Person person) {
        int id = generateUniqueId();
        person.setId(id);
        persons.add(person);
    }

    private int generateUniqueId() {
        return persons.stream().mapToInt(Person::getId).max().orElse(0) + 1;
    }
    public void updatePerson(int id, Person updatedPerson) {
        persons = persons.stream().map(person -> person.getId() == id ? updatedPerson : person).collect(Collectors.toList());
    }

    public void deletePerson(int id) {
        persons.removeIf(person -> person.getId() == id);
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + get +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", profession='" + profession + '\'' +
//                ", city='" + city + '\'' +
//                ", image='" + image + '\'' +
//                '}';
//    }
}
