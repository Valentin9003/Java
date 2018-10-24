package com.company.problem7CompanyHierarchy.interfaces;

import com.company.problem7CompanyHierarchy.models.Project;

import java.util.HashSet;
import java.util.Set;

public interface IDeveloper {

    Set<Project> projects = new HashSet<>();

    void addProject(HashSet<Project> projects);

    String toString();
}
