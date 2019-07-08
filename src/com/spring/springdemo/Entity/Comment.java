package com.spring.springdemo.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany
    @JoinTable(
            name = "comment_user",
            joinColumns = @JoinColumn(name = "commentId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<User> userList;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "requestId", referencedColumnName = "id", unique = true)
    private Request request;


    public Comment() {
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void addUser(User user){
        if (userList == null){
            userList = new ArrayList<>();
        }
        userList.add(user);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
