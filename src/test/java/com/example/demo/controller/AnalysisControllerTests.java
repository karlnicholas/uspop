package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.AnalysisService;

@WebMvcTest(AnalysisController.class)
class AnalysisControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean AnalysisService analysisService;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		SummaryStatistics summaryStatistics = new SummaryStatistics();
		summaryStatistics.addValue(1000.0);
		when(analysisService.getSummaryStatistics(2019)).thenReturn(summaryStatistics);
		this.mockMvc.perform(get("/analysis/2019")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"n\":1")));
	}
}
