package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.StatePop;
import com.example.demo.service.DataService;

@WebMvcTest(DataController.class)
class DataControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean DataService dataService;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		when(dataService.getStatePop(2019)).thenReturn(Collections.singletonList(StatePop.builder().year(2019).state("Pennsylvania").population(1000L).build()));
		this.mockMvc.perform(get("/data/2019")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"id\":null,\"state\":\"Pennsylvania\",\"year\":2019,\"population\":1000}")));
	}
}
