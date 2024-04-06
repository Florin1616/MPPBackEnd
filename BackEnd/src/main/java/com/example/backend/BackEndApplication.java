package com.example.backend;

import com.example.backend.Model.Person;
import com.example.backend.Service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BackEndApplication.class, args);

		// Get the PersonService bean from the application context
		PersonService service = context.getBean(PersonService.class);

		// Print all persons
		List<Person> persons = service.getAllPersons();
		for (Person person : persons) {
			System.out.println(person);
		}
	}
}
