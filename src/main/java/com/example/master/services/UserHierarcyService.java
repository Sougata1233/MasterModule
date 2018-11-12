package com.example.master.services;

import java.util.List;

import com.example.master.dto.UserHierDTO.GroupHeadDTO;
import com.example.master.dto.UserHierDTO.PrjSuperHierDTO;

/*
 * Service Interface for User Hierarchy
 */
public interface UserHierarcyService {
	public List<GroupHeadDTO> hierarchy();
	public List<GroupHeadDTO> hierarchyByUser(long userId);
}
