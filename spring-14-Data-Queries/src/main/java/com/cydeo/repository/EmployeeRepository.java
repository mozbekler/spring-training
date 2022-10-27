package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

    //Display all employees with email address

    List<Employee> findByEmail(String email);

    //Display all employees with first name "" and last name ""
    //also show all employees with an email address ""

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ""

    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees with salaries higher than and less than
    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalaryLessThan(Integer salary);





}
