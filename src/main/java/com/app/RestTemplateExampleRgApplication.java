package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.client.BookClient;
//in summary this application initializes a Spring Boot context and retrieves a bean of type BookClient from application context
@SpringBootApplication  //@Configuration, @EnableAutoConfiguration, and @ComponentScan
public class RestTemplateExampleRgApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RestTemplateExampleRgApplication.class, args);//IOC object
		BookClient bean =run.getBean(BookClient.class);//retrieves a bean of type BookClient from IOC/applicaiton context
		bean.invokeBookTicket();
	}

}
