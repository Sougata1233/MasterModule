package com.example.master.services.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.master.component.LocationMasterDao;
import com.example.master.component.OrganizationDao;
import com.example.master.component.UserDao;
import com.example.master.component.UserHierarcyDao;
import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.DesignationDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.dto.UserHDTO;
import com.example.master.dto.UserHierDTO.GroupHeadDTO;
import com.example.master.dto.UserHierDTO.HrManagerDTO;
import com.example.master.dto.UserHierDTO.OrgHeadDTO;
import com.example.master.dto.UserHierDTO.PriSupervisorDTO;
import com.example.master.dto.UserHierDTO.PrjSupervisorDTO;
import com.example.master.dto.UserHierDTO.UserHierDTO;
import com.example.master.entity.User;
import com.example.master.entity.UserHierarchy;
import com.example.master.services.UserHierarcyService;
import com.example.master.services.serviceImpl.userhierarchy.HrHierarchy;
import com.example.master.services.serviceImpl.userhierarchy.OrgHierarchy;
import com.example.master.services.serviceImpl.userhierarchy.PriSupervisorHierarchyService;
import com.example.master.services.serviceImpl.userhierarchy.PrjSuperviserHierarchyService;
import com.example.master.services.serviceImpl.userhierarchy.UserHierarchyService;

/*
 * Service class for User Hierarchy
 */
@Service
public class UserHierarcyServiceImpl implements UserHierarcyService {
	
	@Autowired
	UserHierarcyDao hierarcyDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrganizationDao orgDao;
	
	@Autowired
	LocationMasterDao locationDao;
	
	@Autowired
	OrgHierarchy orghierservice;
	
	@Autowired
	HrHierarchy hrhierservice;
	
	@Autowired
	PriSupervisorHierarchyService prisuperService;
	
	@Autowired
	PrjSuperviserHierarchyService prjsuperhierarchyService;
	
