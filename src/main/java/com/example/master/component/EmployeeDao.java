package com.example.master.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.Employee;
import com.example.master.repository.EmployeeRepository;

@Component
public class EmployeeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> findAll() throws Exception {
		return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee findEmployeeById(String id) {
    	return employeeRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmployee(Employee employee) {
    	employeeRepository.save(employee);
    	LOGGER.info("Country added successfully " + employee.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteEmployee(String empId) {
    	employeeRepository.delete(empId);
    	LOGGER.info("Activity with id " + empId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEmployee(Employee employee) {
    	employeeRepository.save(employee);
    	LOGGER.info("Activity added successfully " + employee.toString());
    }
}
