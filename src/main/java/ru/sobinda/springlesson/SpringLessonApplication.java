package ru.sobinda.springlesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringLessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLessonApplication.class, args);
	}

	@GetMapping("/")
	private String hello() {
		return "Hello";
	}

}
