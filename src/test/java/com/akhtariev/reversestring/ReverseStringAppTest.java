package com.akhtariev.reversestring;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes = ReverseStringApp.class)
@AutoConfigureMockMvc
public class ReverseStringAppTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testEmpty() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void testOne() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/a").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("a")));
	}

	@Test
	public void testEven() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/hi").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("ih")));
	}

	@Test
	public void testOdd() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/one").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("eno")));
	}
}