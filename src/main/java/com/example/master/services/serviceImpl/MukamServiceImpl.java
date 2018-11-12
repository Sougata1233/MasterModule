package com.example.master.services.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.master.component.ItemMasterDao;
import com.example.master.component.MukamDao;
import com.example.master.component.MukamJuteComponent;
import com.example.master.component.MukamSupplierMapDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.JuteTypeDTO;
import com.example.master.dto.MukamDTO;
import com.example.master.entity.ItemMaster;
import com.example.master.entity.Mukam;
import com.example.master.entity.MukamJute;
import com.example.master.entity.MukamSupplier;
import com.example.master.services.MukamService;

/*
 * Service implementation class for mukam
 */
@Service
public class MukamServiceImpl implements MukamService {

    @Autowired
    MukamDao mukamDao;
    
    @Autowired
    MukamJuteComponent mukamJuteDao;
    
    @Autowired
    ItemMasterDao itemDao;
    
    @Autowired
    MukamSupplierMapDao mukammapDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(MukamServiceImpl.class);

    /*
    *preparing mukam DTO for fetching data 
    */
    private MukamDTO prepareMukamDTO(Mukam mukamEntity) {
    	
    	List<JuteTypeDTO> jutetypeList = new ArrayList<>();
    	JuteTypeDTO jutetypeDTO = new JuteTypeDTO();
    	
    	MukamDTO mukamDTO = new MukamDTO();
    	mukamDTO.setId(mukamEntity.getId());
    	mukamDTO.setmukamName(mukamEntity.getmukamName());
    	mukamDTO.setId(mukamEntity.getId());
    	
    	List<JuteTypeDTO> allitems = new ArrayList<>();
    	
    	String groupcode = "999";
		List<ItemMaster> item = itemDao.getItemMasterByGroupCode(groupcode);
		List<MukamJute> mukams = mukamJuteDao.findByMukamId(mukamEntity.getId());
		System.out.println(mukamEntity.getId());
		List<String> itemcodes = new ArrayList<>();
		String itemcode;
		for(int k = 0 ; k < mukams.size() ; k++) {
			itemcode = mukams.get(k).getItemJuteCode();
			itemcodes.add(itemcode);
		}
    	
		long start = Calendar.getInstance().getTimeInMillis();
		//fetching all jute type items
    	for(int j=0; j<item.size() ; j++) {
    		JuteTypeDTO itemmaster = new JuteTypeDTO();
    		String isMapped = "false";
    		System.out.println(itemcodes);
    		if(itemcodes.contains(item.get(j).getId())) {
    			isMapped = "true";
    		}else {
    			isMapped = "false";
    		}
    		itemmaster.setIsMapped(isMapped);
    		itemmaster.setitemDsc(item.get(j).getitemDsc());
    		itemmaster.setId(item.get(j).getId());
    		
    		allitems.add(prepareItemMasterDTO(itemmaster));
    		
    	}
    	long end = Calendar.getInstance().getTimeInMillis();
    	System.out.println("start "+start+" end "+end);
    	System.out.println((end-start));
    	mukamDTO.setItemJuteCode(allitems);
	
    	return mukamDTO;
    }


