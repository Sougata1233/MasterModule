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

import com.example.master.entity.Department;
import com.example.master.repository.DepartmentRepository;

@Component
public class DepartmentDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public List<Department> findAll() throws Exception {
    	LOGGER.info("DATASOURCE = " + dataSource);
		return departmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Department findDepartmentById(Long id) {
    	return departmentRepository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public List<Department> findDepartmentByIdList(Long id) {
    	return departmentRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addDepartment(Department department) {
    	departmentRepository.save(department);
    	LOGGER.info("Department added successfully " + department.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDepartment(Long departmentId) {
    	departmentRepository.delete(departmentId);
    	LOGGER.info("Department with id " + departmentId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateDepartment(Department department) {
    	departmentRepository.save(department);
    	LOGGER.info("Department added successfully " + department.toString());
    }
    
    @Transactional 
    public boolean isExists(String string) {
    	return departmentRepository.exists(Long.valueOf(string));
    }
    
    @Transactional 
    public List<Department> findByDepartmentName(String departmentName) {
    	return departmentRepository.findByDepartmentName(departmentName);
    }
    
    @Transactional
    public List<Department> findByDeptNameAndOrgId(String deptName, long orgId) {
    	return departmentRepository.findByDepartmentNameAndOrgId(deptName, orgId);
    }
}
