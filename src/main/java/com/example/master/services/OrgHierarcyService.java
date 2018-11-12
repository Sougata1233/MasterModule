package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.master.dto.UserHierDTO.ParentOrgDTO;
import com.example.master.dto.UserHierDTO.UserHierarcyDTO;

public interface OrgHierarcyService {

	public ResponseEntity<UserHierarcyDTO> getHierarcyById(Long id);
	public List<UserHierarcyDTO> populateHierarcyList();
	public ParentOrgDTO groupHead() ;
	
}
