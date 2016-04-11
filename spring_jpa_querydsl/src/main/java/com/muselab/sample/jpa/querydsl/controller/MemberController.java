package com.muselab.sample.jpa.querydsl.controller;

import com.muselab.sample.jpa.querydsl.domain.Employee;
import com.muselab.sample.jpa.querydsl.domain.Team;
import com.muselab.sample.jpa.querydsl.service.EmployeeService;
import com.muselab.sample.jpa.querydsl.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployee() {

        List<Employee> employeeList = employeeService.findAll();
        if (employeeList == null || employeeList.size() == 0) return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        System.out.println("id=" + id);

        Employee employee = employeeService.findById(id);
        if (employee == null) return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

        Employee employee1 = employeeService.findById(employee.getEmpId());
        if(employee1 != null) return new ResponseEntity<Employee>(HttpStatus.CONFLICT);

        employeeService.save(employee);

        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

        System.out.println("employee="+employee.toString());
        Employee employee1 = employeeService.findById(employee.getEmpId());

        System.out.println("employee1="+employee.toString());

        if(employee1 == null) return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

        employee1.setName(employee.getName());
        employeeService.save(employee1);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        Employee employee1 = employeeService.findById(id);

        if(employee1 == null) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        employeeService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping("/team/insert")
    public Team saveTeam(@RequestBody Team team) {
        return teamService.save(team);
    }
}
