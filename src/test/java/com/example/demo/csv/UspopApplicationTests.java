package com.example.demo.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.StatePop;

@SpringBootTest
class UspopApplicationTests {

	@Test
	void csvTest() {
		List<StatePop> statesPop = new USPopReader().getUSPop();
		assertEquals(50*19, statesPop.size());
	}

}
