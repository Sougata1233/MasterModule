package com.example.master.dto.UserHierDTO;

import java.util.List;

public class PrjSuperHierDTO {

	private UserHierDTO prjsupervisor;
	private List<PriSuperHierDTO> prjsupervisors;
	
	public UserHierDTO getPrjsupervisor() {
		return prjsupervisor;
	}
	public void setPrjsupervisor(UserHierDTO prjsupervisor) {
		this.prjsupervisor = prjsupervisor;
	}
	public List<PriSuperHierDTO> getPrjsupervisors() {
		return prjsupervisors;
	}
	public void setPrjsupervisors(List<PriSuperHierDTO> prjsupervisors) {
		this.prjsupervisors = prjsupervisors;
	}
}
