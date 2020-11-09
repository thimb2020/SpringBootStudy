package com.study.spring.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.spring.domain.Person;

public class CustomizedPersonRepositoryImpl implements CustomizedPersonRepository {

	@Override
	public List<Person> searchByLastNameCustom(String lastName) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(createPerson());
		return persons;
	}

	private Person createPerson() {
		Person person = new Person();
		person.setFirstName("Mai");
		person.setLastName("Thi");
		return person;

	}
}
