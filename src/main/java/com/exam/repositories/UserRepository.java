package com.exam.repositories;

import com.exam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByFnameAndLname(String fname,String lname);
}
