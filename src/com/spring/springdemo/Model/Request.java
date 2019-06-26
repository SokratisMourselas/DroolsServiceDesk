package com.spring.springdemo.Model;

public class Request {

    private User user;

    private String teamDirectedTo;

    private String rule;

    private String message;

    private String projectName;

    public Request() {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTeamDirectedTo() {
        return teamDirectedTo;
    }

    public void setTeamDirectedTo(String teamDirectedTo) {
        this.teamDirectedTo = teamDirectedTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
