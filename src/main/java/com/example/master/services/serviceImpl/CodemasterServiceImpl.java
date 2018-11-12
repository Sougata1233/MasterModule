package com.example.master.services.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.master.component.CodemasterDao;
import com.example.master.dto.CodemasterDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Codemaster;
import com.example.master.services.CodemasterService;


/*
 * Service Class for CodeMaster
 */
@Service
public class CodemasterServiceImpl implements CodemasterService {

    @Autowired
    CodemasterDao codemasterDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(CodemasterServiceImpl.class);

    /*
     * Preparing DTO for CodeMaster GET methods
     */
    private CodemasterDTO prepareCodemasterDTO(Codemaster codemasterEntity) {
    	CodemasterDTO codemasterDTO = new CodemasterDTO();
    	codemasterDTO.setCodeType(codemasterEntity.getCodeType());
    	codemasterDTO.setCode(codemasterEntity.getCode());
		codemasterDTO.setcodeDsc(codemasterEntity.getcodeDsc());
    
		return codemasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CodemasterService#persistUser(com.example.master.dto.CodemasterDTO)
     * 
     * Saving CodeMaster Entity to Database
     * 
     * @Param
     * 
     * CodeMasterDTO
     * 
     */
    @Override
    public ResponseEntity<CodemasterDTO> persistUser(CodemasterDTO codemasterDTO) {
		
		Codemaster codemasterEntity = new Codemaster();

		codemasterEntity.setCodeType(codemasterDTO.getCodeType());
		codemasterEntity.setCode(codemasterDTO.getCode());
		codemasterEntity.setcodeDsc(codemasterDTO.getcodeDsc());
		
		codemasterDao.addCodemaster(codemasterEntity);
		return new ResponseEntity<CodemasterDTO>(codemasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CodemasterService#updateCodemaster(com.example.master.dto.CodemasterDTO)
     * 
     * Update Service for CodeMaster
     * 
     * @Param
     * 
     * CodeMasterDTO
     * 
     */
    @Override
    public ResponseEntity<CodemasterDTO> updateCodemaster(CodemasterDTO codemasterDTO) {
		
		Codemaster codemasterEntity = new Codemaster();
		codemasterEntity.setCodeType(codemasterDTO.getCodeType());
		codemasterEntity.setcodeDsc(codemasterDTO.getcodeDsc());
		codemasterEntity.setCode(codemasterDTO.getCode());
	
		codemasterDao.updateCodemaster(codemasterEntity);
		
		return new ResponseEntity<CodemasterDTO>(codemasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CodemasterService#populateCodemasterList()
     * 
     * Fetching All Service for CodeMaster Entities 
     * 
     */
    @Override
    public List<CodemasterDTO> populateCodemasterList() {
		List<CodemasterDTO> codemasterDTOList=new ArrayList<CodemasterDTO>();
		try {
		    List<Codemaster> codemasterEntityList=codemasterDao.findAll();
		    
		    codemasterEntityList.forEach(codemasterEntity->{
		    	codemasterDTOList.add(prepareCodemasterDTO(codemasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return codemasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CodemasterService#populateOneCodemasterDetails(java.lang.String)
     * 
     * Fetching Service for CodeMaster Entity by code
     * 
     * @Param
     * 
     * String code
     * 
     */
    @Override
    public CodemasterDTO populateOneCodemasterDetails(String code) {
    	Codemaster codemasterEntity = codemasterDao.findByCode(code);
	return prepareCodemasterDTO(codemasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CodemasterService#destroyCodemaster(java.lang.String)
     * 
     * Deleting Service for CodeMaster Entity
     * 
     * @Param
     * 
     * String code
     * 
     */
    @Override
    public DeleteDTO destroyCodemaster(String code) {
		codemasterDao.deleteCodemaster(code);
		
		/*
		 * Returning a DTO for getting the response
		 */
		DeleteDTO deleteDTO = new DeleteDTO();
		deleteDTO.setstatus(1);
		deleteDTO.setstatusCode(2000);
		deleteDTO.setmsg("Deleted successfully.");
		
		return deleteDTO;
	}

	@Override
	public List<CodemasterDTO> getCodeMasterByCodeType() {
		List<CodemasterDTO> codemasterDTO = new ArrayList<>();
		List<Codemaster> codemasters = codemasterDao.getCodemasterByCodeType("EXP");
		codemasters.forEach(code->{
			codemasterDTO.add(prepareCodemasterDTO(code));
		});
		return codemasterDTO;
	}
}
