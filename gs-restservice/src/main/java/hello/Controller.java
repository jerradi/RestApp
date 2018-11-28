package hello;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = { "/greeting/.", "/grd?", "/welcome" },  produces =  MediaType.APPLICATION_JSON_VALUE)
	public Greeting greetings(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	 
	@RequestMapping(value = {
			"/	s" } ,  produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Greeting> getListOfItem(@PathVariable Integer nbr, @PathVariable String title) {

		return Arrays.asList(new String[nbr]).stream().map((s) -> {
			return new Greeting(8, randomString(nbr));
		}).collect(Collectors.toList());

	}

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	private static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}