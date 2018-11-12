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

import com.example.master.component.MenuMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.MenuMasterDTO;
import com.example.master.dto.SubmenuMasterDTO;
import com.example.master.entity.MenuMaster;
import com.example.master.entity.SubmenuMaster;
import com.example.master.services.MenuMasterService;

/*
 * Service Class For MenuMaster
 */
@Service
public class MenuMasterServiceImpl implements MenuMasterService {

    @Autowired
    MenuMasterDao menumasterDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(MenuMasterServiceImpl.class);

   /*
    * Preparing DTO For MenuMaster Entity
    */
    private MenuMasterDTO prepareMenuMasterDTO(MenuMaster menumasterEntity) {
    	MenuMasterDTO menumasterDTO = new MenuMasterDTO();
    	
    	menumasterDTO.setmenu(menumasterEntity.getmenu());
     	menumasterDTO.setmodby(menumasterEntity.getmodby());
     	menumasterDTO.setmodifiedOn(menumasterEntity.getmodifiedOn());
     	menumasterDTO.setmenuIconName(menumasterEntity.getmenuIconName());
	 	menumasterDTO.setId(menumasterEntity.getId());
	
	 	List<SubmenuMasterDTO> stDTOList=new ArrayList<SubmenuMasterDTO>();
    	
    	for (SubmenuMaster submenu: menumasterEntity.getSubmenuMaster()) {
    		SubmenuMasterDTO submenuDTO = new SubmenuMasterDTO();
    		
    		submenuDTO.setId(submenu.getId());
    		submenuDTO.setmenuId(submenu.getmenuId());
        	submenuDTO.setsubMenu(submenu.getsubMenu());
        	submenuDTO.setmodBy(submenu.getmodBy());
        	submenuDTO.setmodOn(submenu.getmodOn());
        	stDTOList.add(submenuDTO);
        }
    	
    	menumasterDTO.setSubmenuMaster(stDTOList);

	    return menumasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MenuMasterService#persistMenuMaster(com.example.master.dto.MenuMasterDTO)
     * 
     * Save Service For MenuMaster
     * 
     * @Param
     * 
     * MenuMasterDTO
     * 
     */
    @Override
    public ResponseEntity<MenuMasterDTO> persistMenuMaster(MenuMasterDTO menumasterDTO) {
    	MenuMaster menumasterEntity = new MenuMaster();

    	menumasterEntity.setmenu(menumasterDTO.getmenu());
    	menumasterEntity.setmodby(menumasterDTO.getmodby());
    	menumasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	menumasterEntity.setmenuIconName(menumasterDTO.getmenuIconName());
    	
    	menumasterDao.addMenuMaster(menumasterEntity);
	   
    	return new ResponseEntity<MenuMasterDTO>(menumasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MenuMasterService#updateMenuMaster(com.example.master.dto.MenuMasterDTO)
     * 
     * Update Service For MenuMaster Entity
     * 
     * @Param
     * 
     * MenuMasterDTO
     * 
     */
    @Override
    public ResponseEntity<MenuMasterDTO> updateMenuMaster(MenuMasterDTO menumasterDTO) {
    	MenuMaster menumasterEntity = new MenuMaster();
    	
    	menumasterEntity.setmenu(menumasterDTO.getmenu());
    	menumasterEntity.setmodby(menumasterDTO.getmodby());
    	menumasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	menumasterEntity.setmenuIconName(menumasterDTO.getmenuIconName());
    	menumasterEntity.setId(menumasterDTO.getId());

    	menumasterDao.updateMenuMaster(menumasterEntity);
	
    	return new ResponseEntity<MenuMasterDTO>(menumasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MenuMasterService#populateMenuMasterList()
     * 
     * Fetching All MenuMaster Entity
     * 
     */
    @Override
    public List<MenuMasterDTO> populateMenuMasterList() {
		List<MenuMasterDTO> menumasterDTOList=new ArrayList<MenuMasterDTO>();
		try {
		    List<MenuMaster> menumasterEntityList=menumasterDao.findAll()
		    													.stream()
		    													.sorted(Comparator.comparing(MenuMaster::getmenu))
		    													.collect(Collectors.toList());
		    
		    menumasterEntityList.forEach(menumasterEntity->{
		    	menumasterDTOList.add(prepareMenuMasterDTO(menumasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return menumasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MenuMasterService#populateOneMenuMasterDetails(java.lang.Long)
     * 
     * Fetching MenuMaster By Id
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public MenuMasterDTO populateOneMenuMasterDetails(Long Id) {
    	MenuMaster menumasterEntity = menumasterDao.findMenuMasterById(Id);
	
    	return prepareMenuMasterDTO(menumasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MenuMasterService#destroyMenuMaster(java.lang.Long)
     * 
     * Delete MenuMaster By MenuId
     * 
     * @Param
     * 
     * Long menuId
     * 
     */
    @Override
    public DeleteDTO destroyMenuMaster(Long menuId) {

    	menumasterDao.deleteMenuMaster(menuId);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
