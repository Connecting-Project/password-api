package com.hawaiianpizza.password.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hawaiianpizza.password.Model.Standard;
import com.hawaiianpizza.password.Service.PasswordService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/password")
public class PasswordController {

	private final PasswordService passwordService;

	public PasswordController(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	@PostMapping(value = "/generate")
	public ResponseEntity<?> generate(@RequestBody Standard standard) {
		System.out.println("generate Controller");
		try {
			String ret = passwordService.generator(standard);
			
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
