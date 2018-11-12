package com.example.master.services.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.master.component.BrokerDao;
import com.example.master.component.BrokerSuplpierMukamDao;
import com.example.master.component.BrokerSuppMapDao;
import com.example.master.component.MukamDao;
import com.example.master.component.MukamSupplierMapDao;
import com.example.master.component.SupplierMasterDao;
import com.example.master.controller.SuppMapDTO;
import com.example.master.dto.BrokerDTO;
import com.example.master.dto.BrokerNewDTO;
import com.example.master.dto.BrokerSuppMukamDTO;
import com.example.master.dto.BrokerWithMukamDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.NewBrokerDTO;
import com.example.master.dto.NewSupplierDTO;
import com.example.master.dto.SupplierNewDTO;
import com.example.master.entity.Broker;
import com.example.master.entity.BrokerSuppMap;
import com.example.master.entity.Mukam;
import com.example.master.entity.MukamSupplier;
import com.example.master.entity.SupplierMaster;
import com.example.master.services.BrokerService;

/*
 * Service implementation class for broker_master table
 */
@Service
public class BrokerServiceImpl implements BrokerService {
	
	@Autowired
	BrokerDao brokerDao;
	
	@Autowired
	BrokerSuppMapDao brokersuppDao;
	
	@Autowired 
	SupplierMasterDao supplierDao;

	@Autowired
	MukamSupplierMapDao mukamsuppDao;
	
	@Autowired
	MukamDao mukamDao;
	
