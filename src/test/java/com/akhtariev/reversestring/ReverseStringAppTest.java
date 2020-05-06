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
				.andExpect(status().isNotFound());
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

	@Test
	public void testBlank() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/   ").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testSpacesAround() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/ an ").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(" na ")));
	}

	@Test
	public void testLongEven() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/security").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("ytiruces")));
	}

	@Test
	public void testLongOdd() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/challenge").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("egnellahc")));
	}

	@Test
	public void testAllSame() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/aaaaaaaa").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("aaaaaaaa")));
	}

	@Test
	public void testNumeric() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/7783022645").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("5462203877")));
	}

	@Test
	public void testNonAlphaNum() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reverse/+-)(*").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("*()-+")));
	}
}
