package com.example.master.services.serviceImpl;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.master.component.EmployeeDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.EmployeeDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.entity.Employee;
import com.example.master.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /*
     * Preparing DTO For Employee Entity
     */
    private EmployeeDTO prepareEmployeeDTO(Employee employeeEntity) {
    	EmployeeDTO employeeDTO = new EmployeeDTO();
    	
    	employeeDTO.setempName(employeeEntity.getempName());
    	employeeDTO.setdeptId(employeeEntity.getdeptId());
    	employeeDTO.setebId(employeeEntity.getebId());
    	employeeDTO.setebFixedId(employeeEntity.getebFixedId());
    	employeeDTO.setdateOfBirth(employeeEntity.getdateOfBirth());
    	employeeDTO.setsex(employeeEntity.getsex());
    	employeeDTO.setfatherHusbandName(employeeEntity.getfatherHusbandName());
    	employeeDTO.setreligion(employeeEntity.getreligion());
    	employeeDTO.setoccuId(employeeEntity.getoccuId());
    	employeeDTO.setdateOfJoining(employeeEntity.getdateOfJoining());
    	employeeDTO.setdateOfPfJoining(employeeEntity.getdateOfPfJoining());
    	employeeDTO.setactive(employeeEntity.getactive());
    	employeeDTO.setdateOfInactive(employeeEntity.getdateOfInactive());
    	employeeDTO.setcataId(employeeEntity.getcataId());
    	employeeDTO.setworkingReley(employeeEntity.getworkingReley());
    	employeeDTO.setquarter(employeeEntity.getquarter());
    	employeeDTO.setquarterNo(employeeEntity.getquarterNo());
    	employeeDTO.setesiMember(employeeEntity.getesiMember());
    	employeeDTO.setpfMember(employeeEntity.getpfMember());
    	employeeDTO.setfpfMember(employeeEntity.getfpfMember());
    	employeeDTO.setesiNo(employeeEntity.getesiNo());
    	employeeDTO.setpfNo(employeeEntity.getpfNo());
    	employeeDTO.setfpffNo(employeeEntity.getfpffNo());
    	employeeDTO.seteducation(employeeEntity.geteducation());
    	employeeDTO.seteducationRead(employeeEntity.geteducationRead());
    	employeeDTO.seteducationWrite(employeeEntity.geteducationWrite());
    	employeeDTO.setprevEmployment(employeeEntity.getprevEmployment());
    	employeeDTO.setidenticalMarks(employeeEntity.getidenticalMarks());
    	employeeDTO.setpermanentAdd1(employeeEntity.getpermanentAdd1());
    	employeeDTO.setpermanentAdd2(employeeEntity.getpermanentAdd2());
    	employeeDTO.setpermanentAdd3(employeeEntity.getpermanentAdd3());
    	employeeDTO.setpermanentAdd4(employeeEntity.getpermanentAdd4());
    	employeeDTO.setlocalAdd1(employeeEntity.getlocalAdd1());
    	employeeDTO.setlocalAdd2(employeeEntity.getlocalAdd2());
    	employeeDTO.setlocalAdd3(employeeEntity.getlocalAdd3());
    	employeeDTO.setlocalAdd4(employeeEntity.getlocalAdd4());
    	employeeDTO.setphoneNo(employeeEntity.getphoneNo());
    	employeeDTO.setmobileNo(employeeEntity.getmobileNo());
    	employeeDTO.setoffday(employeeEntity.getoffday());
    	employeeDTO.setphotoDir(employeeEntity.getphotoDir());
    	employeeDTO.setupdated(employeeEntity.getupdated());
    	employeeDTO.setuserId(employeeEntity.getuserId());
    	employeeDTO.setoccuCode(employeeEntity.getoccuCode());
    	employeeDTO.setwrkType(employeeEntity.getwrkType());
    	employeeDTO.setphotofile(employeeEntity.getphotofile());
    	employeeDTO.setchkOld(employeeEntity.getchkOld());
    	employeeDTO.setoldEb(employeeEntity.getoldEb());
    	employeeDTO.setId(employeeEntity.getId());
    	try {
    		DepartmentDTO departmentDTO = new DepartmentDTO();
    	
    		departmentDTO.setorgId(employeeEntity.getDepartment().getorgId());
    		departmentDTO.setdepartmentName(employeeEntity.getDepartment().getdepartmentName());
    		departmentDTO.setmodby(employeeEntity.getDepartment().getmodby());
    		departmentDTO.setmodifiedOn(employeeEntity.getDepartment().getmodifiedOn());
    		departmentDTO.setId(employeeEntity.getDepartment().getId());
    		
    		OrganizationDTO organizationDTO = new OrganizationDTO();
    		
        	organizationDTO.setId(employeeEntity.getDepartment().getOrganization().getId());
        	organizationDTO.setorgName(employeeEntity.getDepartment().getOrganization().getorgName());
        	organizationDTO.setHierarchyId(employeeEntity.getDepartment().getOrganization().getHierarchyId());
        	organizationDTO.setmodby(employeeEntity.getDepartment().getOrganization().getmodby());
        	organizationDTO.setmodifiedOn(employeeEntity.getDepartment().getOrganization().getmodifiedOn());
        	organizationDTO.setshortCode(employeeEntity.getDepartment().getOrganization().getshortCode());
        	organizationDTO.setorgTyp(employeeEntity.getDepartment().getOrganization().getorgTyp());
    		departmentDTO.setOrganization(organizationDTO);
    		employeeDTO.setDepartment(departmentDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
	
    	return employeeDTO;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.EmployeeService#persistEmployee(com.example.master.dto.EmployeeDTO)
     * 
     * Save Service For Employee Entity
     * 
     */
    @Override
    public ResponseEntity<EmployeeDTO> persistEmployee(EmployeeDTO employeeDTO) {

		Employee employeeEntity = new Employee();
		
		employeeEntity.setempName(employeeDTO.getempName());
		employeeEntity.setdeptId(employeeDTO.getdeptId());
		employeeEntity.setebId(employeeDTO.getebId());
		employeeEntity.setebFixedId(employeeDTO.getebFixedId());
		employeeEntity.setdateOfBirth(employeeDTO.getdateOfBirth());
		employeeEntity.setsex(employeeDTO.getsex());
		employeeEntity.setfatherHusbandName(employeeDTO.getfatherHusbandName());
		employeeEntity.setreligion(employeeDTO.getreligion());
		employeeEntity.setoccuId(employeeDTO.getoccuId());
		employeeEntity.setdateOfJoining(employeeDTO.getdateOfJoining());
		employeeEntity.setdateOfPfJoining(employeeDTO.getdateOfPfJoining());
		employeeEntity.setactive(employeeDTO.getactive());
		employeeEntity.setdateOfInactive(employeeDTO.getdateOfInactive());
		employeeEntity.setcataId(employeeDTO.getcataId());
		employeeEntity.setworkingReley(employeeDTO.getworkingReley());
		employeeEntity.setquarter(employeeDTO.getquarter());
		employeeEntity.setquarterNo(employeeDTO.getquarterNo());
		employeeEntity.setesiMember(employeeDTO.getesiMember());
		employeeEntity.setpfMember(employeeDTO.getpfMember());
		employeeEntity.setfpfMember(employeeDTO.getfpfMember());
		employeeEntity.setesiNo(employeeDTO.getesiNo());
		employeeEntity.setpfNo(employeeDTO.getpfNo());
		employeeEntity.setfpffNo(employeeDTO.getfpffNo());
		employeeEntity.seteducation(employeeDTO.geteducation());
		employeeEntity.seteducationRead(employeeDTO.geteducationRead());
		employeeEntity.seteducationWrite(employeeDTO.geteducationWrite());
		employeeEntity.setprevEmployment(employeeDTO.getprevEmployment());
		employeeEntity.setidenticalMarks(employeeDTO.getidenticalMarks());
		employeeEntity.setpermanentAdd1(employeeDTO.getpermanentAdd1());
		employeeEntity.setpermanentAdd2(employeeDTO.getpermanentAdd2());
		employeeEntity.setpermanentAdd3(employeeDTO.getpermanentAdd3());
		employeeEntity.setpermanentAdd4(employeeDTO.getpermanentAdd4());
		employeeEntity.setlocalAdd1(employeeDTO.getlocalAdd1());
		employeeEntity.setlocalAdd2(employeeDTO.getlocalAdd2());
		employeeEntity.setlocalAdd3(employeeDTO.getlocalAdd3());
		employeeEntity.setlocalAdd4(employeeDTO.getlocalAdd4());
		employeeEntity.setphoneNo(employeeDTO.getphoneNo());
		employeeEntity.setmobileNo(employeeDTO.getmobileNo());
		employeeEntity.setoffday(employeeDTO.getoffday());
		employeeEntity.setphotoDir(employeeDTO.getphotoDir());
		employeeEntity.setupdated(employeeDTO.getupdated());
		employeeEntity.setuserId(employeeDTO.getuserId());
		employeeEntity.setoccuCode(employeeDTO.getoccuCode());
		employeeEntity.setwrkType(employeeDTO.getwrkType());
		employeeEntity.setphotofile(employeeDTO.getphotofile());
		employeeEntity.setchkOld(employeeDTO.getchkOld());
		employeeEntity.setoldEb(employeeDTO.getoldEb());
		employeeEntity.setId(employeeDTO.getId());
		
		employeeDao.addEmployee(employeeEntity);
		
		return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.EmployeeService#updateEmployee(com.example.master.dto.EmployeeDTO)
     * 
     * Update Service For Employee Entity
     * 
     */
    @Override
    public ResponseEntity<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO) {

		Employee employeeEntity = new Employee();
		
		employeeEntity.setempName(employeeDTO.getempName());
		employeeEntity.setdeptId(employeeDTO.getdeptId());
		employeeEntity.setebId(employeeDTO.getebId());
		employeeEntity.setebFixedId(employeeDTO.getebFixedId());
		employeeEntity.setdateOfBirth(employeeDTO.getdateOfBirth());
		employeeEntity.setsex(employeeDTO.getsex());
		employeeEntity.setfatherHusbandName(employeeDTO.getfatherHusbandName());
		employeeEntity.setreligion(employeeDTO.getreligion());
		employeeEntity.setoccuId(employeeDTO.getoccuId());
		employeeEntity.setdateOfJoining(employeeDTO.getdateOfJoining());
		employeeEntity.setdateOfPfJoining(employeeDTO.getdateOfPfJoining());
		employeeEntity.setactive(employeeDTO.getactive());
		employeeEntity.setdateOfInactive(employeeDTO.getdateOfInactive());
		employeeEntity.setcataId(employeeDTO.getcataId());
		employeeEntity.setworkingReley(employeeDTO.getworkingReley());
		employeeEntity.setquarter(employeeDTO.getquarter());
		employeeEntity.setquarterNo(employeeDTO.getquarterNo());
		employeeEntity.setesiMember(employeeDTO.getesiMember());
		employeeEntity.setpfMember(employeeDTO.getpfMember());
		employeeEntity.setfpfMember(employeeDTO.getfpfMember());
		employeeEntity.setesiNo(employeeDTO.getesiNo());
		employeeEntity.setpfNo(employeeDTO.getpfNo());
		employeeEntity.setfpffNo(employeeDTO.getfpffNo());
		employeeEntity.seteducation(employeeDTO.geteducation());
		employeeEntity.seteducationRead(employeeDTO.geteducationRead());
		employeeEntity.seteducationWrite(employeeDTO.geteducationWrite());
		employeeEntity.setprevEmployment(employeeDTO.getprevEmployment());
		employeeEntity.setidenticalMarks(employeeDTO.getidenticalMarks());
		employeeEntity.setpermanentAdd1(employeeDTO.getpermanentAdd1());
		employeeEntity.setpermanentAdd2(employeeDTO.getpermanentAdd2());
		employeeEntity.setpermanentAdd3(employeeDTO.getpermanentAdd3());
		employeeEntity.setpermanentAdd4(employeeDTO.getpermanentAdd4());
		employeeEntity.setlocalAdd1(employeeDTO.getlocalAdd1());
		employeeEntity.setlocalAdd2(employeeDTO.getlocalAdd2());
		employeeEntity.setlocalAdd3(employeeDTO.getlocalAdd3());
		employeeEntity.setlocalAdd4(employeeDTO.getlocalAdd4());
		employeeEntity.setphoneNo(employeeDTO.getphoneNo());
		employeeEntity.setmobileNo(employeeDTO.getmobileNo());
		employeeEntity.setoffday(employeeDTO.getoffday());
		employeeEntity.setphotoDir(employeeDTO.getphotoDir());
		employeeEntity.setupdated(employeeDTO.getupdated());
		employeeEntity.setuserId(employeeDTO.getuserId());
		employeeEntity.setoccuCode(employeeDTO.getoccuCode());
		employeeEntity.setwrkType(employeeDTO.getwrkType());
		employeeEntity.setphotofile(employeeDTO.getphotofile());
		employeeEntity.setchkOld(employeeDTO.getchkOld());
		employeeEntity.setoldEb(employeeDTO.getoldEb());
		employeeEntity.setId(employeeDTO.getId());
	
		employeeDao.updateEmployee(employeeEntity);
		
		return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.EmployeeService#populateEmployeeList()
     * 
     * Fetching All Employee Service
     * 
     */
    @Override
    public List<EmployeeDTO> populateEmployeeList() {
		List<EmployeeDTO> employeeDTOList=new ArrayList<EmployeeDTO>();
		try {
		    List<Employee> employeeEntityList=employeeDao.findAll()
		    									.stream()
		    									.sorted(Comparator.comparing(Employee::getempName))
		    									.collect(Collectors.toList());
		    
		    employeeEntityList.forEach(employeeEntity->{
		    	employeeDTOList.add(prepareEmployeeDTO(employeeEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return employeeDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.EmployeeService#populateOneEmployeeDetails(java.lang.String)
     * 
     * Fetching Employee By Employee Id
     * 
     * @Param
     * 
     * String employee Id
     * 
     */
    @Override
    public EmployeeDTO populateOneEmployeeDetails(String employeeId) {
    	Employee employeeEntity = employeeDao.findEmployeeById(employeeId);
	
    	return prepareEmployeeDTO(employeeEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.EmployeeService#destroyEmployee(java.lang.String)
     * 
     * Delete Service For Employee
     * 
     * @Param
     * 
     * String employeeId
     * 
     */
    @Override
    public DeleteDTO destroyEmployee(String employeeId) {

    	employeeDao.deleteEmployee(employeeId);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
