package com.example.master.dto.UserHierDTO;

import java.util.List;

public class PriSuperHierDTO {

	private UserHierDTO prisupervisor;
	private List<PrjSuperHierDTO> prjsupervisors;
	
	public UserHierDTO getPrisupervisor() {
		return prisupervisor;
	}
	public void setPrisupervisor(UserHierDTO prisupervisor) {
		this.prisupervisor = prisupervisor;
	}
	public List<PrjSuperHierDTO> getPrjsupervisors() {
		return prjsupervisors;
	}
	public void setPrjsupervisors(List<PrjSuperHierDTO> prjsupervisors) {
		this.prjsupervisors = prjsupervisors;
	}
}
