package com.spring.springdemo.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // NOT: (cascade = CascadeType.ALL)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "userId", referencedColumnName = "id", unique = true)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "requestId")
    private List<Comment> commentList;

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


    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void addComment(Comment comment) {

        if (commentList == null) {
            commentList = new ArrayList<>();
        }

        commentList.add(comment);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", user=" + user +
                ", commentList=" + commentList +
                ", teamDirectedTo='" + teamDirectedTo + '\'' +
                ", rule='" + rule + '\'' +
                ", message='" + message + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
