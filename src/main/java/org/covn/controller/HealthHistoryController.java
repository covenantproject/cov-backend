package org.covn.controller;

import org.covn.model.db.HealthCheckHistory;
import org.covn.repository.EntityRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HealthHistoryController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	private EntityRepo repo;

	@PostMapping("/updatehealthinfo")
	public ResponseEntity<HealthCheckHistory> healthHistoryRegister(@RequestBody HealthCheckHistory healthHistory) {
		try {
			repo.save(healthHistory);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_HealthHistory", ex);
			throw new RuntimeException("Save Couldn't Complete");
		}

		return new ResponseEntity<>(healthHistory, HttpStatus.OK);
	}
}
