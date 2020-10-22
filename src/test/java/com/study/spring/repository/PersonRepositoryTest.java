package com.study.spring.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.study.spring.domain.Person;	
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PersonRepositoryTest {
	@Autowired
	private PersonRepository personRepository;
	@Test
	public void saveTest() {
		Person person = new Person();
		person.setLastName("Thi");
		person = personRepository.save(person);
		assertTrue(person.getId()>0);
	}
	@Test
	public void findByLastNameTest() {
		Person person = new Person();
		person.setLastName("Thi");
		person = personRepository.save(person);
		List<Person> persons = personRepository.findByLastName("abc");
		assertTrue(persons.size()==1);
	}
	
}
