package com.revature.Classes;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idx", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Enumerated
    @Column(name = "user_role", nullable = false)
    private Permissions.UserRole userRole;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "initiatedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public Permissions.UserRole getUserRole() {
        return userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean checkPassword(String attempted_password) {
        return this.password.equals(attempted_password);
    }
}