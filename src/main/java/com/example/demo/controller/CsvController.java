package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.csv.USPopReader;
import com.example.demo.repository.StatePopRepository;

@RestController
@RequestMapping("csv")
public class CsvController {
	private final StatePopRepository statePopRepository;
	public CsvController(StatePopRepository statePopRepository) {
		this.statePopRepository = statePopRepository;
	}
	@GetMapping
	public ResponseEntity<Void> loadData() {
		new USPopReader().getUSPop().forEach(statePopRepository::save);
		return ResponseEntity.ok().build();
	}
}
