package com.akhtariev.reversestring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   * @param toReverse the string to reverse
   * @return the reversed string and 200 response if success, 404 if string is malformed 
   */
  @GetMapping("/reverse/{str}")
  public ResponseEntity<String> reverseString(@PathVariable(value = "str") String toReverse) {
    if (toReverse == null || toReverse.isEmpty() || toReverse.isBlank()) {
      return ResponseEntity.badRequest().body("The string is malformed.");
    }

    char[] characters = toReverse.toCharArray();
    int firstIndex = 0;
    int lastIndex = toReverse.length() - 1;
    char temp;

    while(firstIndex < lastIndex) {
      temp = characters[firstIndex];
      characters[firstIndex] = characters[lastIndex];
      characters[lastIndex] = temp;
      
      ++firstIndex;
      --lastIndex;
    }

    return ResponseEntity.ok().body(new String(characters));
  }
}
