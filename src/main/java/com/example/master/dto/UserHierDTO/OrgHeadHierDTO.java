package com.example.master.dto.UserHierDTO;

import java.util.List;

public class OrgHeadHierDTO {

	private UserHierDTO orghead;
	private List<HrManagerHierDTO> hrmanagers;
	
	public UserHierDTO getOrghead() {
		return orghead;
	}
	public void setOrghead(UserHierDTO orghead) {
		this.orghead = orghead;
	}
	public List<HrManagerHierDTO> getHrmanagers() {
		return hrmanagers;
	}
	public void setHrmanagers(List<HrManagerHierDTO> hrmanagers) {
		this.hrmanagers = hrmanagers;
	}
}
