package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.StatePop;
import com.example.demo.repository.StatePopRepository;

@SpringBootTest
public class AnalysisServiceTests {

	@Mock StatePopRepository statePopRepository;
	@InjectMocks AnalysisService analysisService;
	@Test
	void testService() {
		List<StatePop> statesPop = Collections.singletonList(StatePop.builder().year(2019).state("Pennsylvania").population(1000L).build());
		doReturn(statesPop).when(statePopRepository).findAll();
		SummaryStatistics stats = analysisService.getSummaryStatistics(2019);
		assertEquals(1000.0, stats.getMin());
		assertEquals(1000.0, stats.getMax());
		assertEquals(1000.0, stats.getMean());
		assertEquals(0.0, stats.getStandardDeviation());
	}

}

