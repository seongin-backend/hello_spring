package seongin_backend.hello_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args); //HelloSpringApplication 클래스 호출 - > @SpringBootApplication 어노테이션에 의해 서버 실행
	}

}
