package com.example.master.dto.UserHierDTO;

import java.util.List;

public class HrManagerHierDTO {

	private UserHierDTO hrmanager;
	private List<PriSuperHierDTO> prisupervisors;
	
	public UserHierDTO getHrmanager() {
		return hrmanager;
	}
	public void setHrmanager(UserHierDTO hrmanager) {
		this.hrmanager = hrmanager;
	}
	public List<PriSuperHierDTO> getPrisupervisors() {
		return prisupervisors;
	}
	public void setPrisupervisors(List<PriSuperHierDTO> prisupervisors) {
		this.prisupervisors = prisupervisors;
	}
	
}
