package app.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@RequestMapping("/homein")
	public String homein(@CookieValue(value = "mCookie", defaultValue = "defaultCookieValue") String cookieValue,
			HttpServletResponse response) {
		response.addCookie(new Cookie("mCookie", "anookie"));
		System.out.println(cookieValue);

		return "homena";
	}

	@RequestMapping("/halam")
	@ResponseBody
	public String halam() {
		return "halamadrid";
	}

	@GetMapping(value = { "/", "" })
	public String index() {
		return "index";
	}

	@GetMapping(value = { "/server_error" })
	public String triggerServerError() {
		"ser".charAt(30);
		return "index";
	}

	@PostMapping(value = { "/general_error" }  )
	public String triggerGeneralError() {
		return "index";
	}
	@GetMapping(value = { "/ageneral_error" },produces={MediaType.APPLICATION_JSON_VALUE}  )
	public String triggerAnotherGeneralError() {
		return "index";
	}

}