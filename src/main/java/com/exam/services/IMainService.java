package com.exam.services;

import com.exam.entities.Project;
import com.exam.entities.User;

import java.util.List;

public interface IMainService {
    Project addPrject(Project project);
    User addUser(User user);
    void assignProjectToUser (int projectId, int userId);
    void assignProjectToClient(int projectId, String firstName, String lastName);
    List<Project> getAllCurrentProject() ;
}
