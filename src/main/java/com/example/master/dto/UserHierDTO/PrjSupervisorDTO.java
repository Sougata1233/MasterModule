package com.example.master.dto.UserHierDTO;

import java.util.List;

import com.example.master.dto.UserHDTO;

public class PrjSupervisorDTO {
	
	private UserHierDTO prjSupervisor;
	private List<UserHDTO> user;
	public UserHierDTO getPrjSupervisor() {
		return prjSupervisor;
	}
	public void setPrjSupervisor(UserHierDTO prjSupervisor) {
		this.prjSupervisor = prjSupervisor;
	}
	public List<UserHDTO> getUser() {
		return user;
	}
	public void setUser(List<UserHDTO> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PrjSupervisorDTO [prjSupervisor=" + prjSupervisor + ", user=" + user + "]";
	}
	
	
	

}
