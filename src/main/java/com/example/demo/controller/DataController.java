package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StatePop;
import com.example.demo.service.DataService;

@RestController
@RequestMapping("data")
public class DataController {
	private final DataService dataService;
	public DataController(DataService dataService) {
		this.dataService = dataService;
	}
	@GetMapping()
	public List<StatePop> getStatePopAll() {
		return dataService.getAllStatePop();
	}
	@GetMapping("{year}")
	public List<StatePop> getStatePop(@PathVariable Integer year) {
		return dataService.getStatePop(year);
	}

}
