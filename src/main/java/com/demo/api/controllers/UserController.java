/**
 * @author Karthik Selvaraj
 *
 * 
 */
package com.demo.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.models.Login;
import com.demo.api.repositories.LoginRepository;
import com.demo.api.repositories.ProfileRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private LoginRepository loginRepository;

	// sample using jpa repository
	@GetMapping("/profile/list")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(profileRepository.findAll(), HttpStatus.OK);
	}

	// sample using jpa repository with basic conditions
	@GetMapping(path = "/profile/list", params = { "firstname" })
	public ResponseEntity<?> getAllUserProfile(@RequestParam String firstname) {
		return new ResponseEntity<>(profileRepository.findAllByFirstname(firstname), HttpStatus.OK);
	}

	// sample using custom repository
	// @GetMapping(path = "/list", params = { "state" })
	// public ResponseEntity<?> getAllUsers(@RequestParam String state) {
	// return new ResponseEntity<>(userRepository.findAllByUserProfileState(state),
	// HttpStatus.OK);
	// }
	@PostMapping("/create")
	public Login createUser(@Valid @RequestBody Login login) {

		login.setPassword(bcryptEncoder.encode(login.getPassword()));
		profileRepository.save(login.getProfile());

		return loginRepository.save(login);
	}
}