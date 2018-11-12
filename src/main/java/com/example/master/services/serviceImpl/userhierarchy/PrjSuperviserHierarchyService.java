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
 * Service class for user hierarchy if the user is prjsupervisor
 */

@Service
public class PrjSuperviserHierarchyService {

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
	public List<GroupHeadDTO> prjsuperhier(UserHierarchy userHierarchy) {
		List<GroupHeadDTO> hierDTOs = new ArrayList<>();
		int count = 0 ;
		
		/*
		 * Fetching user hierarchy table by orghead, hrmanager, prisupervisor, prjsupervisor and user
		 */
		List<UserHierarchy> prjhiers = 
				hierarcyDao.getHierarchyByOrgHeadsAndHrManagerAndPriSuperAndPrjSuperAndUser(
						userHierarchy.getOrgHead().getId(),
						userHierarchy.getHrManager().getId(),
						userHierarchy.getPriSupervisor().getId(),
						userHierarchy.getPrjSupervisor().getId(),
						userHierarchy.getUser().getId())
				.stream().distinct().collect(Collectors.toList());
		
		List<User> users = new ArrayList<>();
		List<UserHierarchy> prjhierentities = 
				hierarcyDao.getHierarchyByPrjSuperId(userHierarchy.getUser().getId());
		
		users = prjhierentities.stream().map(UserHierarchy::getUser).distinct().collect(Collectors.toList());
		
		List<OrgHeadDTO> orghds = new ArrayList<>();
		List<HrManagerDTO> hrs = new ArrayList<>();
		List<PriSupervisorDTO> prisuperEmps = new ArrayList<>();
		List<PrjSupervisorDTO> prjDTOs = new ArrayList<>();
		
		for(int i = 0 ; i < prjhiers.size() ; i++) {
			GroupHeadDTO groupheadDTO = new GroupHeadDTO();
			//setting grouphead element
			groupheadDTO.setGroupHead(hierservice.prepareUserDTO(prjhiers.get(i).getGroupHead()));
			
				OrgHeadDTO orghead = new OrgHeadDTO();
				//Setting orghead element
				orghead.setOrgHead(hierservice.prepareUserDTO(prjhiers.get(0).getOrgHead()));
				
					HrManagerDTO hrmanager = new HrManagerDTO(); 
					//setting hrmanager element
					hrmanager.setHrManager(hierservice.prepareUserDTO(prjhiers.get(0).getHrManager()));
					
						PriSupervisorDTO prisuper = new PriSupervisorDTO();
						//setting prisupervisor
						prisuper.setPriSupervisor(hierservice.prepareUserDTO(prjhiers.get(0).getPriSupervisor()));
						
							PrjSupervisorDTO prjsuper = new PrjSupervisorDTO();
							//setting prjsupervisor
							prjsuper.setPrjSupervisor(hierservice.prepareUserDTO(prjhiers.get(0).getPrjSupervisor()));
							//preparing userlist 
							prjsuper.setUser(hierservice.prepareUsersDTO(users, count));
							prjDTOs.add(prjsuper);
							
						prisuper.setPrjSupervisor(prjDTOs);
						prisuperEmps.add(prisuper);
					hrmanager.setPriSuperviser(prisuperEmps);
					hrs.add(hrmanager);
					
				orghead.setHrManager(hrs);
				orghds.add(orghead);
			groupheadDTO.setOrgHeadList(orghds);
			
			hierDTOs.add(groupheadDTO);
		}
		
		return hierDTOs;
	}
	
}
