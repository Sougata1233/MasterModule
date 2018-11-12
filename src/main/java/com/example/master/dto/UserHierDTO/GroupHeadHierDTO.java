package com.example.master.dto.UserHierDTO;

import java.util.List;

public class GroupHeadHierDTO {

	private UserHierDTO grouphead;
	private List<OrgHeadHierDTO> orghead;
	
	public UserHierDTO getGrouphead() {
		return grouphead;
	}
	public void setGrouphead(UserHierDTO grouphead) {
		this.grouphead = grouphead;
	}
	public List<OrgHeadHierDTO> getOrghead() {
		return orghead;
	}
	public void setOrghead(List<OrgHeadHierDTO> orghead) {
		this.orghead = orghead;
	}
}
