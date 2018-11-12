package com.example.master.services.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.master.component.MukamDao;
import com.example.master.component.MukamSupplierMapDao;
import com.example.master.component.SupplierMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.MukamSuppMapDTO;
import com.example.master.dto.SupplierMasterDTO;
import com.example.master.entity.Mukam;
import com.example.master.entity.MukamSupplier;
import com.example.master.entity.SupplierMaster;
import com.example.master.services.SupplierMasterService;

/*
 * Service implementation class for supplier_master table
 */
@Service
public class SupplierMasterServiceImpl implements SupplierMasterService {

	@Autowired
	SupplierMasterDao suppliermasterDao;

	@Autowired
	MukamDao mukamDao;

	@Autowired
	SupplierMasterDao supplierDao;

	@Autowired
	MukamSupplierMapDao mukammapDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(SupplierMasterServiceImpl.class);

	/*
	 * preparing supplier master DTO for displaying supplier master table details as
	 * well as mukams mapped with the respective supplier
	 */
	private SupplierMasterDTO prepareSupplierMasterDTO(SupplierMaster suppliermasterEntity) throws Exception {

		SupplierMasterDTO suppliermasterDTO = new SupplierMasterDTO();

		// getting supplier master data
		suppliermasterDTO.setsuppName(suppliermasterEntity.getsuppName().toUpperCase());
		suppliermasterDTO.setaddress1(suppliermasterEntity.getaddress1());
		suppliermasterDTO.setaddress2(suppliermasterEntity.getaddress2());
		suppliermasterDTO.setaddress3(suppliermasterEntity.getaddress3());
		// suppliermasterDTO.setsuppTyp(suppliermasterEntity.getsuppTyp());

		// setting supplier type with respect to database
		String type = suppliermasterEntity.getsuppTyp();
		String suppType = null;
		if (type.equalsIgnoreCase("J")) {
			suppType = "JUTE";
		} else if (type.equalsIgnoreCase("S")) {
			suppType = "STORE";
		} else if (type.equalsIgnoreCase("O")) {
			suppType = "OTHERS";
		}

		suppliermasterDTO.setsuppTyp(suppType);
		suppliermasterDTO.setphone1(suppliermasterEntity.getphone1());
		suppliermasterDTO.setphone2(suppliermasterEntity.getphone2());
		suppliermasterDTO.setfax(suppliermasterEntity.getfax());
		suppliermasterDTO.setcellPhone(suppliermasterEntity.getcellPhone());
		suppliermasterDTO.setemail(suppliermasterEntity.getemail());
		suppliermasterDTO.setuser1(suppliermasterEntity.getuser1());
		suppliermasterDTO.setdate1(suppliermasterEntity.getdate1());
		suppliermasterDTO.setuser2(suppliermasterEntity.getuser2());
		suppliermasterDTO.setdate2(suppliermasterEntity.getdate2());
		suppliermasterDTO.setuser3(suppliermasterEntity.getuser3());
		suppliermasterDTO.setdate3(suppliermasterEntity.getdate3());
		suppliermasterDTO.setuser4(suppliermasterEntity.getuser4());
		suppliermasterDTO.setdate4(suppliermasterEntity.getdate4());
		suppliermasterDTO.setactiveFlag(suppliermasterEntity.getactiveFlag());
		suppliermasterDTO.setsaleTaxNo(suppliermasterEntity.getsaleTaxNo());
		suppliermasterDTO.setblackListedTag(suppliermasterEntity.getblackListedTag());
		suppliermasterDTO.setblackListedDate(suppliermasterEntity.getblackListedDate());
		suppliermasterDTO.setvatno(suppliermasterEntity.getvatno());
		suppliermasterDTO.setcontactPerson(suppliermasterEntity.getcontactPerson());
		suppliermasterDTO.setdesignation(suppliermasterEntity.getdesignation());
		suppliermasterDTO.setcst(suppliermasterEntity.getcst());
		suppliermasterDTO.setcin(suppliermasterEntity.getcin());
		suppliermasterDTO.setgstNo(suppliermasterEntity.getgstNo());
		suppliermasterDTO.setpanNo(suppliermasterEntity.getpanNo());
		suppliermasterDTO.setmodby(suppliermasterEntity.getmodby());
		suppliermasterDTO.setmodifiedOn(suppliermasterEntity.getmodifiedOn());
		suppliermasterDTO.setdistrict(suppliermasterEntity.getdistrict());
		suppliermasterDTO.setstate(suppliermasterEntity.getstate());
		suppliermasterDTO.setcountry(suppliermasterEntity.getcountry());
		suppliermasterDTO.setpincode(suppliermasterEntity.getpincode());
		suppliermasterDTO.setId(suppliermasterEntity.getId());

		// getting mukam list only for supplier type jute
		if (suppliermasterEntity.getsuppTyp().equalsIgnoreCase("J")) {

			List<MukamSuppMapDTO> mukamEmpList = new ArrayList<>();
			MukamSuppMapDTO mukamEntityEmp = new MukamSuppMapDTO();

			// getting all the mukams and getting the size for the loop
			List<Mukam> mukamEmppList = mukamDao.findAll();
			long size = mukamEmppList.size();

			// getting supplier mukam mapping entity filtering by supplier code
			List<MukamSupplier> supps = mukammapDao.getBySuppCode(suppliermasterEntity.getId());
			List<Long> mukamids = new ArrayList<>();
			Long mukamid;
			// getting the mukam ids for all the supplier mukam map table
			for (int k = 0; k < supps.size(); k++) {
				mukamid = supps.get(k).getMukamId();
				mukamids.add(mukamid);
			}

			long start = Calendar.getInstance().getTimeInMillis();

			// loop for getting mukam list
			for (int i = 0; i < size; i++) {

				String isMapped = "false";
				if (mukamids.contains(mukamEmppList.get(i).getId())) {
					isMapped = "true";
				} else {
					isMapped = "false";
				}

				mukamEntityEmp.setIsMapped(isMapped);
				mukamEntityEmp.setId(mukamEmppList.get(i).getId());
				mukamEntityEmp.setMukamName(mukamEmppList.get(i).getmukamName());
				mukamEmpList.add(prepareMukamSuppDTO(mukamEntityEmp));
			}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println((end - start));

			suppliermasterDTO.setMukam(mukamEmpList);
		}

		return suppliermasterDTO;
	}

