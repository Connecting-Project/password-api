package com.hawaiianpizza.password.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hawaiianpizza.password.model.Standard;
import com.hawaiianpizza.password.service.PasswordService;

@CrossOrigin(origins = "https://password.hawaiian-pizza.space/")
@RestController
@RequestMapping("/password")
public class PasswordController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final PasswordService passwordService;

	public PasswordController(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	@PostMapping(value = "/generate")
	public ResponseEntity<?> generate(@RequestBody Standard standard) {
		logger.info("generate start");
		try {
			String ret = passwordService.generator(standard);
			logger.info("generate sucess");
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("generate fail");
			return new ResponseEntity<>("generate fail", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
