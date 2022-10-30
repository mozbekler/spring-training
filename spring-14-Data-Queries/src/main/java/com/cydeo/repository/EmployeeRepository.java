package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT e.salary FROM Employee e WHERE e.email='bmanueau0@dion.ne.jp'")
    Integer retrieveEmployeeSalary();

    //Not equal
    @Query("SELECT e from Employee e where e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like Contains / Starts with / EndsWith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //LEssThan
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater Than
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    //BETWEEN
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int s1, int s2);

    //BEFORE
    @Query("select e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL ")
    List<Employee> retrieveEmployeeEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL ")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //SORTING ASC and DESC orders
    @Query("SELECT e FROM Employee e order by e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    @Query("SELECT e FROM Employee e order by e.salary DESC")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native Query

    @Query(value = "SELECT * FROM employees WHERE  salary= ?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary( int salary);

    //Named parameter

    @Query("SELECT e FROM Employee e WHERE e.salary= :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);


}
