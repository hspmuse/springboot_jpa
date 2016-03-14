package com.muselab.sample.jpa.querydsl.controller;

import com.muselab.sample.jpa.querydsl.domain.Employee;
import com.muselab.sample.jpa.querydsl.domain.Team;
import com.muselab.sample.jpa.querydsl.service.EmployeeService;
import com.muselab.sample.jpa.querydsl.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @RequestMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable long id) {
        System.out.println("id=" + id);
        return employeeService.findById(id);
    }

    @RequestMapping("/employee/insert")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.delete(id);
        return "OK";
    }

    @RequestMapping("/team/insert")
    public Team saveTeam(@RequestBody Team team) {
        return teamService.save(team);
    }
}
