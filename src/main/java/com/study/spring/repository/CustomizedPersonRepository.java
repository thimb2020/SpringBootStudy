package com.study.spring.repository;

import java.util.List;

import com.study.spring.domain.Person;

public interface CustomizedPersonRepository {
	List<Person> searchByLastNameCustom(String lastName);
}
