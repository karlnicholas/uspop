package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.model.StatePop;
import com.example.demo.repository.StatePopRepository;

@Service
public class DataService {
	private final StatePopRepository statePopRepository;

	public DataService(StatePopRepository statePopRepository) {
		this.statePopRepository = statePopRepository;
	}
	
	public List<StatePop> getStatePop(Integer year) {
		return statePopRepository.findAll(Example.of(StatePop.builder().year(year).build()));
	}
	public List<StatePop> getAllStatePop() {
		return statePopRepository.findAll();
	}

}
