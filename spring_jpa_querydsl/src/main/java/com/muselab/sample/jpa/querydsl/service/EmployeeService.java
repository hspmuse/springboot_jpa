package com.muselab.sample.jpa.querydsl.service;

import com.muselab.sample.jpa.querydsl.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployRepository employRepository;

    public List<Employee> findAll() { return employRepository.findAll();}

    public Employee findById(long id) {
        return employRepository.findById(id);
    }

    public Employee save(Employee employee) { return employRepository.save(employee);}

    public void delete(long id) { employRepository.delete(id);}
}
