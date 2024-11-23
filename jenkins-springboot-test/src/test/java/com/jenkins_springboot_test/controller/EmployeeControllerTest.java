package com.jenkins_springboot_test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllEmployeeTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/empall").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getOneEmployeeTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/emp/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void returnsNotFoundForInvalidEmployeeNo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/emp/50").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andReturn();
	}

	@Test
	public void createEmployeeTest() throws Exception {
		String newEmployee = "{\"empNo\":10,\"empName\":\"Ten\",\"salary\":1010.1}";
		mockMvc.perform(MockMvcRequestBuilders.post("/emp").contentType(MediaType.APPLICATION_JSON).content(newEmployee)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}

}
