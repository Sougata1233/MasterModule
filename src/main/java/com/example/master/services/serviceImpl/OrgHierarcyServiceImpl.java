package com.example.master.services.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.master.component.LocationMasterDao;
import com.example.master.component.OrganizationDao;
import com.example.master.component.UserDao;
import com.example.master.component.UserHierarcyDao;
import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.DesignationDTO;
import com.example.master.dto.LocationMasterDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.dto.UserDTO;
import com.example.master.dto.UserHierDTO.ParentOrgDTO;
import com.example.master.dto.UserHierDTO.UserHierarcyDTO;
import com.example.master.entity.LocationMaster;
import com.example.master.entity.Organization;
import com.example.master.entity.User;
import com.example.master.entity.UserHierarchy;
import com.example.master.services.OrgHierarcyService;

/*
 * Service and RestController class for UserHierarchy
 */
@Service
public class OrgHierarcyServiceImpl implements OrgHierarcyService {
	
	@Autowired
	UserHierarcyDao hierarcyDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrganizationDao orgDao;
	
	@Autowired
	LocationMasterDao locationDao;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrgHierarcyServiceImpl.class);

	
	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#getHierarcyById(java.lang.Long)
	 * fetching hierarchy by hierarchy ID
	 * GET method for user_hierarcy table with param hierarcyId
	 */
	@Override
	public ResponseEntity<UserHierarcyDTO> getHierarcyById(Long hierarcyId) {
		UserHierarchy hierarcy = hierarcyDao.getHierarchyById(hierarcyId);
		return new ResponseEntity<UserHierarcyDTO>(prepareUserHierarchyDTO(hierarcy), HttpStatus.OK);
	}

	
	/*
	 * preparing hierarchy DTO for fetching data
	 */
	private UserHierarcyDTO prepareUserHierarchyDTO(UserHierarchy hierarcy) {
		UserHierarcyDTO hierarcyDTO = new UserHierarcyDTO();
		
		hierarcyDTO.setFromDate(hierarcy.getFromDate());
		hierarcyDTO.setModBy(hierarcy.getModBy());
		hierarcyDTO.setModOn(hierarcy.getModOn());
		hierarcyDTO.setPracticeMaster(hierarcy.getPracticeMaster());
		hierarcyDTO.setPrjAllocDate(hierarcy.getPrjAllocDate());
		hierarcyDTO.setPrjReleaseDate(hierarcy.getPrjReleaseDate());
		hierarcyDTO.setProjectMaster(hierarcy.getProjectMaster());
		hierarcyDTO.setStatus(hierarcy.getStatus());
		hierarcyDTO.setToDate(hierarcy.getToDate());
		
		User user = userDao.findUserById(hierarcy.getUser().getId());
		
		
//		hierarcyDTO.setUser(prepareUserDTO(user));
		
		//setting priSupervisor
		User priSupervisor = userDao.findUserById(hierarcy.getPriSupervisor().getId());
//		hierarcyDTO.setPriSupervisor(prepareUserDTO(priSupervisor));
		
		User hrManager = userDao.findUserById(hierarcy.getHrManager().getId());
//		hierarcyDTO.setHrManager(prepareUserDTO(hrManager));
		
		hierarcyDTO.setHierarcyId(hierarcy.getHierarcyId());
		
		Organization org = orgDao.findOrganizationById(hierarcy.getUser().getOrganization().getId());
		hierarcyDTO.setOrgId(org);
		
		Organization parentOrg = orgDao.findOrganizationById(hierarcy.getUser().getOrganization().getId());
		hierarcyDTO.setParentOrgId(parentOrg);
		
		if(hierarcy.getGroupHead() != null) {
			User groupHeadEntity = userDao.findUserById(hierarcy.getGroupHead().getId());
			long groupHeadDesigId = groupHeadEntity.getDesignation().getId();
			if(groupHeadDesigId == 6) {		//checking if the user is chairman or not
//				hierarcyDTO.setGroupHead(groupHeadEntity.getFirstName()+" "+groupHeadEntity.getLastName());
//				hierarcyDTO.setGroupHead(prepareUserDTO(groupHeadEntity));
			}
		}
		
		
		
		/*List<User> orgHeadEntityList = userDao.findByUserNameStream(hierarcy.getOrgHead().getUserName());
		List<UserDTO> orgHeadDTOList = new ArrayList<>();
		orgHeadEntityList.forEach(orgHead->{
			long orgHeadDesigId = orgHead.getDesignation().getId();
			if(orgHeadDesigId == 1) {
				orgHeadDTOList.add(prepareUserDTO(orgHead));
			}
		});
		hierarcyDTO.setOrgHead(orgHeadDTOList);*/
		
		/*if(hierarcy.getOrgHead() != null) {
			User orgHeadEntity = userDao.findUserById(hierarcy.getOrgHead().getId());
			long orgHeadDesigID = orgHeadEntity.getDesignation().getId();
			if(orgHeadDesigID == 1) {	//checking if the user is director or not
				hierarcyDTO.setOrgHead(prepareUserDTO(orgHeadEntity));
			}
		}*/
		
		
		/*List<User> orgHeadEntity = userDao.findByUserNameStream(hierarcy.getUser().getUserName());
		orgHeadEntity.forEach(orgHead->{
			hierarcyDTO.setOrgHead(orgHead.getFirstName()+" "+orgHead.getLastName());
		});*/
		
		return hierarcyDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#populateHierarcyList()
	 * fetching all hierarchies
	 * GET method for user_hierarcy table
	 */
	@Override
	public List<UserHierarcyDTO> populateHierarcyList() {
		List<UserHierarcyDTO> hierarcyEmpList = new ArrayList<>();
		try {
			List<UserHierarchy> hierarcyList = hierarcyDao.getAllHierarcy();
			hierarcyList.forEach(hierarcy->{
				hierarcyEmpList.add(prepareUserHierarchyDTO(hierarcy));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return hierarcyEmpList;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#groupHead()
	 * fetching hierarchy in nested manner
	 */
	@Override
	public ParentOrgDTO groupHead() {/*
		
		List<UserHierarchy> hierarchyList = hierarcyDao.getAllHierarcy();	//fetching all hierarchies
		
		ParentOrgDTO parentOrg = new ParentOrgDTO();
		OrgDTO orgDTO = new OrgDTO();
		
		GroupHeadDTO groupHeadList = new GroupHeadDTO();
//		List<GroupHeadDTO> groupHeadDTOList = new ArrayList<>();
		
		
		hierarchyList.forEach(hierarchy->{
			OrgDTO orgDto = new OrgDTO();
			List<OrgDTO> orgDtos = new ArrayList<>();
			List<UserHierarchy> forOrgId = hierarcyDao.getHierarchyByOrgId(hierarchy.getOrgId().getId());
			
			parentOrg.setParentOrg(hierarchy.getParentOrgId());
			
			forOrgId.forEach(orgId->{
				GroupHeadDTO groupheadDTO = new GroupHeadDTO();
				List<GroupHeadDTO> groupheads = new ArrayList<>();
				List<UserHierarchy> forGroupHead = hierarcyDao.getHierarchyByGroupHead(orgId.getGroupHead().getId());
				
				orgDto.setOrg(orgId.getOrgId());
				
				forGroupHead.forEach(grouphead->{
					OrgHeadDTO orgheadDto = new OrgHeadDTO();
					List<OrgHeadDTO> orgheads = new ArrayList<>();
					List<UserHierarchy> forOrgHead = hierarcyDao.getHierarchyByOrgHead(grouphead.getOrgHead().getId());
					
					groupheadDTO.setGroupHead(prepareUserDTO(grouphead.getGroupHead()));
					
					
					forOrgHead.forEach(orghead->{
						HrManagerDTO hrmanagerDto = new HrManagerDTO();
						List<HrManagerDTO> hrmanagers = new ArrayList<>();
						List<UserHierarchy> forHrManager = hierarcyDao.getHierarchyByHrManager(orghead.getHrManager().getId()); 
						
						orgheadDto.setOrgHead(prepareUserDTO(orghead.getOrgHead()));
						
						forHrManager.forEach(hrmanager->{
							PriSupervisorDTO prisupervisorDTO = new PriSupervisorDTO();
							List<PriSupervisorDTO> prisupervisors = new ArrayList<>();
							List<UserHierarchy> forPriSupervisor = hierarcyDao.getHierarchyByPriSupervisor(hrmanager.getPriSupervisor().getId());
							
							hrmanagerDto.setHrManager(prepareUserDTO(hrmanager.getHrManager()));
							
							forPriSupervisor.forEach(prisupervisor->{
								PrjSupervisorDTO prjsupervisorDto = new PrjSupervisorDTO();
								List<PrjSupervisorDTO> prjsupervisors = new ArrayList<>();
								List<UserHierarchy> forprjsupervisor = hierarcyDao.getHierarchyByPrjSupervisor(prisupervisor.getPrjSupervisor().getId());
								
								
								prisupervisorDTO.setPriSupervisor(prepareUserDTO(prisupervisor.getPriSupervisor()));
								
								forprjsupervisor.forEach(prjsupervisor->{
									UserHDTO userDto = new UserHDTO();
									List<UserHDTO> users = new ArrayList<>();
									List<UserHierarchy> forUser = hierarcyDao.getHierarchyByUser(prjsupervisor.getUser().getId());
									
									prjsupervisorDto.setPrjSupervisor(prepareUserDTO(prjsupervisor.getPrjSupervisor()));
									
									forUser.forEach(user->{
										userDto.setUser(prepareUserDTO(user.getUser()));
										users.add(userDto);
									});
									
									prjsupervisorDto.setUser(users);
									prjsupervisors.add(prjsupervisorDto);
									
								});
								
								prisupervisorDTO.setPrjSupervisor(prjsupervisors);
								prisupervisors.add(prisupervisorDTO);
								
							});
							
							hrmanagerDto.setPriSuperviser(prisupervisors);
							hrmanagers.add(hrmanagerDto);
							
						});
						
						orgheadDto.setHrManager(hrmanagers);
						orgheads.add(orgheadDto);
						
					});
					
					groupheadDTO.setOrgHeadList(orgheads);
					groupheads.add(groupheadDTO);
					
				});
				System.out.println(groupheads);
				orgDto.setGroupHead(groupheads);
				System.out.println(orgDto);
				orgDtos.add(orgDTO);
				System.out.println("orgdtos "+orgDtos);
			});
			
			parentOrg.setOrg(orgDto);
			
			System.out.println(parentOrg);
		});
		*/
//		return parentOrg;
		return null;
	}
	
	/*@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getuser/{id}", method = RequestMethod.GET)
    @ResponseBody
	public List<UserHierarchy> getUser(@PathVariable("id") long id) {
		List<UserHierarchy> hierarcyList = hierarcyDao.getHierarchyByUser(id);
		List<UserHierarchy> hierarchyList = new ArrayList<>();
		
		hierarcyList.forEach(groupHeadEntity->{
			hierarchyList.add(groupHeadEntity);
		});
		
		return hierarchyList;
	}*/
	
	
	//preparing user DTO
	private UserDTO prepareUserDTO(User userEntity) {
		UserDTO userDTO = new UserDTO();
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
		userDTO.setEndDate(userEntity.getEndDate());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setFromDate(userEntity.getFromDate());
		userDTO.setGender(userEntity.getGender());
		userDTO.setId(userEntity.getId());
		userDTO.setIsEnabled(userEntity.getIsEnabled());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setMobile(userEntity.getMobile());
		userDTO.setModifiedBy(userEntity.getModifiedBy());
		userDTO.setModifiedOn(userEntity.getModifiedOn());

		
		
		userDTO.setTypeOfEmployment(userEntity.getTypeOfEmployment());
		
		//getting user image
		int usrImgLength;
		try {
			if(userEntity.getUserImg() != null) {
			usrImgLength = (int) userEntity.getUserImg().length();
			System.out.println(usrImgLength);
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
		userDTO.setPermAddr(userEntity.getPermAddr());
		userDTO.setState(userEntity.getState());
		userDTO.setCity(userEntity.getCity());
		userDTO.setCountry(userEntity.getCountry());
		userDTO.setZip(userEntity.getZip());
		userDTO.setFatherName(userEntity.getFatherName());
		userDTO.setSpouseName(userEntity.getSpouseName());
		userDTO.setPassport(userEntity.getPassport());
		
		LocationMaster location = locationDao.getLocationById(userEntity.getDepartment().getOrganization().getLocationId());
		userDTO.setLocation(null == location ? null : prepareLocationDTO(location));
		
		return userDTO;
	    }
	
	private LocationMasterDTO prepareLocationDTO(LocationMaster location) {
		LocationMasterDTO locationMaster = new LocationMasterDTO();
		locationMaster.setcreatedBy(location.getcreatedBy());
		locationMaster.setcreatedOn(location.getcreatedOn());
		locationMaster.setId(location.getId());
		locationMaster.setlocationArea(location.getlocationArea());
		locationMaster.setlocationCity(location.getlocationCity());
		locationMaster.setlocationCountry(location.getlocationCountry());
		locationMaster.setlocationPin(location.getlocationPin());
		locationMaster.setlocationState(location.getlocationState());
		locationMaster.setmodby(location.getmodby());
		locationMaster.setmodifiedOn(location.getmodifiedOn());
		return locationMaster;
	    }


	/*@Override
	@RequestMapping(value = "getuser", method = RequestMethod.GET)
    @ResponseBody
	public List<JsonNode> getHierarchy() {
		ObjectMapper mapper = new ObjectMapper();
		List<UserHierarchy> hierarchy = hierarcyDao.getAllHierarcy();
		JsonNode node = mapper.createObjectNode();
		List<JsonNode> nodes = new ArrayList<>();
		hierarchy.forEach(h->{
			JsonNode node1 = mapper.valueToTree(h);
			nodes.add(node1);
		});
		
		return nodes;
	}*/

	
	
	

}
