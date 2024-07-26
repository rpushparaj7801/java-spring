package com.annotations.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);

		helloworld helloWorld = ctx.getBean(helloworld.class);
		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();




	}

}
