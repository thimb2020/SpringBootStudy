package com.study.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.spring.domain.Person;
import com.study.spring.repository.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	List<Person> findByLastName(String lastName) {
		List<Person> persons = personRepository.findByLastName("Thi");
		return persons;
	}
}
