package com.example.master.dto;

import java.util.List;

import com.example.master.dto.UserHierDTO.UserHierDTO;

public class UserHDTO {

	UserHierDTO user;

	public UserHierDTO getUser() {
		return user;
	}

	public void setUser(UserHierDTO userDTO) {
		this.user = userDTO;
	}

	public UserHDTO(UserHierDTO user) {
		super();
		this.user = user;
	}

	public UserHDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserHDTO [user=" + user + "]";
	}
	
	
	
}
