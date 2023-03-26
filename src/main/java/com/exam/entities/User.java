package com.exam.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String pwd;
    private String fname;
    private String lname;
    @Enumerated
    private Role role;

    @ManyToMany()
    private List<Project> projects;

    @OneToMany
    private List<Project> projectList;
}
