package com.mahendra.demo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.mahendra.demo1.controllers.CurrenyConvertorController;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class Demo1ApplicationTests {
	
	MockMvc mocMvc;
	
	@BeforeEach
	void setUpMock() {
		this.mocMvc = MockMvcBuilders.standaloneSetup(new CurrenyConvertorController()).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testConvert() 
	{
		//mockMvc.perform(post("/hotels/{id}", 42).accept(MediaType.APPLICATION_JSON));
		try {
			mocMvc.perform(get("/convert?amount={amount}","12000")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to send a request, "+e.getMessage());
			
		}
	}
}
