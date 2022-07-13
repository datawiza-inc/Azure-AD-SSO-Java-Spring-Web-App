package com.datawiza.accessbroker;

import com.datawiza.accessbroker.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class ProfileController {

	@GetMapping
	public String greeting(@RequestHeader(value = Constant.HEADER_KEY_USERNAME, defaultValue = Constant.NOT_FOUND) String username,
		@RequestHeader(value = Constant.HEADER_KEY_EMAIL, defaultValue = Constant.NOT_FOUND) String email,
		@RequestHeader(value = Constant.HEADER_KEY_TOKEN, defaultValue = Constant.NOT_FOUND) String token,
		@RequestHeader(value = Constant.HEADER_KEY_USER, defaultValue = Constant.NOT_FOUND) String user,Model model) {
		if (!user.equals(Constant.NOT_FOUND)) {
			model.addAttribute(Constant.HEADER_KEY_USER, user);
			model.addAttribute(Constant.HEADER_KEY_USERNAME, username);
			model.addAttribute(Constant.HEADER_KEY_EMAIL, email);
			model.addAttribute(Constant.HEADER_KEY_TOKEN, token);
		}
		return "profile";
	}

}
