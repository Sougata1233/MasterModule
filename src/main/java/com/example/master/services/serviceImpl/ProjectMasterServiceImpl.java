package com.example.master.services.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
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

import com.example.master.component.ProjectMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.ProjectMasterDTO;
import com.example.master.entity.ProjectMaster;
import com.example.master.services.ProjectMasterService;

/*
 * Service Class For ProjectMaster Entity
 */
@Service
public class ProjectMasterServiceImpl implements ProjectMasterService {

    @Autowired
    ProjectMasterDao projectmasterDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(ProjectMasterServiceImpl.class);

   /*
    * Preparing DTO For ProjectMaster Entity
    */
    private ProjectMasterDTO prepareProjectMasterDTO(ProjectMaster projectmasterEntity) {
    	ProjectMasterDTO projectmasterDTO = new ProjectMasterDTO();
    
    	projectmasterDTO.setprjName(projectmasterEntity.getprjName());
    	projectmasterDTO.setprjDsc(projectmasterEntity.getprjDsc());
    	projectmasterDTO.setprjStartDt(projectmasterEntity.getprjStartDt());
    	projectmasterDTO.setprjEndDt(projectmasterEntity.getprjEndDt());
    	projectmasterDTO.setprjActualStartDt(projectmasterEntity.getprjActualStartDt());
    	projectmasterDTO.setprjActualEndDt(projectmasterEntity.getprjActualEndDt());
    	projectmasterDTO.setplannedDuration(projectmasterEntity.getplannedDuration());
    	projectmasterDTO.setactualDuration(projectmasterEntity.getactualDuration());
    	projectmasterDTO.setprjAllocBudget(projectmasterEntity.getprjAllocBudget());
    	projectmasterDTO.setprjAvlBudget(projectmasterEntity.getprjAvlBudget());
    	projectmasterDTO.setprjStatus(projectmasterEntity.getprjStatus());
    	projectmasterDTO.setmodby(projectmasterEntity.getmodby());
    	projectmasterDTO.setmodifiedOn(projectmasterEntity.getmodifiedOn());
		projectmasterDTO.setId(projectmasterEntity.getId());

	    return projectmasterDTO;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.ProjectMasterService#persistProjectMaster(com.example.master.dto.ProjectMasterDTO)
     * 
     * Saving ProjectMaster
     * 
     * @Param
     * 
     * ProjectMasterDTO
     * 
     */
    @Override
    public ResponseEntity<ProjectMasterDTO> persistProjectMaster(ProjectMasterDTO projectmasterDTO) {
    	ProjectMaster projectmasterEntity = new ProjectMaster();

    	projectmasterEntity.setprjName(projectmasterDTO.getprjName());
    	projectmasterEntity.setprjDsc(projectmasterDTO.getprjDsc());
    	projectmasterEntity.setprjStartDt(projectmasterDTO.getprjStartDt());
    	projectmasterEntity.setprjEndDt(projectmasterDTO.getprjEndDt());
    	projectmasterEntity.setprjActualStartDt(projectmasterDTO.getprjActualStartDt());
    	projectmasterEntity.setprjActualEndDt(projectmasterDTO.getprjActualEndDt());
    	projectmasterEntity.setplannedDuration(projectmasterDTO.getplannedDuration());
    	projectmasterEntity.setactualDuration(projectmasterDTO.getactualDuration());
    	projectmasterEntity.setprjAllocBudget(projectmasterDTO.getprjAllocBudget());
    	projectmasterEntity.setprjAvlBudget(projectmasterDTO.getprjAvlBudget());
    	projectmasterEntity.setprjStatus(projectmasterDTO.getprjStatus());
    	projectmasterEntity.setmodby(projectmasterDTO.getmodby());
    	projectmasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
	
    	projectmasterDao.addProjectMaster(projectmasterEntity);
	
    	return new ResponseEntity<ProjectMasterDTO>(projectmasterDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ProjectMasterService#updateProjectMaster(com.example.master.dto.ProjectMasterDTO)
     * 
     * Update Service For ProjectMaster Entity
     * 
     * @Param 
     * 
     * ProjectMasterDTO
     * 
     */
    @Override
    public ResponseEntity<ProjectMasterDTO> updateProjectMaster(ProjectMasterDTO projectmasterDTO) {
    	ProjectMaster projectmasterEntity = new ProjectMaster();

    	projectmasterEntity.setprjName(projectmasterDTO.getprjName());
    	projectmasterEntity.setprjDsc(projectmasterDTO.getprjDsc());
    	projectmasterEntity.setprjStartDt(projectmasterDTO.getprjStartDt());
    	projectmasterEntity.setprjEndDt(projectmasterDTO.getprjEndDt());
    	projectmasterEntity.setprjActualStartDt(projectmasterDTO.getprjActualStartDt());
    	projectmasterEntity.setprjActualEndDt(projectmasterDTO.getprjActualEndDt());
    	projectmasterEntity.setplannedDuration(projectmasterDTO.getplannedDuration());
    	projectmasterEntity.setactualDuration(projectmasterDTO.getactualDuration());
    	projectmasterEntity.setprjAllocBudget(projectmasterDTO.getprjAllocBudget());
    	projectmasterEntity.setprjAvlBudget(projectmasterDTO.getprjAvlBudget());
    	projectmasterEntity.setprjStatus(projectmasterDTO.getprjStatus());
    	projectmasterEntity.setmodby(projectmasterDTO.getmodby());
    	projectmasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		projectmasterEntity.setId(projectmasterDTO.getId());
    	
		projectmasterDao.updateProjectMaster(projectmasterEntity);
	
		return new ResponseEntity<ProjectMasterDTO>(projectmasterDTO, HttpStatus.CREATED);

    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.ProjectMasterService#populateProjectMasterList()
     * 
     * Fetching All ProjectMaster
     * 
     */
    @Override
    public List<ProjectMasterDTO> populateProjectMasterList() {
		List<ProjectMasterDTO> projectmasterDTOList=new ArrayList<ProjectMasterDTO>();
		try {
		    List<ProjectMaster> projectmasterEntityList=projectmasterDao.findAll()
		    															.stream()
		    															.sorted(Comparator.comparing(ProjectMaster::getprjDsc))
		    															.collect(Collectors.toList());
		    
		    projectmasterEntityList.forEach(projectmasterEntity->{
		    	projectmasterDTOList.add(prepareProjectMasterDTO(projectmasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return projectmasterDTOList;
    }

    @Override
    public ProjectMasterDTO populateOneProjectMasterDetails(Long Id) {
    	ProjectMaster projectmasterEntity = projectmasterDao.findProjectMasterById(Id);
	
    	return prepareProjectMasterDTO(projectmasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ProjectMasterService#destroyProjectMaster(java.lang.Long)
     * 
     * Delete ProjectMaster By Id
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public DeleteDTO destroyProjectMaster(Long Id) {

    	projectmasterDao.deleteProjectMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