	/*
	 * preparing mukam supplier mapping table DTO
	 */
	private MukamSuppMapDTO prepareMukamSuppDTO(MukamSuppMapDTO mukamEntityEmp) {
		MukamSuppMapDTO mukam = new MukamSuppMapDTO();

		mukam.setId(mukamEntityEmp.getId());
		mukam.setIsMapped(mukamEntityEmp.getIsMapped());
		mukam.setMukamName(mukamEntityEmp.getMukamName());

		return mukam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.master.services.SupplierMasterService#persistSupplierMaster(com.
	 * example.master.dto.SupplierMasterDTO) saving supplier master data to the
	 * suppliermaster table as well as mukams data to the mukam_supp_map table
	 */
	@Override
	public ResponseEntity<SupplierMasterDTO> persistSupplierMaster(SupplierMasterDTO suppliermasterDTO) {

		/*
		 * for setting custom supplier code with is created by getting the first letter
		 * of t he supp_type and concata it with the sequence
		 */
		String code = suppliermasterDTO.getsuppTyp().toUpperCase() + suppliermasterDao.seqNextVal();

		SupplierMaster suppliermasterEntity = new SupplierMaster();
		suppliermasterEntity.setId(code);
		suppliermasterEntity.setsuppName(suppliermasterDTO.getsuppName().toUpperCase());
		suppliermasterEntity.setaddress1(suppliermasterDTO.getaddress1());
		suppliermasterEntity.setaddress2(suppliermasterDTO.getaddress2());
		suppliermasterEntity.setaddress3(suppliermasterDTO.getaddress3());
		suppliermasterEntity.setsuppTyp(suppliermasterDTO.getsuppTyp());

		suppliermasterEntity.setphone1(suppliermasterDTO.getphone1());
		suppliermasterEntity.setphone2(suppliermasterDTO.getphone2());
		suppliermasterEntity.setfax(suppliermasterDTO.getfax());
		suppliermasterEntity.setcellPhone(suppliermasterDTO.getcellPhone());
		suppliermasterEntity.setemail(suppliermasterDTO.getemail());
		suppliermasterEntity.setuser1(suppliermasterDTO.getuser1());
		suppliermasterEntity.setdate1(suppliermasterDTO.getdate1());
		suppliermasterEntity.setuser2(suppliermasterDTO.getuser2());
		suppliermasterEntity.setdate2(suppliermasterDTO.getdate2());
		suppliermasterEntity.setuser3(suppliermasterDTO.getuser3());
		suppliermasterEntity.setdate3(suppliermasterDTO.getdate3());
		suppliermasterEntity.setuser4(suppliermasterDTO.getuser4());
		suppliermasterEntity.setdate4(suppliermasterDTO.getdate4());
		suppliermasterEntity.setactiveFlag(suppliermasterDTO.getactiveFlag());
		suppliermasterEntity.setsaleTaxNo(suppliermasterDTO.getsaleTaxNo());
		suppliermasterEntity.setblackListedTag(suppliermasterDTO.getblackListedTag());
		suppliermasterEntity.setblackListedDate(suppliermasterDTO.getblackListedDate());
		suppliermasterEntity.setvatno(suppliermasterDTO.getvatno());
		suppliermasterEntity.setcontactPerson(suppliermasterDTO.getcontactPerson());
		suppliermasterEntity.setdesignation(suppliermasterDTO.getdesignation());
		suppliermasterEntity.setcst(suppliermasterDTO.getcst());
		suppliermasterEntity.setcin(suppliermasterDTO.getcin());
		suppliermasterEntity.setgstNo(suppliermasterDTO.getgstNo());
		suppliermasterEntity.setpanNo(suppliermasterDTO.getpanNo());

		suppliermasterEntity.setmodby(suppliermasterDTO.getmodby());
		suppliermasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		suppliermasterEntity.setdistrict(suppliermasterDTO.getdistrict());
		suppliermasterEntity.setstate(suppliermasterDTO.getstate());
		suppliermasterEntity.setcountry(suppliermasterDTO.getcountry());
		suppliermasterEntity.setpincode(suppliermasterDTO.getpincode());

		suppliermasterDao.addSupplierMaster(suppliermasterEntity);

		List<MukamSuppMapDTO> mukamlist = suppliermasterDTO.getMukam();
		System.out.println(mukamlist);
		List<MukamSuppMapDTO> mukamsuppmap = new ArrayList<>();
		MukamSuppMapDTO mukamsuppEntity = new MukamSuppMapDTO();

		// getting data of mukam supp map to save to the table mukam_supp_map table
		char type = suppliermasterDTO.getsuppTyp().charAt(0);
		System.out.println(type == 'J');
		if (type == 'J') {
			for (int i = 0; i <= mukamlist.size() - 1; i++) {
				long seq = mukammapDao.getSeq();
				mukamsuppEntity.setId(seq);
				mukamsuppEntity.setMukamName(mukamlist.get(i).getMukamName());
				mukamsuppEntity.setIsMapped("true");
				mukamsuppmap.add(mukamsuppEntity);
				mukammapDao.save(
						prepareMukamEntity(mukamsuppEntity, mukamlist.get(i).getId(), suppliermasterEntity.getId()));
			}
		}

		return new ResponseEntity<SupplierMasterDTO>(suppliermasterDTO, HttpStatus.CREATED);

	}

