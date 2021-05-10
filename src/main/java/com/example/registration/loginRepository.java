package com.example.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface loginRepository extends JpaRepository<Register,Integer> {
    List<Register> findByFirstName(String name);
    List<Register> findAll();
   // List<RegisterTable> findByLastName(String lastName);

}
