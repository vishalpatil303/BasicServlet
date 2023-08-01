package com.amigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootExampleAmigosCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleAmigosCodeApplication.class, args);
	}

//	@GetMapping("/")
//	public GreetResponse getGreeting() {
//
//		return new GreetResponse("Hello",List.of("JAVA","PYTHON","C++","C","C#"),
//				new Person(
//						"Vishal","Dwarkunde",LocalDate.of(1987, 11, 6)
//				));
//	}
//
//	record Person(String firstName,String lastName, LocalDate birthdate) {}
//
//	record GreetResponse(String greet,
//				List<String> lang ,
//				Person person
//			) {}
//

//	class Greet{
//
//		private String greetName;
//
//		Greet(String greetName){
//			this.greetName = greetName;
//		}
//
//		public String getGreetName() {
//			return greetName;
//		}
//
//		public void setGreetName(String greetName) {
//			this.greetName = greetName;
//		}
//
//
//	}

}
