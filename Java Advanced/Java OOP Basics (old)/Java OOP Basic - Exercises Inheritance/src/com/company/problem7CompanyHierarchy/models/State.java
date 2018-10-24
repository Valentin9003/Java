package com.company.problem7CompanyHierarchy.models;

public class State {

    private String state;

    public State(String state) {
        this.setState(state);
    }

    public String getState() {
        return state;
    }

    protected void setState(String state) {
        if (state == null
                || state.length() < 3
                || !state.equals("open ")
                && !state.equals("closed")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.state = state;
    }

    @Override
    public String toString() {
        return "State{" +
                "state='" + state + '\'' +
                '}';
    }
}
