package com.example.master;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.master.controller.SupplierMasterController;
import com.example.master.dto.SupplierMasterDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MasterApplicationTests {
	
	@LocalServerPort
    private int port;
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Autowired
	private SupplierMasterController controller;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(controller.populateSupplierMasterList()).isNotNull().first();
		/*assertThat(this.restTemplate.getForObject("https://localhost:"+port+"/supplierMaster/getAllSupplierMaster",
				SupplierMasterDTO.class));*/
	}

}
