package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findById(Long i);
    List<Department> findByDepartmentName(String departmentName);
    List<Department> findByDepartmentNameAndOrgId(String deptName, long orgId);
}
