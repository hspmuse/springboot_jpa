package com.muselab.sample.jpa.querydsl.controller;

import com.muselab.sample.jpa.querydsl.domain.Employee;
import com.muselab.sample.jpa.querydsl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable long id) {
        System.out.println("id=" + id);
        return employeeService.findById(id);
    }

    @RequestMapping("/employee/insert")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return null;
    }

}
