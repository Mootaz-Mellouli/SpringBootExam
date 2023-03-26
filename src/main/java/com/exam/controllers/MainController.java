package com.exam.controllers;

import com.exam.entities.Project;
import com.exam.entities.User;
import com.exam.services.IMainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final IMainService mainService;

    @PostMapping("/addProject")
    public Project addProject(@RequestBody Project project) {
        return mainService.addPrject(project);
    }
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return mainService.addUser(user);
    }
    @PutMapping("/assignProjectUser/{projectId}/{userId}")
    public void assignProjectToUser (@PathVariable int projectId,@PathVariable int userId){
        mainService.assignProjectToUser(projectId,userId);
    }
    @PutMapping("/assignProjectClient/{projectId}/{firstName}/{lastName}")
    public void assignProjectToClient(@PathVariable int projectId,@PathVariable String firstName,@PathVariable String lastName) {
        mainService.assignProjectToClient(projectId, firstName, lastName);
    }
    @GetMapping("/projectsAlive")
    public List<Project> getAllCurrentProject() {
        return mainService.getAllCurrentProject();
    }
}
