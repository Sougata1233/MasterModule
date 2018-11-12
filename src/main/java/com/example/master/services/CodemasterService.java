package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.master.dto.CodemasterDTO;
import com.example.master.dto.DeleteDTO;

public interface CodemasterService {

	// public ResponseEntity<ActivityDTO> getUser(String username);

	public ResponseEntity<CodemasterDTO> persistUser(CodemasterDTO user);

	public CodemasterDTO populateOneCodemasterDetails(String userId);

	public List<CodemasterDTO> populateCodemasterList();

	public DeleteDTO destroyCodemaster(String userId);
	
	public List<CodemasterDTO> getCodeMasterByCodeType();

	// public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

	ResponseEntity<CodemasterDTO> updateCodemaster(CodemasterDTO codemasterDTO);

}
