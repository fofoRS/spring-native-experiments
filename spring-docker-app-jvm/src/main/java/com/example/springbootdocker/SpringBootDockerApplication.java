package com.example.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

	@GetMapping("/")
	public ResponseEntity<GreetingHttpResponse> home(@RequestParam(value = "name",required = false)String name) {
		String message;
		if (!ObjectUtils.isEmpty(name)) {
			message = String.format("Hello %s", name);

		} else {
			message = "Hello Docker world!";
		}

		return ResponseEntity.ok(new GreetingHttpResponse(message));
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
