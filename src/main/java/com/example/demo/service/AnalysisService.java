package com.example.demo.service;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.springframework.stereotype.Service;

import com.example.demo.model.StatePop;
import com.example.demo.repository.StatePopRepository;

@Service
public class AnalysisService {
	private final StatePopRepository statePopRepository;
	public AnalysisService(StatePopRepository statePopRepository) {
		this.statePopRepository = statePopRepository;
	}
	public SummaryStatistics getSummaryStatistics(Integer year) {
		SummaryStatistics summaryStatistics = new SummaryStatistics();
		statePopRepository.findAll().stream().map(StatePop::getPopulation).forEach(pop->summaryStatistics.addValue(Double.parseDouble(pop.toString())));
		return summaryStatistics;
	}

}
