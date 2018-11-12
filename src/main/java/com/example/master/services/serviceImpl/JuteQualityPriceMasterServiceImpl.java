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

import com.example.master.component.ItemMasterDao;
import com.example.master.component.JuteQualityPriceMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.JuteQualityPriceMasterDTO;
import com.example.master.entity.ItemMaster;
import com.example.master.entity.JuteQualityPriceMaster;
import com.example.master.services.JuteQualityPriceMasterService;

/*
 * Service Class For JuteQualityPriceMaster
 */
@Service
public class JuteQualityPriceMasterServiceImpl implements JuteQualityPriceMasterService {

	@Autowired
   JuteQualityPriceMasterDao juteqltpricemasterDao;
   
   @Autowired
   ItemMasterDao itemDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(JuteQualityPriceMasterServiceImpl.class);
   
    /*
     * Preparing DTO For JuteQualityPriceMaster Entity
     */
    private JuteQualityPriceMasterDTO prepareJuteQualityPriceMasterDTO(JuteQualityPriceMaster juteqltpricemasterEntity) {
    	JuteQualityPriceMasterDTO juteqltpricemasterdt = new JuteQualityPriceMasterDTO();
    	ItemMaster item = itemDao.findItemMasterById(juteqltpricemasterEntity.getitemCode());
    	juteqltpricemasterdt.setitemCode(item.getitemDsc());
    	juteqltpricemasterdt.setjuteQuality(juteqltpricemasterEntity.getjuteQuality());
    	juteqltpricemasterdt.setrate(juteqltpricemasterEntity.getrate());
    	juteqltpricemasterdt.setcurrency(juteqltpricemasterEntity.getcurrency());
    	juteqltpricemasterdt.setId(juteqltpricemasterEntity.getId());
    	
	    return juteqltpricemasterdt;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.JuteQualityPriceMasterService#persistJuteQualityPriceMaster(com.example.master.dto.JuteQualityPriceMasterDTO)
     * 
     * Save Service For JuteQualityPriceMaster Entity
     * 
     * @Param
     * 
     * JuteQualityPriceMasterDTO
     * 
     */
    @Override
    public ResponseEntity<JuteQualityPriceMasterDTO> persistJuteQualityPriceMaster(JuteQualityPriceMasterDTO juteqltpricemasterDTO) {

    	ItemMaster item = itemDao.getItemMasterByItemDesc(juteqltpricemasterDTO.getitemCode());
    	JuteQualityPriceMaster juteqltpricemasterEntity = new JuteQualityPriceMaster();
    	juteqltpricemasterEntity.setitemCode(item.getId());
    	juteqltpricemasterEntity.setjuteQuality(juteqltpricemasterDTO.getjuteQuality());
    	juteqltpricemasterEntity.setrate(juteqltpricemasterDTO.getrate());
    	juteqltpricemasterEntity.setcurrency(juteqltpricemasterDTO.getcurrency());
    	juteqltpricemasterDao.addJuteQualityPriceMaster(juteqltpricemasterEntity);
	
    	return new ResponseEntity<JuteQualityPriceMasterDTO>(juteqltpricemasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.JuteQualityPriceMasterService#updateJuteQualityPriceMaster(com.example.master.dto.JuteQualityPriceMasterDTO)
     * 
     * Update Service For JuteQualityPriceMaster Entity
     * 
     * @Param
     * 
     * JuteQualityPriceMasterDTO
     * 
     */
    @Override
    public ResponseEntity<JuteQualityPriceMasterDTO> 
    								updateJuteQualityPriceMaster(JuteQualityPriceMasterDTO juteqltpricemasterDTO) {
    	ItemMaster item = itemDao.getItemMasterByItemDesc(juteqltpricemasterDTO.getitemCode());

    	JuteQualityPriceMaster juteqltpricemasterEntity = new JuteQualityPriceMaster();
    	juteqltpricemasterEntity.setitemCode(item.getId());
    	juteqltpricemasterEntity.setjuteQuality(juteqltpricemasterDTO.getjuteQuality());
    	juteqltpricemasterEntity.setrate(juteqltpricemasterDTO.getrate());
    	juteqltpricemasterEntity.setcurrency(juteqltpricemasterDTO.getcurrency());
		juteqltpricemasterEntity.setId(juteqltpricemasterDTO.getId());

		juteqltpricemasterDao.updateJuteQualityPriceMaster(juteqltpricemasterEntity);
	
		return new ResponseEntity<JuteQualityPriceMasterDTO>(juteqltpricemasterDTO, HttpStatus.CREATED);
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.JuteQualityPriceMasterService#populateJuteQualityPriceMasterList()
     * 
     * FetChing All JuteQualityPriceMaster
     * 
     */
    @Override
    public List<JuteQualityPriceMasterDTO> populateJuteQualityPriceMasterList() {
		List<JuteQualityPriceMasterDTO> juteqltpricemasterDTOList=new ArrayList<JuteQualityPriceMasterDTO>();
		try {
		    List<JuteQualityPriceMaster> juteqltpricemasterEntityList=juteqltpricemasterDao.findAll()
		    															.stream()
		    															.sorted(Comparator.comparing(
		    																	JuteQualityPriceMaster::getjuteQuality))
		    															.collect(Collectors.toList());
		    
		    juteqltpricemasterEntityList.forEach(juteqltpricemasterEntity->{
		    	juteqltpricemasterDTOList.add(prepareJuteQualityPriceMasterDTO(juteqltpricemasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return juteqltpricemasterDTOList;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.JuteQualityPriceMasterService#populateOneJuteQualityPriceMasterDetails(java.lang.Long)
     * 
     * Fetching JuteQualityPriceMaster By Id
     * 
     * @Param
     * 
     * Long ID
     * 
     */
    @Override
    public JuteQualityPriceMasterDTO populateOneJuteQualityPriceMasterDetails(Long Id) {
    	JuteQualityPriceMaster juteqltpricemasterEntity = juteqltpricemasterDao.findJuteQualityPriceMasterById(Id);
	
    	return prepareJuteQualityPriceMasterDTO(juteqltpricemasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.JuteQualityPriceMasterService#destroyJuteQualityPriceMaster(java.lang.Long)
     * 
     * Delete Service For JuteQualityPriceMaster
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public DeleteDTO destroyJuteQualityPriceMaster(Long id) {

    	juteqltpricemasterDao.deleteJuteQualityPriceMaster(id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
