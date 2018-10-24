package com.company.problem7CompanyHierarchy.models;

import com.company.problem7CompanyHierarchy.interfaces.IProject;

import java.util.Calendar;

public class Project implements IProject {

    private String projectName;
    private Calendar projectStartDate;
    private String details;
    private ProjectState state;

    public Project(String projectName, Calendar projectStartDate, String details) {
        this.setProjectName(projectName);
        this.setProjectStartDate(projectStartDate);
        this.setDetails(details);
        this.state = ProjectState.open;
    }

    public String getProjectName() {
        return projectName;
    }

    private void setProjectName(String projectName) {
        if (projectName == null || projectName.length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.projectName = projectName;
    }

    public Calendar getProjectStartDate() {
        return projectStartDate;
    }

    private void setProjectStartDate(Calendar projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public String getDetails() {
        return details;
    }

    private void setDetails(String details) {
        if (details == null || details.length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.details = details;
    }

    public ProjectState getState() {
        return state;
    }

    @Override
    public void closeProject() {
        this.state = ProjectState.close;
    }
}
