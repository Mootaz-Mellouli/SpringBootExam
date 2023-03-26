package com.exam.services;

import com.exam.entities.Project;
import com.exam.entities.User;
import com.exam.repositories.ProjectRepoitory;
import com.exam.repositories.SprintRepository;
import com.exam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainServiceImp implements IMainService {
    private final ProjectRepoitory projectRepoitory;
    private final UserRepository userRepository;
    private final SprintRepository sprintRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projectRepoitory.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        Assert.notNull(project,"project not found");
        Assert.notNull(user,"user not found");
        List<Project> projects = new ArrayList<>();
        projects.add(project);
        user.setProjects(projects);
    }

    @Override
    @Transactional
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
       User user = userRepository.findUserByFnameAndLname(firstName,lastName);
       Assert.notNull(user,"user not found");
       Project project = projectRepoitory.findById(projectId).orElse(null);
       Assert.notNull(project," project not found");
       List<Project> projects= new ArrayList<>();
       projects.add(project);
       user.setProjects(projects);
    }

    @Override
    public List<Project> getAllCurrentProject() {
        Date dateToday = new Date();
        return projectRepoitory.findProjectsBySprintListStartDateGreaterThan(dateToday);
    }

    @Override
    @Transactional
    public Project addPrject(Project project) {
        projectRepoitory.saveAndFlush(project);
        project.getSprintList().forEach(sprint -> {
            sprintRepository.saveAndFlush(sprint);
            sprint.setProject(project);
        });
        return project;
    }
}
