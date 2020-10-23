package com.study.spring.repository;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.study.spring.domain.Person;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PersonRepositoryTest {
	@Autowired
	private PersonRepository personRepository;

	@Test
	public void saveTest() {
		Person person = createPerson();
		person = personRepository.save(person);
		assertTrue(person.getId() > 0);
	}

	@Test
	public void findByLastNameTest() {
		Person person = createPerson();
		person = personRepository.save(person);
		List<Person> persons = personRepository.findByLastName("Thi");
		assertTrue(persons.size() > 0);
	}

	@Test
	public void findByFirstNameTest() {
		Person person = createPerson();
		person = personRepository.save(person);
		List<Person> persons = personRepository.findByFirstName("Mai");
		assertTrue(persons.size() > 0);
	}

	@Test
	public void findByLastNamePageableTest() {
		savePersons();
		Pageable pageable = PageRequest.of(2, 10);
		Page<Person> personsPageable = personRepository.findByLastName("Thi", pageable);
		assertTrue(personsPageable.getContent().get(0).getFirstName().equals("Mai20"));
	}

	@Test
	public void findByLastNameSortTest() {
		savePersons();
		Sort sort = Sort.by("firstName").descending();
		List<Person> personsPageable = personRepository.findByLastName("Thi", sort);
		assertTrue(personsPageable.get(0).getFirstName().equals("Mai9"));
	}

	private Person createPerson() {
		Person person = new Person();
		person.setFirstName("Mai");
		person.setLastName("Thi");
		return person;

	}

	private List<Person> savePersons() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Person person = new Person();
			person.setFirstName("Mai" + i);
			person.setLastName("Thi");
			person = personRepository.save(person);
			persons.add(person);

		}
		return persons;
	}

}
