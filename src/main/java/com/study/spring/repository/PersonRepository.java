package com.study.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findByLastName(String lastName);

}
