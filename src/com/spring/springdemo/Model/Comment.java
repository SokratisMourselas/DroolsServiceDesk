package com.spring.springdemo.Model;

import javax.persistence.*;
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


    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
