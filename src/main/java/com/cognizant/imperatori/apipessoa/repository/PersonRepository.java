package com.cognizant.imperatori.apipessoa.repository;

import com.cognizant.imperatori.apipessoa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
