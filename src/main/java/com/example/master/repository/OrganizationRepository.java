package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.master.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    List<Organization> findById(Long i);
    
    @Query("select o from Organization o where o.hierarchyId = -1")
    List<Organization> findByHierarchyId();
    
    Organization findByOrgName(String orgName);

}
