package com.muselab.sample.jpa.querydsl.domain;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    private long empId;

    private String name;

    private String teamId;

    @ManyToOne
    @JoinColumn(name="teamId", insertable = false, updatable = false)
    private Team team;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
