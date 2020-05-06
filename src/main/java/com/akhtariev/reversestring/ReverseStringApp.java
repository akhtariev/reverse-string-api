package com.akhtariev.reversestring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration 
public class ReverseStringApp {

	public static void main(String[] args) {
		SpringApplication.run(ReverseStringApp.class, args);
	}

	/**
   * Reverse a given string.
   *
   * @param str the string to reverse
   * @return the reversed string
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/reverse/{str}")
  public ResponseEntity<String> reverseString() {
	  return ResponseEntity.ok().body("");
  }

}
