package com.app.todo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "todo", schema = "tododb", uniqueConstraints = { @UniqueConstraint(name="phonenumber_unique", columnNames = "phonenumber") })
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "description")
    private String description;

    @Column(name = "isdone")
    private boolean isDone;

    @Column(name="phonenumber", nullable = false)
    private Long phonenumber;

    public Todo() {
    }

    public Todo(Long id, String username, String description, boolean isDone, long phonenumber) {
        this.id = id;
        this.userName = username;
        this.description = description;
        this.isDone = isDone;
        this.phonenumber = phonenumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return isDone == todo.isDone && Objects.equals(id, todo.id) && Objects.equals(userName, todo.userName) && Objects.equals(description, todo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, description, isDone);
    }
}
