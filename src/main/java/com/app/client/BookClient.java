package com.app.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.binding.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
//rest client business logic is writtern under service
public class BookClient{
	//private means the field/attribute 'webClient' can only be access within the class scope. Private promotes encapsulation and information binding.  final => immutability  and private final  => reusability
	private final WebClient webClient;
	//public BookClient(WebClient.Builder webClientBuilder) is a constructor for the 'BookClient' class. It takes a parameter of type 'WebClient.Builder'
	public BookClient(WebClient.Builder webClientBuilder)
	{
		//initializes the 'webclient' field using the 'webClientBuilder' object
		this.webClient = webClientBuilder.baseUrl("https://fakerestapi.azurewebsites.net/api/v1/Books").build();
	}
	
	public void invokeBookTicket() {
		String apiurl="https://fakerestapi.azurewebsites.net/api/v1/Books";
		Book book = new Book();
		book.setId(10010);
		book.setTitle("Rajan WebClient rocks");
		book.setDescription("Autobiographical book");
		book.setPageCount(999);
		book.setExcerpt("This is about the excerpt here of the book Rajan WebClient rocks");
		book.setPublishDate("2024-01-25");
		
		String response = webClient.post() //Define the HTTP method (POST)
				.uri(apiurl) //Define the URI
				//.contentType(MediaType.APPLICATION_JSON) //Define the content type
				
				// BodyInserters.fromValue() method is used to convert the book object into the request body.
				.body(BodyInserters.fromValue(book)) //Attach the requst body to the POST request. Here book is the payload
				.retrieve() //Get the response
				.bodyToMono(String.class)//Convert the response to String/Mono (asynchronous result)
				.block(); //Block the thread and wait for the result
		System.out.println(response);
				
	}
}
			
		
		
	


