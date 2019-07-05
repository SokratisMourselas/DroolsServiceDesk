package com.spring.springdemo.Model;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // NOT: (cascade = CascadeType.ALL)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "userId", referencedColumnName = "id", unique = true)
    private User user;

    @Column(name = "teamDirectedTo")
    private String teamDirectedTo;

    @Column(name = "rule")
    private String rule;

    @Column(name = "message")
    private String message;

    @Column(name = "project")
    private String projectName;

    public Request() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", user=" + user +
                ", teamDirectedTo='" + teamDirectedTo + '\'' +
                ", rule='" + rule + '\'' +
                ", message='" + message + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
