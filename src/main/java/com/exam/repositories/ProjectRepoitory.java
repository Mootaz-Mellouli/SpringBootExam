package com.exam.repositories;

import com.exam.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProjectRepoitory extends JpaRepository<Project,Integer> {

    List<Project> findBySprintListStartDateAfter(Date date);// jpa buddy
    // cascade type in master
    // depend du master/slave
    //saveandflush => managedEntity
    // @Query("select p from Project p inner join p.sprintList sprintList where sprintList.startDate > ?1")
    List<Project> findProjectsBySprintListStartDateGreaterThan(Date todayDate);

}
