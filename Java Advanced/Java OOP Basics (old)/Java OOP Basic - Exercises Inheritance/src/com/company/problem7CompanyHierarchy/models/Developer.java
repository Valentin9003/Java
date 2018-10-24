package com.company.problem7CompanyHierarchy.models;

import com.company.problem7CompanyHierarchy.interfaces.IDeveloper;

import java.util.HashSet;
import java.util.Set;

public class Developer extends RegularEmployee implements IDeveloper {

    private Set<Project> projects;

    public Developer(String id, String firstName, String lastName, Department department, double salary) {
        super(id, firstName, lastName, department, salary);
        this.projects = new HashSet<>();
    }

    @Override
    public void addProject(HashSet<Project> projects) {
        this.projects.addAll(projects);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "projects=" + projects +
                '}';
    }
}
