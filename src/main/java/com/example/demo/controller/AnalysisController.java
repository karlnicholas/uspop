package com.example.demo.controller;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AnalysisService;

@RestController
@RequestMapping("analysis")
public class AnalysisController {
	private final AnalysisService analysisService;
	public AnalysisController(AnalysisService analysisService) {
		this.analysisService = analysisService;
	}
	@GetMapping("{year}")
	public ResponseEntity<SummaryStatistics> getSummaryStatistics(@PathVariable Integer year) {
		return ResponseEntity.ok(analysisService.getSummaryStatistics(year));
	}

}