    /*
     * preparing DTO for jute items
     */
	private JuteTypeDTO prepareItemMasterDTO(JuteTypeDTO itemmaster) {
		JuteTypeDTO itemmasterDTO = new JuteTypeDTO();
		
		itemmasterDTO.setId(itemmaster.getId());
		itemmasterDTO.setitemDsc(itemmaster.getitemDsc());
		itemmasterDTO.setIsMapped(itemmaster.getIsMapped());
		
		return itemmasterDTO;
	}


	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.MukamService#persistMukam(com.example.master.dto.MukamDTO)
	 * saving mukam to the database in the table mukam as well as mukam_jute_map table
	 */
	@Override
    @Transactional
    public ResponseEntity<MukamDTO> persistMukam(MukamDTO mukamDTO) {

	
    	Mukam mukamEntity = new Mukam();
    	mukamEntity.setmukamName(mukamDTO.getmukamName().toUpperCase());
    	
    	mukamDao.save(mukamEntity);
    	
    	List<JuteTypeDTO> itemCode = mukamDTO.getItemJuteCode();
    	List<MukamJute> mukamjuteList = new ArrayList<>();
    	MukamJute mukamjute = new MukamJute();
    	
    	for( int i = 0 ; i < itemCode.size() ; i++ ) {
    		long nextval = mukamJuteDao.getNextVal();
    		System.out.println("The ID is: "+nextval);
    		mukamjute.setId(nextval);
    		mukamjute.setMukamId(mukamEntity.getId());
    		mukamjute.setItemJuteCode(itemCode.get(i).getId());
    		mukamjute.setIsMapped("true");
    		mukamjuteList.add(mukamJuteDao.save(mukamjute));

    	}
  
    	return new ResponseEntity<MukamDTO>(mukamDTO, HttpStatus.CREATED);

    }

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.MukamService#updateMukam(com.example.master.dto.MukamDTO)
	 * updating mukam table
	 */
    @Override
    public ResponseEntity<MukamDTO> updateMukam(MukamDTO mukamDTO) {

	    	Mukam mukamEntity = mukamDao.findMukamById(mukamDTO.getId());
			mukamEntity.setmukamName(mukamDTO.getmukamName());
			
			System.out.println("mukam Entity to send to dao is " + mukamEntity);
			
			mukamDao.save(mukamEntity);
			
			List<MukamJute> mukamjuteEntityList = mukamJuteDao.findByMukamId(mukamEntity.getId());
			long mappingid;
			List<Long> mappingids= new ArrayList<>();
			List<ItemMaster> itemmastergroup = itemDao.getItemMasterByGroupCode("999"); 
			
			
//			List<ItemMaster> itemlist = mukamDTO.getItemJuteCode();
			List<JuteTypeDTO> itemlist = mukamDTO.getItemJuteCode();
			List<MukamJute> mukamjuteList = new ArrayList<>();
			
			for(int i = 0 ; i <= itemlist.size()-1 ; i++) {
				String itemcode = mukamDTO.getItemJuteCode().get(i).getId();
				String isMapped = mukamDTO.getItemJuteCode().get(i).getIsMapped();
				MukamJute exist = new MukamJute();
				try {
				MukamJute mukammap = mukamJuteDao
						.findByMukamIdAndItemJuteCode(mukamDTO.getId(), itemcode);
				exist = mukammap;
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				//if the isMapped field of the DTO is true and the entity does not exists in the table then add
				if(mukamDTO.getItemJuteCode().get(i).getIsMapped().equalsIgnoreCase("true") && exist==null) {
					MukamJute mukamjute = new MukamJute();
					mukamjute.setItemJuteCode(itemcode);
					mukamjute.setMukamId(mukamEntity.getId());
					mukamjute.setIsMapped(isMapped);
					mukamjuteList.add(mukamJuteDao.save(mukamjute));
				}else if(mukamDTO.getItemJuteCode().get(i).getIsMapped().equalsIgnoreCase("true") && exist!=null){
					//if the isMapped field of the DTO is true and the entity exists in the table then update
					exist.setItemJuteCode(itemcode);
					exist.setMukamId(mukamEntity.getId());
					exist.setIsMapped(isMapped);
					mukamjuteList.add(mukamJuteDao.save(exist));
				}else if(mukamDTO.getItemJuteCode().get(i).getIsMapped().equalsIgnoreCase("false") && exist!=null){
					//if the isMapped field of the DTO is false and the entity exists in the table then delete
					mukamJuteDao.delete(exist.getId());
				}
			}
			
		return new ResponseEntity<MukamDTO>(mukamDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MukamService#populateMukamList()
     * fetching all datas from mukam table
     */
    @Override
    public List<MukamDTO> populateMukamList() {
	List<MukamDTO> mukamDTOList=new ArrayList<MukamDTO>();
	long start = Calendar.getInstance().getTimeInMillis();
	try {
	    List<Mukam> mukamEntityList=mukamDao.findAll();
	    String groupcode = "999";
		List<ItemMaster> item = itemDao.getItemMasterByGroupCode(groupcode);
	    mukamEntityList.forEach(mukamEntity->{
	    	mukamDTOList.add(prepareMukamDTO(mukamEntity,item));
	    });
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
	long end = Calendar.getInstance().getTimeInMillis();
	System.out.println("findall method "+(end-start));
	return mukamDTOList;
    }

    private MukamDTO prepareMukamDTO(Mukam mukamEntity, List<ItemMaster> item) {
    	List<JuteTypeDTO> jutetypeList = new ArrayList<>();
    	JuteTypeDTO jutetypeDTO = new JuteTypeDTO();
    	
    	MukamDTO mukamDTO = new MukamDTO();
    	mukamDTO.setId(mukamEntity.getId());
    	mukamDTO.setmukamName(mukamEntity.getmukamName());
    	mukamDTO.setId(mukamEntity.getId());
    	
    	List<JuteTypeDTO> allitems = new ArrayList<>();
    	
//    	String groupcode = "999";
//		List<ItemMaster> item = itemDao.getItemMasterByGroupCode(groupcode);
		List<MukamJute> mukams = mukamJuteDao.findByMukamId(mukamEntity.getId());
		System.out.println(mukamEntity.getId());
		List<String> itemcodes = new ArrayList<>();
		String itemcode;
		for(int k = 0 ; k < mukams.size() ; k++) {
			itemcode = mukams.get(k).getItemJuteCode();
			itemcodes.add(itemcode);
		}
    	
		long start = Calendar.getInstance().getTimeInMillis();
		//fetching all jute type items
    	for(int j=0; j<item.size() ; j++) {
    		JuteTypeDTO itemmaster = new JuteTypeDTO();
    		String isMapped = "false";
    		System.out.println(itemcodes);
    		if(itemcodes.contains(item.get(j).getId())) {
    			isMapped = "true";
    		}else {
    			isMapped = "false";
    		}
    		itemmaster.setIsMapped(isMapped);
    		itemmaster.setitemDsc(item.get(j).getitemDsc());
    		itemmaster.setId(item.get(j).getId());
    		
    		allitems.add(prepareItemMasterDTO(itemmaster));
    		
    	}
    	long end = Calendar.getInstance().getTimeInMillis();
    	System.out.println("start "+start+" end "+end);
    	System.out.println((end-start));
    	mukamDTO.setItemJuteCode(allitems);
	
    	return mukamDTO;
	}


	/*
     * (non-Javadoc)
     * @see com.example.master.services.MukamService#populateOneMukamDetails(java.lang.Long)
     * fetching a single mukam
     */
    @Override
    public MukamDTO populateOneMukamDetails(Long Id) {
    	Mukam mukamEntity = mukamDao.findMukamById(Id);
	return prepareMukamDTO(mukamEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MukamService#destroyMukam(java.lang.Long)
     * deleteing data from mukam table by mukamid
     */
    @Override
    public DeleteDTO destroyMukam(Long Id) {

    	List<MukamJute> mukamjute = mukamJuteDao.findByMukamId(Id);
    	List<MukamSupplier> mukamsupp = mukammapDao.getByMukamId(Id);
    	
    	for(int k = 0 ; k < mukamjute.size() ; k++) {
    		mukamJuteDao.delete(mukamjute.get(k).getId());
    	}
    	
		mukamDao.deleteMukam(Id);
		
		DeleteDTO deleteDTO = new DeleteDTO();
		deleteDTO.setstatus(1);
		deleteDTO.setstatusCode(2000);
		deleteDTO.setmsg("Deleted successfully.");
	
	
	return deleteDTO;
	
	
    }


	@Override
	public MukamDTO getAllMukamByMukamName(String mukam) {
		Mukam mukamEntity = mukamDao.findByMukamName(mukam);
		List<MukamJute> mukamjute = mukamJuteDao.findByMukamId(mukamEntity.getId());
		return prepareMukamDTO1(mukamEntity, mukamjute);
	}


	private MukamDTO prepareMukamDTO1(Mukam mukamEntity, List<MukamJute> mukams) {
		MukamDTO mukamDTO = new MukamDTO();
		
		mukamDTO.setId(mukamEntity.getId());
    	mukamDTO.setmukamName(mukamEntity.getmukamName());
    	mukamDTO.setIsMapped("TRUE");
    	
    	List<JuteTypeDTO> itemJuteCodes = new ArrayList<>();
    	for(int i = 0 ; i < mukams.size() ; i++) {
    		JuteTypeDTO itemJuteCode = new JuteTypeDTO();
    		String isMapped = mukams.get(i).getIsMapped();
    		if(isMapped.equals("true")) {
    			ItemMaster item = itemDao.findItemMasterById(mukams.get(i).getItemJuteCode());
    			itemJuteCode.setId(item.getId());
    			itemJuteCode.setitemDsc(item.getitemDsc());
    			itemJuteCode.setIsMapped("TRUE");
    			itemJuteCodes.add(itemJuteCode);
    		}
    	}
    	mukamDTO.setItemJuteCode(itemJuteCodes);
		return mukamDTO;
	}
}
