package com.example.master.services.serviceImpl;

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

import com.example.master.component.ScmIndentTypeMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.ScmIndentTypeMasterDTO;
import com.example.master.entity.ScmIndentTypeMaster;
import com.example.master.services.ScmIndentTypeMasterService;

/*
 * Service Class For ScmIndentTyperMaster Entity
 */
@Service
public class ScmIndentTypeMasterServiceImpl implements ScmIndentTypeMasterService {

    @Autowired
    ScmIndentTypeMasterDao scmindenttypmasterDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(ScmIndentTypeMasterServiceImpl.class);

    /*
     * Preparing DTO For ScmIndentTypeMaster
     */
    private ScmIndentTypeMasterDTO prepareScmIndentTypeMasterDTO(ScmIndentTypeMaster scmindenttypmasterEntity) {
    	ScmIndentTypeMasterDTO scmindenttypmasterDTO = new ScmIndentTypeMasterDTO();
    	scmindenttypmasterDTO.setindentTypeCode(scmindenttypmasterEntity.getindentTypeCode());
    	scmindenttypmasterDTO.setindentTypeDsc(scmindenttypmasterEntity.getindentTypeDsc());
		scmindenttypmasterDTO.setId(scmindenttypmasterEntity.getId());
	
	    return scmindenttypmasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ScmIndentTypeMasterService#persistUser(com.example.master.dto.ScmIndentTypeMasterDTO)
     * 
     * Save Service For ScmIndentTypeMaster
     * 
     * @Param
     * 
     * ScmIndentTypeMasterDTO
     * 
     */
    @Override
    public ResponseEntity<ScmIndentTypeMasterDTO> persistUser(ScmIndentTypeMasterDTO scmindenttypmasterDTO) {
    	ScmIndentTypeMaster scmindenttypmasterEntity = new ScmIndentTypeMaster();

    	scmindenttypmasterEntity.setindentTypeCode(scmindenttypmasterDTO.getindentTypeCode());
    	scmindenttypmasterEntity.setindentTypeDsc(scmindenttypmasterDTO.getindentTypeDsc());
	
    	scmindenttypmasterDao.addScmIndentTypeMaster(scmindenttypmasterEntity);
    	return new ResponseEntity<ScmIndentTypeMasterDTO>(scmindenttypmasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ScmIndentTypeMasterService#updateScmIndentTypeMaster(com.example.master.dto.ScmIndentTypeMasterDTO)
     * 
     * Update Service For ScmIndentTypeMaster
     * 
     * @Param
     * 
     * ScmIndentTypeMasterDTO
     * 
     */
    @Override
    public ResponseEntity<ScmIndentTypeMasterDTO> updateScmIndentTypeMaster(ScmIndentTypeMasterDTO scmindenttypmasterDTO) {
    	ScmIndentTypeMaster scmindenttypmasterEntity = new ScmIndentTypeMaster();

    	scmindenttypmasterEntity.setindentTypeCode(scmindenttypmasterDTO.getindentTypeCode());
    	scmindenttypmasterEntity.setindentTypeDsc(scmindenttypmasterDTO.getindentTypeDsc());
		scmindenttypmasterEntity.setId(scmindenttypmasterDTO.getId());

	
		scmindenttypmasterDao.updateScmIndentTypeMaster(scmindenttypmasterEntity);
	
		return new ResponseEntity<ScmIndentTypeMasterDTO>(scmindenttypmasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ScmIndentTypeMasterService#populateScmIndentTypeMasterList()
     * 
     * Fetching All ScmIndentTypeMaster
     * 
     */
    @Override
    public List<ScmIndentTypeMasterDTO> populateScmIndentTypeMasterList() {
		List<ScmIndentTypeMasterDTO> scmindenttypmasterDTOList=new ArrayList<ScmIndentTypeMasterDTO>();
		try {
		    List<ScmIndentTypeMaster> scmindenttypmasterEntityList=
						    		scmindenttypmasterDao.findAll()
						    									.stream()
						    									.sorted(Comparator
						    											.comparing(
						    													ScmIndentTypeMaster::getindentTypeDsc))
						    									.collect(Collectors.toList());
		    
		    scmindenttypmasterEntityList.forEach(scmindenttypmasterEntity->{
		    	scmindenttypmasterDTOList.add(prepareScmIndentTypeMasterDTO(scmindenttypmasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return scmindenttypmasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ScmIndentTypeMasterService#populateOneScmIndentTypeMasterDetails(java.lang.Long)
     * 
     * Fetching ScmIndentTypeMaster By Id
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public ScmIndentTypeMasterDTO populateOneScmIndentTypeMasterDetails(Long Id) {
    	ScmIndentTypeMaster scmindenttypmasterEntity = scmindenttypmasterDao.findScmIndentTypeMasterById(Id);
	return prepareScmIndentTypeMasterDTO(scmindenttypmasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ScmIndentTypeMasterService#destroyScmIndentTypeMaster(java.lang.Long)
     * 
     * Delete Service For ScmIndentTypeMaster
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public DeleteDTO destroyScmIndentTypeMaster(Long Id) {

    	scmindenttypmasterDao.deleteScmIndentTypeMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
