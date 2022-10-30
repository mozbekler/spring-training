package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    //Display all the employees that has been hired between dates

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to "" in salary order

    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than

    List<Employee> findTop3BySalaryLessThan(Integer salary);

    //Display all without email
    List<Employee> findByEmailIsNull();

    @Query("SELECT e from Employee e where e.email='bmanueau0@dion.ne.jp'")
    Employee retrieveEmployee();



}
