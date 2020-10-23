package com.study.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>, PersonRepositoryExtend {
	List<Person> findByLastName(String lastName);
	Page<Person> findByLastName(String lastname, Pageable pageable);
	List<Person> findByLastName(String lastname, Sort sort);
	List<Person> findTop4ByLastName(String lastname);

}
