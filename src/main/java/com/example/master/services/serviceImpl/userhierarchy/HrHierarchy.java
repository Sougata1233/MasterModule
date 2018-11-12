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
import com.example.master.dto.UserHierDTO.PriSupervisorDTO;
import com.example.master.dto.UserHierDTO.PrjSupervisorDTO;
import com.example.master.entity.User;
import com.example.master.entity.UserHierarchy;
import com.example.master.services.serviceImpl.UserHierarcyServiceImpl;

/*
 * Service class for user hierarchy if the user is hrmanager
 */
@Service
public class HrHierarchy {

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
	public List<GroupHeadDTO> hrhier(UserHierarchy userHierarchy) {
		List<GroupHeadDTO> hierDTOs = new ArrayList<>();
		int count = 0 ;
		
		/*
		 * Fetching user hierarchy table by orghead, hrmanager, prisupervisor, prjsupervisor and user
		 */
		List<UserHierarchy> hrhiers = 
				hierarcyDao.getHierarchyByOrgHeadsAndHrManagerAndPriSuperAndPrjSuperAndUser(
						userHierarchy.getOrgHead().getId(),
						userHierarchy.getHrManager().getId(),
						userHierarchy.getPriSupervisor().getId(),
						userHierarchy.getPrjSupervisor().getId(),
						userHierarchy.getUser().getId())
				.stream().distinct().collect(Collectors.toList());
		
		/*
		 * Fetching User Hierarchy by userid and orgheadid
		 */
		List<UserHierarchy> hrhierentities = hierarcyDao
				.getHierarchyByHrId(userHierarchy.getUser().getId(), userHierarchy.getOrgHead().getId());
		
		List<User> prisupers = hrhierentities
										.stream()
										.map(UserHierarchy::getPriSupervisor)
										.distinct()
										.collect(Collectors.toList());
		List<User> prjsupers = hrhierentities
									.stream()
									.map(UserHierarchy::getPrjSupervisor)
									.distinct()
									.collect(Collectors.toList());
		
		List<User> users = hrhierentities.stream().map(UserHierarchy::getUser).distinct().collect(Collectors.toList());
		
		List<OrgHeadDTO> orghds = new ArrayList<>();
		List<HrManagerDTO> hrs = new ArrayList<>();
		
		for(int i = 0 ; i < hrhiers.size() ; i++) {
			GroupHeadDTO groupheadDTO = new GroupHeadDTO();
			//setting grouphead element
			groupheadDTO.setGroupHead(hierservice.prepareUserDTO(hrhiers.get(i).getGroupHead()));
			
				OrgHeadDTO orghead = new OrgHeadDTO();
				//Setting orghead element
				orghead.setOrgHead(hierservice.prepareUserDTO(hrhiers.get(0).getOrgHead()));
				
					HrManagerDTO hrmanager = new HrManagerDTO(); 
					//setting hrmanager element
					hrmanager.setHrManager(hierservice.prepareUserDTO(hrhiers.get(0).getHrManager()));
					//setting prisupervisor
					hrmanager.setPriSuperviser(hierservice.preparePriSuperDTO(count,
																		prisupers,
																		prjsupers,
																		users,
																		hrhiers.get(0).getUser(),
																		hrhiers.get(0).getOrgHead()
																		));
					hrs.add(hrmanager);
					
				orghead.setHrManager(hrs);
				orghds.add(orghead);
			groupheadDTO.setOrgHeadList(orghds);
			
			hierDTOs.add(groupheadDTO);
		}
		
		return hierDTOs;
	}
	
}
