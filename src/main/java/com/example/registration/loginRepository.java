package com.example.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface loginRepository extends JpaRepository<Register,Long> {

}
