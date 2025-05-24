package com.learning.GatewayService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConstantsService.constants.Constants;

import org.springframework.http.ResponseEntity;

@RestController
public class StudentController {

	@GetMapping("/getName")
	public ResponseEntity<String> getName() {
		return ResponseEntity.ok(Constants.NAME);
	}
}
