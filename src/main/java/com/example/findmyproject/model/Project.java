package com.example.findmyproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int projectId;

    @Column(name = "name")
    private String projectName;

    @Column(name = "budget")
    private double budget;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonIgnoreProperties("projects")
    @JoinTable(name = "researcher_project", joinColumns = @JoinColumn(name = "projectid"), inverseJoinColumns = @JoinColumn(name = "researcherid"))
    private List<Researcher> researchers;

    // Getters and Setters

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Researcher> getResearchers() {
        return researchers;
    }

    public void setResearchers(List<Researcher> researchers) {
        this.researchers = researchers;
    }
}