	/*
	 * preparing mukam supp mapping table data to saving the data to the table
	 */
	private MukamSupplier prepareMukamEntity(MukamSuppMapDTO mukamsuppEntity, long mukamid, String suppcode) {
		MukamSupplier mukamsupp = new MukamSupplier();

		mukamsupp.setIsMapped(mukamsuppEntity.getIsMapped());
		mukamsupp.setMukamId(mukamid);
		mukamsupp.setSupplierName(suppcode);

		return mukamsupp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.master.services.SupplierMasterService#updateSupplierMaster(com.
	 * example.master.dto.SupplierMasterDTO) updating suppliermaster table as well
	 * mukam_supp_map data
	 */
	@Override
	public ResponseEntity<SupplierMasterDTO> updateSupplierMaster(SupplierMasterDTO suppliermasterDTO) {

		String pin = suppliermasterDTO.getpincode();
		String phone1 = suppliermasterDTO.getphone1();
		String phone2 = suppliermasterDTO.getphone2();
		String gst = suppliermasterDTO.getgstNo();
		String pan = suppliermasterDTO.getpanNo();
		String cin = suppliermasterDTO.getcin();
		SupplierMaster suppliermaster = new SupplierMaster();
		if (suppliermasterDTO.getId() != null) {
			SupplierMaster suppliermasterEntity = suppliermasterDao.findSupplierMasterById(suppliermasterDTO.getId());

			suppliermasterEntity.setsuppName(suppliermasterDTO.getsuppName());
			suppliermasterEntity.setaddress1(suppliermasterDTO.getaddress1());
			suppliermasterEntity.setaddress2(suppliermasterDTO.getaddress2());
			suppliermasterEntity.setaddress3(suppliermasterDTO.getaddress3());
			
			phone1 = suppliermasterDTO.getphone1();
			phone2 = suppliermasterDTO.getphone2();
			if(phone1!=null) {
				if (phone1.matches(".*\\d+.*")) {
					if(phone1.length()==10) {
						suppliermasterEntity.setphone1(suppliermasterDTO.getphone1());
					};
				}
			}
			if(phone2!=null) {
				if (phone2.matches(".*\\d+.*")) {
					if(phone2.length()==10) {
						suppliermasterEntity.setphone2(suppliermasterDTO.getphone2());
					}
				}
			}
			
			suppliermasterEntity.setfax(suppliermasterDTO.getfax());
			suppliermasterEntity.setcellPhone(suppliermasterDTO.getcellPhone());
			suppliermasterEntity.setemail(suppliermasterDTO.getemail());
			suppliermasterEntity.setuser1(suppliermasterDTO.getuser1());
			suppliermasterEntity.setdate1(suppliermasterDTO.getdate1());
			suppliermasterEntity.setuser2(suppliermasterDTO.getuser2());
			suppliermasterEntity.setdate2(suppliermasterDTO.getdate2());
			suppliermasterEntity.setuser3(suppliermasterDTO.getuser3());
			suppliermasterEntity.setdate3(suppliermasterDTO.getdate3());
			suppliermasterEntity.setuser4(suppliermasterDTO.getuser4());
			suppliermasterEntity.setdate4(suppliermasterDTO.getdate4());
			suppliermasterEntity.setactiveFlag(suppliermasterDTO.getactiveFlag());
			suppliermasterEntity.setsaleTaxNo(suppliermasterDTO.getsaleTaxNo());
			suppliermasterEntity.setblackListedTag(suppliermasterDTO.getblackListedTag());
			suppliermasterEntity.setblackListedDate(suppliermasterDTO.getblackListedDate());
			suppliermasterEntity.setvatno(suppliermasterDTO.getvatno());
			suppliermasterEntity.setcontactPerson(suppliermasterDTO.getcontactPerson());
			suppliermasterEntity.setdesignation(suppliermasterDTO.getdesignation());
			suppliermasterEntity.setcst(suppliermasterDTO.getcst());
			
			cin = suppliermasterDTO.getcin();
			if(cin!=null) {
				if(cin.length()==21) {
					suppliermasterEntity.setcin(suppliermasterDTO.getcin());
				}
			}
//			suppliermasterEntity.setcin(suppliermasterDTO.getcin());
			
			gst = suppliermasterDTO.getgstNo();
			pan = suppliermasterDTO.getpanNo();
			if(gst!=null) {
				if(gst.length()==10) {
					suppliermasterEntity.setgstNo(suppliermasterDTO.getgstNo());;
				}
			}
			if(pan!=null) {
				if(pan.length()==10) {
					suppliermasterEntity.setpanNo(suppliermasterDTO.getpanNo());;
				}
			}
//			suppliermasterEntity.setgstNo(suppliermasterDTO.getgstNo());
//			suppliermasterEntity.setpanNo(suppliermasterDTO.getpanNo());
			
			suppliermasterEntity.setmodby(suppliermasterDTO.getmodby());
			suppliermasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
			suppliermasterEntity.setdistrict(suppliermasterDTO.getdistrict());
			suppliermasterEntity.setstate(suppliermasterDTO.getstate());
			suppliermasterEntity.setcountry(suppliermasterDTO.getcountry());

			pin = suppliermasterDTO.getpincode();
			if(pin!=null) {
				if (pin.matches(".*\\d+.*")) {
					if(pin.length()==6) {
						suppliermasterEntity.setpincode(suppliermasterDTO.getpincode());
					}
				}
			}

			suppliermasterEntity.setId(suppliermasterDTO.getId());

			System.out.println("suppliermaster Entity to send to dao is " + suppliermasterEntity);
			suppliermasterDao.save(suppliermasterEntity);
			List<MukamSuppMapDTO> mukamlist = suppliermasterDTO.getMukam();
			List<MukamSupplier> mukamsuppmap = new ArrayList<>();

			char type = suppliermasterDTO.getsuppTyp().charAt(0);
			if (type == 'J') {
				for (int i = 0; i <= mukamlist.size() - 1; i++) {
					MukamSupplier mukamsuppEntity = mukammapDao.getBySuppCodeAndMukamId(suppliermasterDTO.getId(),
							suppliermasterDTO.getMukam().get(i).getId());
					// if the isMapped field from the DTO is true and the entity is not present in
					// the table then add to the mapping table
					if (suppliermasterDTO.getMukam().get(i).getIsMapped().equalsIgnoreCase("true")
							&& mukamsuppEntity == null) {
						MukamSupplier mukamsuppEmp = new MukamSupplier();

						mukamsuppEmp.setMukamId(suppliermasterDTO.getMukam().get(i).getId());
						mukamsuppEmp.setSupplierName(suppliermasterDTO.getId());
						mukamsuppEmp.setIsMapped(mukamlist.get(i).getIsMapped());
						mukamsuppmap.add(mukammapDao.save(mukamsuppEmp));
					} else if (suppliermasterDTO.getMukam().get(i).getIsMapped().equalsIgnoreCase("true")
							&& mukamsuppEntity != null) {
						/*
						 * if the isMapped field from the DTO is true and the entity is present in the
						 * table then update the mapping table
						 */
						mukamsuppEntity.setIsMapped(mukamlist.get(i).getIsMapped());
						mukamsuppEntity.setMukamId(mukamlist.get(i).getId());
						mukamsuppEntity.setSupplierName(suppliermasterEntity.getId());
						mukamsuppmap.add(mukammapDao.save(mukamsuppEntity));
					} else if (suppliermasterDTO.getMukam().get(i).getIsMapped().equalsIgnoreCase("false")
							&& mukamsuppEntity != null) {
						/*
						 * if the ismapped field from the DTO is false then delete the entity
						 */
						mukammapDao.delete(mukamsuppEntity.getId());
					}
				}
			}

		}

		if (pin.matches(".*\\d+.*")) {
			System.out.println("inside created");
			System.out.println(pin);
			return new ResponseEntity<SupplierMasterDTO>(suppliermasterDTO, HttpStatus.CREATED);
		} else {
			System.out.println("inside cannot created");
			return new ResponseEntity<SupplierMasterDTO>(suppliermasterDTO, HttpStatus.ALREADY_REPORTED);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.master.services.SupplierMasterService#populateSupplierMasterList(
	 * ) fetching all the suppliers from supplier master data
	 */
	@Override
	public List<SupplierMasterDTO> populateSupplierMasterList() {
		List<SupplierMasterDTO> suppliermasterDTOList = new ArrayList<SupplierMasterDTO>();
		long start = Calendar.getInstance().getTimeInMillis();
		try {
			List<SupplierMaster> suppliermasterEntityList = suppliermasterDao.findAll().stream()
					.sorted(Comparator.comparing(SupplierMaster::getsuppName)).collect(Collectors.toList());
			List<Mukam> mukamEntityList = mukamDao.findAll();

			suppliermasterEntityList.forEach(suppliermasterEntity -> {
				try {
					suppliermasterDTOList.add(prepareSupplierMasterDTO(suppliermasterEntity, mukamEntityList));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("findall method " + (end - start));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suppliermasterDTOList;
	}

	// second prepareDTO
	private SupplierMasterDTO prepareSupplierMasterDTO(SupplierMaster suppliermasterEntity, List<Mukam> mukamEmppList) {
		SupplierMasterDTO suppliermasterDTO = new SupplierMasterDTO();

		// getting supplier master data
		suppliermasterDTO.setsuppName(suppliermasterEntity.getsuppName().toUpperCase());
		suppliermasterDTO.setaddress1(suppliermasterEntity.getaddress1());
		suppliermasterDTO.setaddress2(suppliermasterEntity.getaddress2());
		suppliermasterDTO.setaddress3(suppliermasterEntity.getaddress3());
		// suppliermasterDTO.setsuppTyp(suppliermasterEntity.getsuppTyp());

		// setting supplier type with respect to database
		String type = suppliermasterEntity.getsuppTyp();
		String suppType = null;
		if (type.equalsIgnoreCase("J")) {
			suppType = "JUTE";
		} else if (type.equalsIgnoreCase("S")) {
			suppType = "STORE";
		} else if (type.equalsIgnoreCase("O")) {
			suppType = "OTHERS";
		}

		suppliermasterDTO.setsuppTyp(suppType);

		suppliermasterDTO.setphone1(suppliermasterEntity.getphone1());
		suppliermasterDTO.setphone2(suppliermasterEntity.getphone2());
		suppliermasterDTO.setfax(suppliermasterEntity.getfax());
		suppliermasterDTO.setcellPhone(suppliermasterEntity.getcellPhone());
		suppliermasterDTO.setemail(suppliermasterEntity.getemail());
		suppliermasterDTO.setuser1(suppliermasterEntity.getuser1());
		suppliermasterDTO.setdate1(suppliermasterEntity.getdate1());
		suppliermasterDTO.setuser2(suppliermasterEntity.getuser2());
		suppliermasterDTO.setdate2(suppliermasterEntity.getdate2());
		suppliermasterDTO.setuser3(suppliermasterEntity.getuser3());
		suppliermasterDTO.setdate3(suppliermasterEntity.getdate3());
		suppliermasterDTO.setuser4(suppliermasterEntity.getuser4());
		suppliermasterDTO.setdate4(suppliermasterEntity.getdate4());
		suppliermasterDTO.setactiveFlag(suppliermasterEntity.getactiveFlag());
		suppliermasterDTO.setsaleTaxNo(suppliermasterEntity.getsaleTaxNo());
		suppliermasterDTO.setblackListedTag(suppliermasterEntity.getblackListedTag());
		suppliermasterDTO.setblackListedDate(suppliermasterEntity.getblackListedDate());
		suppliermasterDTO.setvatno(suppliermasterEntity.getvatno());
		suppliermasterDTO.setcontactPerson(suppliermasterEntity.getcontactPerson());
		suppliermasterDTO.setdesignation(suppliermasterEntity.getdesignation());
		suppliermasterDTO.setcst(suppliermasterEntity.getcst());
		suppliermasterDTO.setcin(suppliermasterEntity.getcin());
		suppliermasterDTO.setgstNo(suppliermasterEntity.getgstNo());
		suppliermasterDTO.setpanNo(suppliermasterEntity.getpanNo());
		suppliermasterDTO.setmodby(suppliermasterEntity.getmodby());
		suppliermasterDTO.setmodifiedOn(suppliermasterEntity.getmodifiedOn());
		suppliermasterDTO.setdistrict(suppliermasterEntity.getdistrict());
		suppliermasterDTO.setstate(suppliermasterEntity.getstate());
		suppliermasterDTO.setcountry(suppliermasterEntity.getcountry());
		suppliermasterDTO.setpincode(suppliermasterEntity.getpincode());
		suppliermasterDTO.setId(suppliermasterEntity.getId());

		// getting mukam list only for supplier type jute
		if (suppliermasterEntity.getsuppTyp().equalsIgnoreCase("J")) {

			List<MukamSuppMapDTO> mukamEmpList = new ArrayList<>();
			MukamSuppMapDTO mukamEntityEmp = new MukamSuppMapDTO();

			// getting all the mukams and getting the size for the loop
			// List<Mukam> mukamEmppList = mukamDao.findAll();
			long size = mukamEmppList.size();

			// getting supplier mukam mapping entity filtering by supplier code
			List<MukamSupplier> supps = mukammapDao.getBySuppCode(suppliermasterEntity.getId());
			List<Long> mukamids = new ArrayList<>();
			Long mukamid;
			// getting the mukam ids for all the supplier mukam map table
			for (int k = 0; k < supps.size(); k++) {
				mukamid = supps.get(k).getMukamId();
				mukamids.add(mukamid);
			}

			long start = Calendar.getInstance().getTimeInMillis();

			// loop for getting mukam list
			for (int i = 0; i < size; i++) {

				String isMapped = "false";
				if (mukamids.contains(mukamEmppList.get(i).getId())) {
					isMapped = "true";
				} else {
					isMapped = "false";
				}

				mukamEntityEmp.setIsMapped(isMapped);
				mukamEntityEmp.setId(mukamEmppList.get(i).getId());
				mukamEntityEmp.setMukamName(mukamEmppList.get(i).getmukamName());
				mukamEmpList.add(prepareMukamSuppDTO(mukamEntityEmp));
			}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println((end - start));

			suppliermasterDTO.setMukam(mukamEmpList);
		}

		return suppliermasterDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.master.services.SupplierMasterService#
	 * populateOneSupplierMasterDetails(java.lang.String) fetching a single supplier
	 * by supplier code
	 */
	@Override
	public SupplierMasterDTO populateOneSupplierMasterDetails(String Id) {
		SupplierMaster suppliermasterEntity = suppliermasterDao.findSupplierMasterById(Id);
		SupplierMasterDTO suppmasterDTO = new SupplierMasterDTO();
		try {
			suppmasterDTO = prepareSupplierMasterDTO(suppliermasterEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return suppmasterDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.master.services.SupplierMasterService#destroySupplierMaster(java.
	 * lang.String) deleting data from supplier master
	 */
	@Override
	public DeleteDTO destroySupplierMaster(String Id) {

		List<MukamSupplier> mukamsupp = mukammapDao.getBySuppCode(Id);
		suppliermasterDao.deleteSupplierMaster(Id);

		mukamsupp.forEach(mukam -> {
			mukammapDao.delete(mukam.getId());
		});

		DeleteDTO deleteDTO = new DeleteDTO();
		deleteDTO.setstatus(1);
		deleteDTO.setstatusCode(2000);
		deleteDTO.setmsg("Deleted Successfully.");

		return deleteDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.master.services.SupplierMasterService#getOtherTypeSupplierMaster(
	 * java.lang.String)
	 * 
	 * Fetching OtherTypeSupplier By SupplierType
	 * 
	 * @param
	 * 
	 * String suppType
	 * 
	 */
	@Override
	public List<SupplierMasterDTO> getOtherTypeSupplierMaster(String suppType) {
		List<SupplierMasterDTO> supplierDTOs = new ArrayList<>();
		try {
			List<SupplierMaster> suppliers = supplierDao.findBySuppType(suppType).stream()
					.sorted(Comparator.comparing(SupplierMaster::getsuppName)).collect(Collectors.toList());
			suppliers.forEach(supp -> {
				try {
					supplierDTOs.add(prepareSupplierMasterDTO(supp));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierDTOs;
	}
}
