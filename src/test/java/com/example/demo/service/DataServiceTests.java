package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.example.demo.model.StatePop;
import com.example.demo.repository.StatePopRepository;

@SpringBootTest
public class DataServiceTests {

	@Mock StatePopRepository statePopRepository;
	@InjectMocks DataService dataService;
	@Test
	void testService() {
		List<StatePop> statesPop = Collections.singletonList(StatePop.builder().year(2019).state("Pennsylvania").population(1000L).build());
		doReturn(statesPop).when(statePopRepository).findAll(Mockito.<Example<StatePop>>any());
		List<StatePop> statesPopReturn = dataService.getStatePop(2019);
		assertEquals(statesPop, statesPopReturn);
	}

}

