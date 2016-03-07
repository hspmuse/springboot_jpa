package com.muselab.sample.jpa.querydsl.service;

import com.muselab.sample.jpa.querydsl.domain.Employee;
import com.muselab.sample.jpa.querydsl.domain.QEmployee;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployRepository {

    @Autowired
    private EntityManager em;

    public Employee findById(long id) {

        System.out.println("id=" + id);

        JPAQuery query = new JPAQuery(em);
        QEmployee employee = QEmployee.employee;
        Predicate condition = employee.empId.eq(id);
        return query.from(employee).where(condition).uniqueResult(employee);
    }

}
