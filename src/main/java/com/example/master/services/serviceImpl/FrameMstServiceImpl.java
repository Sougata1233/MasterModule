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

import com.example.master.component.FrameMstDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.FrameMstDTO;
import com.example.master.entity.FrameMst;
import com.example.master.services.FrameMstService;

/*
 * Service Class For FramMaster Entity
 */
@Service
public class FrameMstServiceImpl implements FrameMstService {

    @Autowired
    FrameMstDao framemstDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(FrameMstServiceImpl.class);

    /*
     * Preparing DTO for FrameMaster
     */
    private FrameMstDTO prepareFrameMstDTO(FrameMst framemstEntity) {
    	FrameMstDTO framemstDTO = new FrameMstDTO();
    	framemstDTO.setframeNo(framemstEntity.getframeNo());
    	framemstDTO.setside(framemstEntity.getside());
    	framemstDTO.settrollyNo(framemstEntity.gettrollyNo());
    	framemstDTO.setframeType(framemstEntity.getframeType());
    	framemstDTO.setspindleQtyTyp(framemstEntity.getspindleQtyTyp());
    	framemstDTO.setbobbinWeight(framemstEntity.getbobbinWeight());
    	framemstDTO.setmcNum(framemstEntity.getmcNum());
    	framemstDTO.setframeVvfd(framemstEntity.getframeVvfd());
    	framemstDTO.setId(framemstEntity.getId());
		framemstDTO.setId(framemstEntity.getId());
	
	    return framemstDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.FrameMstService#persistUser(com.example.master.dto.FrameMstDTO)
     * 
     * Save Service For FrameMaster DTO
     * 
     * @Param
     * 
     * FrameMstDTO
     * 
     */
    @Override
    public ResponseEntity<FrameMstDTO> persistUser(FrameMstDTO framemstDTO) {
    	FrameMst framemstEntity = new FrameMst();

    	framemstEntity.setframeNo(framemstDTO.getframeNo());
    	framemstEntity.setside(framemstDTO.getside());
    	framemstEntity.settrollyNo(framemstDTO.gettrollyNo());
    	framemstEntity.setframeType(framemstDTO.getframeType());
    	framemstEntity.setspindleQtyTyp(framemstDTO.getspindleQtyTyp());
    	framemstEntity.setbobbinWeight(framemstDTO.getbobbinWeight());
    	framemstEntity.setmcNum(framemstDTO.getmcNum());
    	framemstEntity.setframeVvfd(framemstDTO.getframeVvfd());
    	
    	framemstDao.addFrameMst(framemstEntity);
	
    	return new ResponseEntity<FrameMstDTO>(framemstDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.FrameMstService#updateFrameMst(com.example.master.dto.FrameMstDTO)
     * 
     * Update DTO for FrameMaster Entity
     * 
     * @Param
     * 
     * FramMstDTO
     * 
     */
    @Override
    public ResponseEntity<FrameMstDTO> updateFrameMst(FrameMstDTO framemstDTO) {
    	FrameMst framemstEntity = new FrameMst();
    	
    	framemstEntity.setframeNo(framemstDTO.getframeNo());
    	framemstEntity.setside(framemstDTO.getside());
    	framemstEntity.settrollyNo(framemstDTO.gettrollyNo());
    	framemstEntity.setframeType(framemstDTO.getframeType());
    	framemstEntity.setspindleQtyTyp(framemstDTO.getspindleQtyTyp());
    	framemstEntity.setbobbinWeight(framemstDTO.getbobbinWeight());
    	framemstEntity.setmcNum(framemstDTO.getmcNum());
    	framemstEntity.setframeVvfd(framemstDTO.getframeVvfd());
    	framemstEntity.setId(framemstDTO.getId());

		framemstDao.updateFrameMst(framemstEntity);
		
		return new ResponseEntity<FrameMstDTO>(framemstDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.FrameMstService#populateFrameMstList()
     * 
     * Fetching All FrameMaster Service
     * 
     */
    @Override
    public List<FrameMstDTO> populateFrameMstList() {
		List<FrameMstDTO> framemstDTOList=new ArrayList<FrameMstDTO>();
		try {
		    List<FrameMst> framemstEntityList=framemstDao.findAll()
		    									.stream()
		    									.sorted(Comparator.comparing(FrameMst::getmcNum))
		    									.collect(Collectors.toList());
		    
		    framemstEntityList.forEach(framemstEntity->{
		    	framemstDTOList.add(prepareFrameMstDTO(framemstEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return framemstDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.FrameMstService#populateOneFrameMstDetails(java.lang.Long)
     * 
     * Fetching FrmaMaster By Id
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public FrameMstDTO populateOneFrameMstDetails(Long Id) {
    	FrameMst framemstEntity = framemstDao.findFrameMstById(Id);
	
    	return prepareFrameMstDTO(framemstEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.FrameMstService#destroyFrameMst(java.lang.Long)
     * 
     * Delete Service For FrameMaster
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public DeleteDTO destroyFrameMst(Long Id) {

    	framemstDao.deleteFrameMst(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();

    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
