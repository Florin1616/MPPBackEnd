package com.example.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.Model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}