	@Autowired
	UserHierarchyService userhierService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserHierarcyServiceImpl.class);

	//preparing user DTO
	public UserHierDTO prepareUserDTO(User userEntity) {
		UserHierDTO userDTO = new UserHierDTO();
		
		userDTO.setAlternateEmail(userEntity.getAlternateEmail());
		userDTO.setDateOfBirth(userEntity.getDateOfBirth());
		DepartmentDTO deptDO = new DepartmentDTO();
		try {
		    deptDO.setdepartmentName(userEntity.getDepartment().getdepartmentName());
		    deptDO.setId(userEntity.getDepartment().getId());

		    OrganizationDTO orgDTO = new OrganizationDTO();
		    orgDTO.setId(userEntity.getDepartment().getOrganization().getId());
		    orgDTO.setHierarchyId(userEntity.getDepartment().getOrganization().getHierarchyId());
		    orgDTO.setorgName(userEntity.getDepartment().getOrganization().getorgName());
		    
		    deptDO.setOrganization(orgDTO);
		    userDTO.setDepartment(deptDO);
		    userDTO.setOrganization(orgDTO);
		} catch (Exception e) {
		    LOGGER.error("error in getting organization/department of user {} {}", userEntity.getUserName(),
			    e.getMessage());
		}
		try {
		    DesignationDTO desigDTO = new DesignationDTO();

		    desigDTO.setDesig(userEntity.getDesignation().getDesig());
		    desigDTO.setId(userEntity.getDesignation().getId());
		    userDTO.setDesignation(desigDTO);
		} catch (Exception e) {
		    LOGGER.error("error in getting designation of user {} {}", userEntity.getUserName(), e.getMessage());
		}
		
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setId(userEntity.getId());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setMobile(userEntity.getMobile());
		userDTO.setTypeOfEmployment(userEntity.getTypeOfEmployment());
		
		//getting user image
		int usrImgLength;
		try {
			if(userEntity.getUserImg() != null) {
			usrImgLength = (int) userEntity.getUserImg().length();
//			System.out.println(usrImgLength);
			if(0 != usrImgLength) {
				userDTO.setUserImg(userEntity.getUserImg().getBytes(1, usrImgLength));
			}else {
				userDTO.setUserImg(null);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		userDTO.setUserName(userEntity.getUserName());
		
		return userDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.UserHierarcyService#hierarchy()
	 * 
	 * Service For Creating Org Hierarchy Structure
	 * 
	 */
	@Override
	public List<GroupHeadDTO> hierarchy() {
		List<GroupHeadDTO> grphd = new ArrayList<>();
		
		long start = Calendar.getInstance().getTimeInMillis();
		int count = 0 ;
		List<UserHierarchy> hierarchies = hierarcyDao.getAllHierarcy();
		count++;
		List<User> grphds = 
				hierarchies
						.stream()
						.map(UserHierarchy::getGroupHead)
						.distinct()
						.collect(
								Collectors
								.toList());
		List<User> orghds =
				hierarchies
						.stream()
						.map(UserHierarchy::getOrgHead)
						.distinct()
						.collect(
								Collectors
								.toList());
		List<User> hrmanagers =
				hierarchies
						.stream()
						.map(UserHierarchy::getHrManager)
						.distinct()
						.collect(
								Collectors
								.toList());
		List<User> prisuper = 
				hierarchies
						.stream()
						.map(UserHierarchy::getPriSupervisor)
						.distinct()
						.collect(
								Collectors
								.toList());
		List<User> prjsuper =
				hierarchies
						.stream()
						.map(UserHierarchy::getPrjSupervisor)
						.distinct()
						.collect(
								Collectors
								.toList());
		List<User> user =
				hierarchies
						.stream()
						.map(UserHierarchy::getUser)
						.distinct()
						.collect(
								Collectors
								.toList());
		
		int gophdrsize = grphds.size();
		for(int i = 0; i < gophdrsize; i++) {
			GroupHeadDTO grphd2 = new GroupHeadDTO();
			grphd2.setGroupHead(prepareUserDTO(grphds.get(i)));
			grphd2.setOrgHeadList(prepareOrgHeadDTO(grphds.get(i),orghds,hrmanagers,prisuper,prjsuper,user,count));
			grphd.add(grphd2);
		}
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("out "+(end-start));
		return grphd;
	}


	/*
	 * preparing DTO for Org Heads
	 * 
	 * @Param
	 * 
	 * List<User> orghds, List<User> hrmanagers, List<User> prisuper, List<User> prjsuper, List<User> user
	 * 
	 */
	private List<OrgHeadDTO> prepareOrgHeadDTO(User grphead, List<User> orghds, List<User> hrmanagers, 
												List<User> prisuper, List<User> prjsuper, List<User> user, int count) {
		
		List<OrgHeadDTO> orgheads = new ArrayList<>();
		int orghdrsize = orghds.size();
		for(int i = 0 ; i < orghdrsize ; i++) {
			OrgHeadDTO orghead = new OrgHeadDTO();
			
			List<UserHierarchy> orgheadhier = 
												hierarcyDao.getHierarchyByOrgHeadsAndGroupHead(orghds.get(i).getId(),
														grphead.getId());
			count++;
			List<User> hrmngrs = orgheadhier
											.stream()
											.map(UserHierarchy::getHrManager)
											.distinct()
											.collect(Collectors.toList());
			
			orghead.setHrManager(prepareHrManagerDTO(count,hrmngrs,prisuper,prjsuper,user,orghds.get(i)));
			orghead.setOrgHead(prepareUserDTO(orghds.get(i)));
			orgheads.add(orghead);
		}
		return orgheads;
	}

	/*
	 * Preparing DTO for Hr Manager
	 * 
	 * @Param
	 * 
	 * List<User> hrmanagers, List<User> prisuper, List<User> prjsuper, List<User> user, User orghead
	 * 
	 */
	public List<HrManagerDTO> prepareHrManagerDTO(int count, List<User> hrmanagers, 
														List<User> prisuper, List<User> prjsuper, List<User> user, 
														User orghead) {
		
		List<HrManagerDTO> hrmanagerDTOs = new ArrayList<>();
		int hrmanagersize = hrmanagers.size();
		for(int i = 0 ; i < hrmanagersize ; i++) {
			HrManagerDTO hr = new HrManagerDTO();
			hr.setHrManager(prepareUserDTO(hrmanagers.get(i)));
			List<UserHierarchy> hrhier =
										hierarcyDao.getHierarchyByOrgHeadsAndHrManager(orghead.getId(),
												hrmanagers.get(i).getId());
			count++;
			List<User> prisupers = hrhier
										.stream()
										.map(UserHierarchy::getPriSupervisor)
										.distinct()
										.collect(Collectors.toList());
			hr.setPriSuperviser(preparePriSuperDTO(count,prisupers,prjsuper,user,hrmanagers.get(i),orghead));
			hrmanagerDTOs.add(hr);
		}
		return hrmanagerDTOs;
	}

	/*
	 * Preparing DTO for Primary Supervisor
	 * 
	 * @Param
	 * 
	 * List<User> prisuper, List<User> prjsuper, List<User> user, User hr, User orghead
	 * 
	 */
	public List<PriSupervisorDTO> preparePriSuperDTO(int count, List<User> prisuper,
														List<User> prjsuper, List<User> user, User hr, User orghead) {
		
		List<PriSupervisorDTO> prsupers = new ArrayList<>();
		int prisupersize = prisuper.size();
		for(int i = 0 ; i < prisupersize ; i++) {
			PriSupervisorDTO psuper = new PriSupervisorDTO();
			psuper.setPriSupervisor(prepareUserDTO(prisuper.get(i)));
			List<UserHierarchy> prihier = 
										hierarcyDao.getHierarchyByOrgHeadsAndHrManagerAndPriSuper(orghead.getId(),
												hr.getId(),prisuper.get(i).getId());
			count++;
			List<User> prjsupers = prihier
											.stream()
											.map(UserHierarchy::getPrjSupervisor)
											.distinct()
											.collect(Collectors.toList());
			psuper.setPrjSupervisor(preparePrjSuperDTO(count,prjsupers,user,orghead,hr,prisuper.get(i)));
			prsupers.add(psuper);
			System.out.println("prihier size "+prihier.size());
			System.out.println("prjsupers size "+prjsupers.size());
		}
		
		return prsupers;
	}

	/*
	 * Preparing DTO for Project Supervisor
	 * 
	 * @Param
	 * 
	 * List<User> prjsuper, List<User> user, User orghead, User hr, User prisuper
	 * 
	 */
	public List<PrjSupervisorDTO> preparePrjSuperDTO(int count, List<User> prjsuper,
														List<User> user, User orghead, User hr, User prisuper) {
		
		List<PrjSupervisorDTO> prjs = new ArrayList<>();
		int prjsupersize = prjsuper.size();
		for(int i = 0 ; i < prjsupersize ; i++) {
			PrjSupervisorDTO pr = new PrjSupervisorDTO();
			pr.setPrjSupervisor(prepareUserDTO(prjsuper.get(i)));
			List<UserHierarchy> prjhier = 
										hierarcyDao.getHierarchyByOrgHeadsAndHrManagerAndPriSuperAndPrjSuper(
												orghead.getId(),hr.getId(),prisuper.getId(),prjsuper.get(i).getId());
			count++;
			List<User> users = prjhier
										.stream()
										.map(UserHierarchy::getUser)
										.distinct()
										.collect(Collectors.toList());
			pr.setUser(prepareUsersDTO(users,count));
			prjs.add(pr);
		}
		return prjs;
	}

	/*
	 * Preparing DTO for User
	 * 
	 * @Param
	 * 
	 * List<User> user
	 * 
	 */
	public List<UserHDTO> prepareUsersDTO(List<User> user, int count) {
		List<UserHDTO> users = new ArrayList<>();
		int usersize = user.size();
		for(int i = 0 ; i < usersize ; i++) {
			UserHDTO userd = new UserHDTO();
			System.out.println(i);
			userd.setUser(prepareUserDTO(user.get(i)));
			users.add(userd);
		}
		System.out.println("count "+count);
		return users;
	}
	
	public UserHDTO prepareUsersSingleDTO(User user, int count) {
		
		UserHDTO userd = new UserHDTO();
		
		userd.setUser(prepareUserDTO(user));
		
		return userd;
	}

	@Override
	public List<GroupHeadDTO> hierarchyByUser(long userId) {
		List<GroupHeadDTO> hierarchyDTOs = new ArrayList<>();
		int count = 0;
		List<UserHierarchy> hierarchies = hierarcyDao.getHierarchyByUser(userId);
		List<UserHierarchy> allhierarchies = hierarcyDao.getAllHierarcy();
		
		List<User> orgs = allhierarchies
									.stream()
									.map(UserHierarchy::getOrgHead)
									.distinct()
									.collect(Collectors.toList());
		List<Long> orgids = orgs
								.stream()
								.map(User::getId)
								.collect(Collectors.toList());
		
		List<User> prisuper = allhierarchies
										.stream()
										.map(UserHierarchy::getPriSupervisor)
										.distinct()
										.collect(Collectors.toList());
		List<Long> prisuperids = prisuper
									.stream()
									.map(User::getId)
									.collect(Collectors.toList());
		
		List<User> prjsuper = allhierarchies
										.stream()
										.map(UserHierarchy::getPrjSupervisor)
										.distinct()
										.collect(Collectors.toList());
		List<Long> prjsuperids = prjsuper
									.stream()
									.map(User::getId)
									.collect(Collectors.toList());
		
		List<User> hrmanager = allhierarchies
										.stream()
										.map(UserHierarchy::getHrManager)
										.distinct()
										.collect(Collectors.toList());
		List<Long> hrids = hrmanager
								.stream()
								.map(User::getId)
								.collect(Collectors.toList());
		
		List<User> grphd = allhierarchies
									.stream()
									.map(UserHierarchy::getGroupHead)
									.distinct()
									.collect(Collectors.toList());
		List<Long> grphdids = grphd
									.stream()
									.map(User::getId)
									.collect(Collectors.toList());
		count++;
		
		for(int i = 0 ; i < hierarchies.size() ; i++) {
			User user = hierarchies.get(i).getUser();
			
			if(prjsuperids.contains(user.getId())) {
				hierarchyDTOs = prjsuperhierarchyService.prjsuperhier(hierarchies.get(i));
				System.out.println("inside prj");
			}else if(prisuperids.contains(user.getId())) {	
				hierarchyDTOs = prisuperService.prisuperhier(hierarchies.get(i));
				System.out.println("inside pri");
			}else if(hrids.contains(user.getId())) {
				hierarchyDTOs = hrhierservice.hrhier(hierarchies.get(i));
				System.out.println("inside hr");
			}else if(orgids.contains(user.getId())) {
				hierarchyDTOs = orghierservice.orghier(hierarchies.get(i));
				System.out.println("inside org");
			}else if(grphdids.contains(user.getId())) {
				hierarchyDTOs=hierarchy().stream().distinct().collect(Collectors.toList());
				System.out.println("inside grouphead");
			}else if(user.equals(hierarchies.get(i).getUser()) &&
					(!user.equals(hierarchies.get(i).getPrjSupervisor()) || 
						!user.equals(hierarchies.get(i).getPriSupervisor()) ||
						!user.equals(hierarchies.get(i).getHrManager()) ||
						!user.equals(hierarchies.get(i).getOrgHead()) ||
						!user.equals(hierarchies.get(i).getGroupHead()))) {
				
				hierarchyDTOs = userhierService.userhier(hierarchies.get(i));
				System.out.println("inside user");
			}
		}
		
		return hierarchyDTOs;
	}
}
