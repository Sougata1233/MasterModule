package com.example.master.services.serviceImpl.userhierarchy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.master.component.UserHierarcyDao;
import com.example.master.dto.UserHDTO;
import com.example.master.dto.UserHierDTO.GroupHeadDTO;
import com.example.master.dto.UserHierDTO.HrManagerDTO;
import com.example.master.dto.UserHierDTO.OrgHeadDTO;
import com.example.master.dto.UserHierDTO.PriSupervisorDTO;
import com.example.master.dto.UserHierDTO.PrjSupervisorDTO;
import com.example.master.entity.User;
import com.example.master.entity.UserHierarchy;
import com.example.master.services.serviceImpl.UserHierarcyServiceImpl;

/*
 * Service class for Fetching hierarchy if the user is present as user
 */

@Service
public class UserHierarchyService {

	@Autowired
	UserHierarcyServiceImpl hierservice;
	
	@Autowired
	UserHierarcyDao hierarcyDao;
	
	/*
	 * Creating User Hierarchy DTO of type array of object GroupHeadDTO 
	 * 
	 * @Param
	 * 
	 * UserHierarchy userHierarchy
	 * 
	 */
	public List<GroupHeadDTO> userhier(UserHierarchy userHierarchy) {
		List<GroupHeadDTO> hierDTOs = new ArrayList<>();
		int count = 0 ;
		
		/*
		 * Fetching user hierarchy table by orghead, hrmanager, prisupervisor, prjsupervisor and user
		 */
		List<UserHierarchy> userhiers = 
				hierarcyDao.getHierarchyByOrgHeadsAndHrManagerAndPriSuperAndPrjSuperAndUser(
						userHierarchy.getOrgHead().getId(),
						userHierarchy.getHrManager().getId(),
						userHierarchy.getPriSupervisor().getId(),
						userHierarchy.getPrjSupervisor().getId(),
						userHierarchy.getUser().getId())
				.stream().distinct().collect(Collectors.toList());
		
		List<OrgHeadDTO> orghds = new ArrayList<>();
		List<HrManagerDTO> hrs = new ArrayList<>();
		List<PriSupervisorDTO> prisuperEmps = new ArrayList<>();
		List<PrjSupervisorDTO> prjDTOs = new ArrayList<>();
		List<UserHDTO> userss = new ArrayList<>();
		
		for(int i = 0 ; i < userhiers.size() ; i++) {
			GroupHeadDTO groupheadDTO = new GroupHeadDTO();
			//setting grouphead element
			groupheadDTO.setGroupHead(hierservice.prepareUserDTO(userhiers.get(i).getGroupHead()));
			
				OrgHeadDTO orghead = new OrgHeadDTO();
				//Setting orghead element
				orghead.setOrgHead(hierservice.prepareUserDTO(userhiers.get(0).getOrgHead()));
				
					HrManagerDTO hrmanager = new HrManagerDTO(); 
					//setting hrmanager element
					hrmanager.setHrManager(hierservice.prepareUserDTO(userhiers.get(0).getHrManager()));
					
						PriSupervisorDTO prisuper = new PriSupervisorDTO();
						//setting prisupervisor
						prisuper.setPriSupervisor(hierservice.prepareUserDTO(userhiers.get(0).getPriSupervisor()));
						
							PrjSupervisorDTO prjsuper = new PrjSupervisorDTO();
							//setting prjsupervisor
							prjsuper.setPrjSupervisor(hierservice.prepareUserDTO(userhiers.get(0).getPrjSupervisor()));
							//preparing userlist 
							userss.add(hierservice.prepareUsersSingleDTO(userhiers.get(0).getUser(), count));
							prjsuper.setUser(userss);
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
