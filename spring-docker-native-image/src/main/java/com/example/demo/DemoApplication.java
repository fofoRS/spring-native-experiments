package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping("/")
	public ResponseEntity<GreetingHttpResponse> home(@RequestParam(value = "name",required = false)String name) {
		String message;
		if (!ObjectUtils.isEmpty(name)) {
			message = String.format("Hello %s! I'm native in this world", name);

		} else {
			message = "Hello World! I'm native in this world";
		}

		return ResponseEntity.ok(new GreetingHttpResponse(message));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