	@Autowired
	BrokerSuplpierMukamDao brokersuppmukDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.BrokerService#persistBroker(com.example.master.dto.BrokerDTO)
	 * saving data to the table broker_master
	 */
	@Override
	public ResponseEntity<BrokerDTO> persistBroker(BrokerDTO brokerDTO) {
		Broker broker = new Broker();
		broker.setAddress(brokerDTO.getAddress());
		broker.setBrokerName(brokerDTO.getBrokerName().toUpperCase());
		broker.setEmail(brokerDTO.getEmail());
		broker.setGst(brokerDTO.getGst());
		broker.setPan(brokerDTO.getPan());
		brokerDao.save(broker);
		
		List<SuppMapDTO> brokerSuppMapDTOs = brokerDTO.getSuppliers();
		List<BrokerSuppMap> brokersuppEmpList = new ArrayList<>();
		BrokerSuppMap brokersuppEmpEntity = new BrokerSuppMap();
		
		for(int i = 0 ; i < brokerSuppMapDTOs.size() ; i++) {
			String isMapped = null;
			System.out.println(brokerDTO.getIsMapped());
			long nextval = brokersuppDao.getNextVal();
			brokersuppEmpEntity.setMapId(nextval);
			brokersuppEmpEntity.setBrokerId(broker.getBrokerId());
			brokersuppEmpEntity.setSuppCode(brokerSuppMapDTOs.get(i).getId());
			brokersuppEmpEntity.setIsMapped("true");
			System.out.println(brokerSuppMapDTOs.get(i).getId());
			brokersuppEmpList.add(brokersuppDao.save(brokersuppEmpEntity));
		}
		
		return new ResponseEntity<BrokerDTO>(brokerDTO, HttpStatus.CREATED);
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.BrokerService#populateOneBrokerDetails(long)
	 * fetching a single data from broker_master table
	 */
	@Override
	public BrokerDTO populateOneBrokerDetails(long id) {
		Broker broker = brokerDao.getBrokerById(id);
		BrokerDTO broker1 = new BrokerDTO();
		try {
			broker1 = prepareBrokerDTO(broker);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return broker1;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.BrokerService#populateBrokerList()
	 * fetching all datas from broker_master table
	 */
	@Override
	public List<BrokerDTO> populateBrokerList() {
		List<BrokerDTO> brokerEmpList = new ArrayList<>();
		long start = Calendar.getInstance().getTimeInMillis();
		try {
			List<Broker> brokerList = brokerDao.getAllBroker()
										.stream()
										.sorted(Comparator.comparing(Broker::getBrokerName))
										.collect(Collectors.toList());
			
			brokerList.forEach(broker->{
				try {
					brokerEmpList.add(prepareBrokerDTO(broker));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("findall method "+(end-start));
		
		return brokerEmpList;
	}

	
	private BrokerDTO prepareBrokerDTO(Broker broker, List<SupplierMaster> supplier1) {
		BrokerDTO brokerDTO = new BrokerDTO();
		brokerDTO.setAddress(broker.getAddress());
		brokerDTO.setBrokerId(broker.getBrokerId());
		brokerDTO.setBrokerName(broker.getBrokerName());
		brokerDTO.setEmail(broker.getEmail());
		brokerDTO.setGst(broker.getGst());
		brokerDTO.setPan(broker.getPan());
		
		List<BrokerSuppMap> brokerSuppEnitty = brokersuppDao.getByBrokerId(broker.getBrokerId())
												.stream()
												.sorted(Comparator.comparing(BrokerSuppMap::getBrokerId))
												.collect(Collectors.toList());
		List<String> suppcodes = new ArrayList<>();
		String suppcode;
		for(int k = 0 ; k < brokerSuppEnitty.size() ; k++) {
			suppcode = brokerSuppEnitty.get(k).getSuppCode();
			suppcodes.add(suppcode);
		}
		
		
//		List<SupplierMaster> supplier1 = supplierDao.findBySuppType("J");
		long size = supplier1.size();
		List<SuppMapDTO> supplierEmpList = new ArrayList<>();
		System.out.println(brokerSuppEnitty);
		
		long start = Calendar.getInstance().getTimeInMillis();
		for(int i = 0; i<size; i++) {
			SuppMapDTO supplier = new SuppMapDTO();
			String isMapped = "false";
			
			if(suppcodes.contains(supplier1.get(i).getId())) {
				isMapped = "true";
			}else {
				isMapped = "false";
			}
			
			supplier.setIsMapped(isMapped);
			supplier.setId(supplier1.get(i).getId());
			supplier.setSuppName(supplier1.get(i).getsuppName());
			supplierEmpList.add(prepareSupplierDTO(supplier));
			
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
    	System.out.println("start "+start+" end "+end);
    	System.out.println((end-start));
		
		brokerDTO.setSuppliers(supplierEmpList);
		
		return brokerDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.BrokerService#deleteBroker(long)
	 * deleting data from broker_master by it's id
	 */
	@Override
	public DeleteDTO deleteBroker(long id) {
		
		List<BrokerSuppMap> brokersupps = brokersuppDao.getByBrokerId(id);
		brokerDao.delete(id);
		
		for(int k = 0 ; k < brokersupps.size() ; k++) {
			brokersuppDao.delete(brokersupps.get(k).getMapId());
		}
		
		DeleteDTO deleteDTO = new DeleteDTO();
		deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
		
		return deleteDTO;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.BrokerService#updateBroker(com.example.master.dto.BrokerDTO)
	 * updating broker_master table
	 */
	@Override
	public ResponseEntity<BrokerDTO> updateBroker(BrokerDTO broker) {
		Broker brokerEntity = brokerDao.getBrokerById(broker.getBrokerId());
		brokerEntity.setAddress(broker.getAddress());
		brokerEntity.setBrokerName(broker.getBrokerName());
		brokerEntity.setEmail(broker.getEmail());
		brokerEntity.setGst(broker.getGst());
		brokerEntity.setPan(broker.getPan());
		brokerDao.save(brokerEntity);
		
		
		List<SuppMapDTO> brokerSuppList = broker.getSuppliers();
		List<BrokerSuppMap> brokersuppEmp = new ArrayList<>();
		BrokerSuppMap brokersuppmapEmp = new BrokerSuppMap();
		
		
		for(int i = 0 ; i < brokerSuppList.size() ; i++) {
			String suppcode = brokerSuppList.get(i).getId();
			
			BrokerSuppMap brokersuppList =
					brokersuppDao.getByBrokerIdAndSuppCode(broker.getBrokerId(), 
							broker.getSuppliers().get(i).getId());
			
			if(broker.getSuppliers().get(i).getIsMapped().equalsIgnoreCase("true") && brokersuppList!=null) {
				brokersuppList.setBrokerId(brokerEntity.getBrokerId());
				brokersuppList.setSuppCode(suppcode);
				brokersuppList.setIsMapped(broker.getSuppliers().get(i).getIsMapped());
				brokersuppEmp.add(brokersuppDao.save(brokersuppList));
			}else if(broker.getSuppliers().get(i).getIsMapped().equalsIgnoreCase("true") && brokersuppList==null) {
				BrokerSuppMap brokermapEmp = new BrokerSuppMap();
				brokermapEmp.setBrokerId(brokerEntity.getBrokerId());
				brokermapEmp.setSuppCode(suppcode);
				brokermapEmp.setIsMapped(broker.getSuppliers().get(i).getIsMapped());
				brokersuppEmp.add(brokersuppDao.save(brokermapEmp));
			}else if(broker.getSuppliers().get(i).getIsMapped().equalsIgnoreCase("false") && brokersuppList!=null) {
				brokersuppDao.delete(brokersuppList.getMapId());
			}
		}
		
		return new ResponseEntity<BrokerDTO>(broker, HttpStatus.CREATED);
	}
	
	
	/*
	 * preparing brokerDTO for fetching data 
	 */
	private BrokerDTO prepareBrokerDTO(Broker broker) throws Exception {
		BrokerDTO brokerDTO = new BrokerDTO();
		brokerDTO.setAddress(broker.getAddress());
		brokerDTO.setBrokerId(broker.getBrokerId());
		brokerDTO.setBrokerName(broker.getBrokerName());
		brokerDTO.setEmail(broker.getEmail());
		brokerDTO.setGst(broker.getGst());
		brokerDTO.setPan(broker.getPan());
		
		List<BrokerSuppMap> brokerSuppEnitty = brokersuppDao.getByBrokerId(broker.getBrokerId());
		List<String> suppcodes = new ArrayList<>();
		String suppcode;
		for(int k = 0 ; k < brokerSuppEnitty.size() ; k++) {
			suppcode = brokerSuppEnitty.get(k).getSuppCode();
			suppcodes.add(suppcode);
		}
		
		
		List<SupplierMaster> supplier1 = supplierDao.findBySuppType("J")
											.stream()
											.sorted(Comparator.comparing(SupplierMaster::getsuppName))
											.collect(Collectors.toList());
		long size = supplier1.size();
		List<SuppMapDTO> supplierEmpList = new ArrayList<>();
		System.out.println(brokerSuppEnitty);
		
		long start = Calendar.getInstance().getTimeInMillis();
		for(int i = 0; i<size; i++) {
			SuppMapDTO supplier = new SuppMapDTO();
			String isMapped = "false";
			
			if(suppcodes.contains(supplier1.get(i).getId())) {
				isMapped = "true";
			}else {
				isMapped = "false";
			}
			
			supplier.setIsMapped(isMapped);
			supplier.setId(supplier1.get(i).getId());
			supplier.setSuppName(supplier1.get(i).getsuppName());
			supplierEmpList.add(prepareSupplierDTO(supplier));
			
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
    	System.out.println("start "+start+" end "+end);
    	System.out.println((end-start));
		
		brokerDTO.setSuppliers(supplierEmpList);
		
		return brokerDTO;
	}

	/*
	 * preparing Supplier mukam map DTO for fetching data
	 */
	private SuppMapDTO prepareSupplierDTO(SuppMapDTO supplier) {
		SuppMapDTO suppmapDTO = new SuppMapDTO();
		
		suppmapDTO.setId(supplier.getId());
		suppmapDTO.setSuppName(supplier.getSuppName());
		suppmapDTO.setIsMapped(supplier.getIsMapped());
		
		return suppmapDTO;
	}

	@Override
	public BrokerWithMukamDTO getBrokerSupplierMukamByBrokerId(long brokerId) {
		BrokerWithMukamDTO brokerDTO = new BrokerWithMukamDTO();
		
		List<MukamSupplier> mukamsupps = new ArrayList<>();
		List<MukamSupplier> mukamsupps2 = new ArrayList<>();
		List<SupplierMaster> suppliers = new ArrayList<>();
		List<Mukam> mukambroker = new ArrayList<>();
		List<Mukam> mukamsuppliers = new ArrayList<>();
		List<Long> mukamIds = new ArrayList<>();
		List<Long> mukamIds2 = new ArrayList<>();
		List<Long> mukamIdsDistinct = new ArrayList<>();
		List<Long> mukamIdsDistinct2 = new ArrayList<>();
		List<Broker> broker = new ArrayList<>();
		try {
			broker = brokerDao.getAllBroker();
			
			List<NewBrokerDTO> brokerDTOs = new ArrayList<>();
			broker.forEach(br->{
				NewBrokerDTO dto = new NewBrokerDTO();
				dto.setBrokerId(br.getBrokerId());
				dto.setBrokerName(br.getBrokerName());
				dto.setAddress(br.getAddress());
				brokerDTOs.add(dto);
			});
			
			List<BrokerSuppMap> brokersupp = brokersuppDao.getByBrokerId(brokerId);
			List<SupplierMaster> supplier = supplierDao.findBySuppType("J");
			List<NewSupplierDTO> supplierDTOs = new ArrayList<>();
			supplier.forEach(supp->{
				NewSupplierDTO dto = new NewSupplierDTO();
				dto.setAddress1(supp.getaddress1());
				dto.setSuppCode(supp.getId());
				dto.setSuppName(supp.getsuppName());
				supplierDTOs.add(dto);
			});
			for(int i = 0 ; i < brokersupp.size() ; i++) {
//				suppliers.add(supplier);
				mukamsupps = mukamsuppDao.getBySuppCode(brokersupp.get(i).getSuppCode());
				for(int j = 0 ; j < mukamsupps.size() ; j++) {
					Long mukamid = mukamsupps.get(j).getMukamId();
					mukamIds.add(mukamid);
				}
			}
			for(int x = 0 ; x < supplier.size() ; x++) {
				mukamsupps = mukamsuppDao.getBySuppCode(supplier.get(x).getId());
				for(int y = 0 ; y < mukamsupps.size() ; y++) {
					/*Mukam supplierMukam = mukamDao.getMukamById(mukamsupps.get(y).getMukamId());
					mukamsuppliers.add(supplierMukam);*/
					long mukamid2 = mukamsupps.get(y).getMukamId();
					mukamIds2.add(mukamid2);
				}
			}
			mukamIdsDistinct = mukamIds.stream().distinct().collect(Collectors.toList());
			for(int l = 0 ; l < mukamIdsDistinct.size() ; l++) {
				Mukam mukam = mukamDao.findMukamById(mukamIdsDistinct.get(l));
				mukambroker.add(mukam);
			}
			
			mukamIdsDistinct2 = mukamIds2.stream().distinct().collect(Collectors.toList());
			for(int m = 0 ; m < mukamIdsDistinct2.size() ; m++) {
				Mukam mukam = mukamDao.findMukamById(mukamIdsDistinct2.get(m));
				mukamsuppliers.add(mukam);
			}
			
			BrokerNewDTO br = new BrokerNewDTO();
			br.setBroker(brokerDTOs);
			br.setMukamBroker(mukambroker);
			
			SupplierNewDTO su = new SupplierNewDTO();
			su.setSupplier(supplierDTOs);
			su.setSupplierMukam(mukamsuppliers);
			
			brokerDTO.setBroker(br);
			brokerDTO.setSupplier(su);
//			brokerDTO.setMukamBroker(mukambroker);
//			brokerDTO.setSupplier(supplier);
//			brokerDTO.setSupplierMukam(mukamsuppliers);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return brokerDTO;
	}

	/*@Override
	public List<BrokerSuppMukamDTO> getBrokerMukamSupplier() {
		List<BrokerSuppMukamDTO> brokersuppDTO = new ArrayList<>();
		brokersuppDTO = brokersuppmukDao.getAllBrokerSuppMukam();
		return brokersuppDTO;
	}*/
	
	@Override
	public List<BrokerSuppMukamDTO> getBrokerMukamSupplier() {
		List<BrokerSuppMukamDTO> brokersuppDTO = new ArrayList<>();
		
		List<Broker> brokers = new ArrayList<>();
		List<SupplierMaster> suppliers = new ArrayList<>();
		List<Mukam> mukams = new ArrayList<>();
		List<MukamSupplier> mukamsupps = new ArrayList<>();
		try {
			brokers = brokerDao.getAllBroker();
			suppliers = supplierDao.findBySuppType("J");
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<BrokerSuppMap> brokersupps = new ArrayList<>();
//		List<Long> mids = new ArrayList<>();
		for(int i = 0 ; i < brokers.size() ; i++) {
			BrokerSuppMukamDTO dto = new BrokerSuppMukamDTO();
			
			/*List<Long> mukamIds = new ArrayList<>();
			brokersupps = brokersuppDao.getByBrokerId(brokers.get(i).getBrokerId());
			
			for(int k = 0 ; k < brokersupps.size() ; k++) {
				mukamsupps = mukamsuppDao.getBySuppCode(brokersupps.get(k).getSuppCode());
						
				for(int l = 0 ; l < mukamsupps.size() ; l++) {
					long mukamid = mukamsupps.get(l).getMukamId();
					mukamIds.add(mukamid);
				}
				mids = mukamIds.stream().distinct().collect(Collectors.toList());
			}
			
			for(int s = 0 ; s < mids.size() ; s++) {
				Mukam mukam = mukamDao.getMukamById(mids.get(s));
				mukams.add(mukam);
			}*/
			
			dto.setAddress1(brokers.get(i).getAddress());
//			dto.setMukams(mukams);
			dto.setSuppCode(String.valueOf(brokers.get(i).getBrokerId()));
			dto.setSuppName(brokers.get(i).getBrokerName());
			dto.setFlag("B");
			System.out.println("brokersupp "+brokersupps.size());
			brokersuppDTO.add(dto);
		}
		
		for(int j = 0 ; j < suppliers.size() ; j++) {
			BrokerSuppMukamDTO dto = new BrokerSuppMukamDTO();
			
			/*List<MukamSupplier> mukamsuppliers = mukamsuppDao.getBySuppCode(suppliers.get(j).getId());
			List<Long> mukamIds = new ArrayList<>();
			for(int r = 0 ; r < mukamsuppliers.size() ; r++) {
				long mukamid = mukamsuppliers.get(r).getMukamId();
				mukamIds.add(mukamid);
			}
			List<Long> mukamdistids = mukamIds.stream().distinct().collect(Collectors.toList());
			for(int y = 0 ; y < mukamIds.size() ; y++) {
				Mukam mukam = mukamDao.getMukamById(mukamdistids.get(y));
				mukams.add(mukam);
			}*/
			
			dto.setAddress1(suppliers.get(j).getaddress1());
//			dto.setMukams(mukams);
			dto.setSuppCode(suppliers.get(j).getId());
			dto.setSuppName(suppliers.get(j).getsuppName());
			System.out.println("Supp Code "+suppliers.get(j).getId());
			System.out.println("mukam size "+mukams.size());
			dto.setFlag("S");
			brokersuppDTO.add(dto);
		}
		return brokersuppDTO;
	}

	@Override
	public BrokerSuppMukamDTO getBrokerMukamSupplierById(String id) {
		BrokerSuppMukamDTO dto = new BrokerSuppMukamDTO();
		SupplierMaster suppliers = new SupplierMaster();
		Broker brokers = new Broker();
		if(id.startsWith("J")) {
			try {
				suppliers = supplierDao.findBySuppCodeAndSuppType(id, "J");
				
				List<MukamSupplier> mukamsupps = mukamsuppDao.getBySuppCode(suppliers.getId());
				List<Long> mukamids = new ArrayList<>();
				for(int i = 0 ; i < mukamsupps.size() ; i++) {
					long mid = mukamsupps.get(i).getMukamId();
					mukamids.add(mid);
				}
				List<Long> mids = mukamids.stream().distinct().collect(Collectors.toList());
				List<Mukam> mukams = new ArrayList<>();
				for(int j = 0 ; j < mids.size() ; j++) {
					Mukam mukam = mukamDao.getMukamById(mids.get(j));
					mukams.add(mukam);
				}
				
				dto.setMukams(mukams);
				dto.setAddress1(suppliers.getaddress1());
				dto.setSuppCode(suppliers.getId());
				dto.setSuppName(suppliers.getsuppName());
				dto.setFlag("S");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			brokers = brokerDao.getBrokerById(Long.parseLong(id));
			List<BrokerSuppMap> brokersupp = brokersuppDao.getByBrokerId(brokers.getBrokerId());
			List<Long> mukamids = new ArrayList<>();
			for(int i = 0 ; i < brokersupp.size() ; i++) {
				List<MukamSupplier> mukamsupp = mukamsuppDao.getBySuppCode(brokersupp.get(i).getSuppCode());
				for(int j = 0 ; j < mukamsupp.size() ; j++) {
					long mid = mukamsupp.get(j).getMukamId();
					mukamids.add(mid);
				}
			}
			
			List<Long> mids = mukamids.stream().distinct().collect(Collectors.toList());
			List<Mukam> mukams = new ArrayList<>();
			for(int k = 0 ; k < mids.size() ; k++) {
				Mukam mukam = mukamDao.findMukamById(mids.get(k));
				mukams.add(mukam);
			}
			dto.setMukams(mukams);
			dto.setAddress1(brokers.getAddress());
			dto.setSuppCode(String.valueOf(brokers.getBrokerId()));
			dto.setSuppName(brokers.getBrokerName());
			dto.setFlag("B");
		}
		
		return dto;
	}

	
}
