package com.espark.adarsh.cas.persistence.repository;


import com.espark.adarsh.cas.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
