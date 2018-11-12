package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findById(String i);

}
