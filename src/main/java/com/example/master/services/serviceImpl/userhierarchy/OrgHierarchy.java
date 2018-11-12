package com.example.master.services.serviceImpl.userhierarchy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.master.component.UserHierarcyDao;
import com.example.master.dto.UserHierDTO.GroupHeadDTO;
import com.example.master.dto.UserHierDTO.HrManagerDTO;
import com.example.master.dto.UserHierDTO.OrgHeadDTO;
import com.example.master.entity.User;
import com.example.master.entity.UserHierarchy;
import com.example.master.services.serviceImpl.UserHierarcyServiceImpl;

/*
 * Service class for user hierarchy if the user is orghead
 */

@Service
public class OrgHierarchy {

	@Autowired
	UserHierarcyServiceImpl hierservice;
	
	@Autowired
	UserHierarcyDao hierarcyDao;
	
	/*
	 * preparing user hierarchy DTO of type array of object GroupHeadDTO 
	 * 
	 * @Param
	 * 
	 * UserHierarchy userHierarchy
	 * 
	 */
	public List<GroupHeadDTO> orghier(UserHierarchy userHierarchy) {
		List<GroupHeadDTO> hierDTOs = new ArrayList<>();
		int count = 0 ;
		
		/*
		 * Fetching user hierarchy table by orghead, hrmanager, prisupervisor, prjsupervisor and user
		 */
		List<UserHierarchy> orghiers = 
				hierarcyDao.getHierarchyByOrgHeadsAndHrManagerAndPriSuperAndPrjSuperAndUser(
						userHierarchy.getOrgHead().getId(),
						userHierarchy.getHrManager().getId(),
						userHierarchy.getPriSupervisor().getId(),
						userHierarchy.getPrjSupervisor().getId(),
						userHierarchy.getUser().getId())
				.stream().distinct().collect(Collectors.toList());
		
		List<UserHierarchy> orgheadhierentities = hierarcyDao
				.getHierarchyByOrgHeads(userHierarchy.getOrgHead().getId());
		
		List<User> hrmanagers = orgheadhierentities
										.stream()
										.map(UserHierarchy::getHrManager)
										.distinct()
										.collect(Collectors.toList());
		List<User> prisupers = orgheadhierentities
										.stream()
										.map(UserHierarchy::getPriSupervisor)
										.distinct()
										.collect(Collectors.toList());
		List<User> prjsupers = orgheadhierentities
									.stream()
									.map(UserHierarchy::getPrjSupervisor)
									.distinct()
									.collect(Collectors.toList());
		
		List<User> users = orghiers.stream().map(UserHierarchy::getUser).distinct().collect(Collectors.toList());
		
		List<OrgHeadDTO> orghds = new ArrayList<>();
		
		for(int i = 0 ; i < orghiers.size() ; i++) {
			GroupHeadDTO groupheadDTO = new GroupHeadDTO();
			//setting grouphead element
			groupheadDTO.setGroupHead(hierservice.prepareUserDTO(userHierarchy.getGroupHead()));
			
				OrgHeadDTO orghead = new OrgHeadDTO();
				//Setting orghead element
				orghead.setOrgHead(hierservice.prepareUserDTO(orghiers.get(0).getOrgHead()));
				
					HrManagerDTO hrmanager = new HrManagerDTO(); 
					hrmanager.setHrManager(hierservice.prepareUserDTO(orghiers.get(i).getHrManager()));
					//setting hrmanager element
					orghead.setHrManager(hierservice.prepareHrManagerDTO(count,
																hrmanagers,
																prisupers,
																prjsupers,
																users,
																userHierarchy.getUser()));	
				orghds.add(orghead);
			groupheadDTO.setOrgHeadList(orghds);
			
			hierDTOs.add(groupheadDTO);
		}
	
		return hierDTOs;
	}
	
}
