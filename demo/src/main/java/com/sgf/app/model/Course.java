package com.sgf.app.model;

import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String institution;
    private int totalClasses;
    private int allowedAbsences;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Course() {}

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }

    public int getTotalClasses() { return totalClasses; }
    public void setTotalClasses(int totalClasses) { this.totalClasses = totalClasses; }

    public int getAllowedAbsences() { return allowedAbsences; }
    public void setAllowedAbsences(int allowedAbsences) { this.allowedAbsences = allowedAbsences; }

    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }
}