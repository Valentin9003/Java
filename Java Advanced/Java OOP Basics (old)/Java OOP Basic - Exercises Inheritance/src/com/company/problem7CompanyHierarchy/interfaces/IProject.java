package com.company.problem7CompanyHierarchy.interfaces;

import com.company.problem7CompanyHierarchy.models.ProjectState;

import java.util.Date;

public interface IProject {

    String name = null;

    String details = null;

    Date startDate = null;

    ProjectState state = null;

    void closeProject();
}
