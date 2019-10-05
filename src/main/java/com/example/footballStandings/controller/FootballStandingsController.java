package com.example.footballStandings.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.footballStandings.exception.ResultNotFoundException;
import com.example.footballStandings.model.FootBallResponse;
import com.example.footballStandings.service.FootballStandingService;
import com.example.footballStandings.model.ResponseWrapper;

public class FootballStandingsController {

private static final Logger LOGGER = LoggerFactory.getLogger(FootballStandingsController.class);
	
	@Autowired
	private FootballStandingService footballService;

	@GetMapping("/api/findStandingDetails")
	public ResponseEntity<ResponseWrapper> getTeamStanding(@RequestParam final String countryName,
			@RequestParam final String leagueName, @RequestParam final String teamName) {
		try {
			FootBallResponse standingDetails = footballService.getStandingDetails(countryName, leagueName, teamName);
			return ResponseEntity.ok(ResponseWrapper.success(standingDetails));
		} catch (ResultNotFoundException e) {
			LOGGER.error("No result found", e);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error(e.getMessage()));
		} catch (Exception ex) {
			LOGGER.error("Error occurred", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}
	
}
