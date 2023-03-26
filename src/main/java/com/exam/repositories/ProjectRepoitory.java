package com.exam.repositories;

import com.exam.entities.Project;
import com.exam.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProjectRepoitory extends JpaRepository<Project,Integer> {

    List<Project> findProjectsBySprintListStartDateGreaterThan(Date todayDate);

    @Query("select p from Project p inner join p.userList userList where userList.fname = ?1 and userList.lname = ?2 and userList.role = ?3")
    List<Project> findProjectsByUserListFnameAndLname(String fname, String lname, Role role);

}
