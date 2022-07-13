package com.datawiza.accessbroker;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.datawiza.accessbroker.util.Constant;

@WebMvcTest(controllers = ProfileController.class)
class ServingWebContentApplicationTest {

	private String defaultURL = "/";

	private String headerUsernameValue = "testUsername";
	private String headerEmailValue = "test@datawiza.com";
	private String headerTokenValue = "testToken";
	private String headerUserValue = "true";

	private String responseUsernameFormat = "Hello, your username is %s.";
	private String responseEmailFormat = "Your email is %s.";
	private String responseTokenFormat = "Your access token is %s";


	@Autowired
	private MockMvc mockMvc;

	@Test
	void requestWithoutUser() throws Exception {
		mockMvc.perform(get(defaultURL))
			.andExpect(content().string(containsString("User not found!")));
	}

	@Test
	void requestWithUsernameOnly() throws Exception {
		mockMvc.perform(get(defaultURL)
			.header(Constant.HEADER_KEY_USER, headerUserValue)
			.header(Constant.HEADER_KEY_USERNAME, headerUsernameValue))
			.andExpect(content().string(containsString(String.format(responseUsernameFormat, headerUsernameValue))))
			.andExpect(content().string(containsString(String.format(responseEmailFormat, Constant.NOT_FOUND))))
			.andExpect(content().string(containsString(String.format(responseTokenFormat, Constant.NOT_FOUND))));
	}

	@Test
	void requestWithEmailOnly() throws Exception {
		mockMvc.perform(get(defaultURL)
			.header(Constant.HEADER_KEY_USER, headerUserValue)
			.header(Constant.HEADER_KEY_EMAIL, headerEmailValue))
			.andExpect(content().string(containsString(String.format(responseUsernameFormat, Constant.NOT_FOUND))))
			.andExpect(content().string(containsString(String.format(responseEmailFormat, headerEmailValue))))
			.andExpect(content().string(containsString(String.format(responseTokenFormat, Constant.NOT_FOUND))));
	}

	@Test
	void requestWithTokenOnly() throws Exception {
		mockMvc.perform(get(defaultURL)
			.header(Constant.HEADER_KEY_USER, headerUserValue)
			.header(Constant.HEADER_KEY_TOKEN, headerTokenValue))
			.andExpect(content().string(containsString(String.format(responseUsernameFormat, Constant.NOT_FOUND))))
			.andExpect(content().string(containsString(String.format(responseEmailFormat, Constant.NOT_FOUND))))
			.andExpect(content().string(containsString(String.format(responseTokenFormat, headerTokenValue))));
	}

	@Test
	void requestWithUsernameEmailAndToken() throws Exception {
		mockMvc.perform(get(defaultURL)
			.header(Constant.HEADER_KEY_USER, headerUserValue)
			.header(Constant.HEADER_KEY_USERNAME, headerUsernameValue)
			.header(Constant.HEADER_KEY_EMAIL, headerEmailValue)
			.header(Constant.HEADER_KEY_TOKEN, headerTokenValue))
			.andExpect(content().string(containsString(String.format(responseUsernameFormat, headerUsernameValue))))
			.andExpect(content().string(containsString(String.format(responseEmailFormat, headerEmailValue))))
			.andExpect(content().string(containsString(String.format(responseTokenFormat, headerTokenValue))));
	}
}
