package com.app.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.binding.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
//restclient business logic is writtern under service
public class BookClient{
	
	private final RestTemplate restTemplate;
	public BookClient(RestTemplateBuilder restTemplateBuilder)//RestTemplateBuilder is injected into the 'BookClient' 
	{
		this.restTemplate=restTemplateBuilder.build();//create a instance of RestTemplate and configure it using build()
	}
	
	public void invokeBookTicket() {
		String apiurl="https://fakerestapi.azurewebsites.net/api/v1/Books";
		Book book = new Book();
		book.setId(10010);
		book.setTitle("Rajan RestTemplateBuilder rocks");
		book.setDescription("Autobiographical book");
		book.setPageCount(1000);
		book.setExcerpt("This is about the excerpt here of the book Rajan RestTemplateBuilder rocks");
		book.setPublishDate("2024-01-20");
	  
		ResponseEntity<String> postForEntity =restTemplate.postForEntity(apiurl, book, String.class);
		System.out.println(postForEntity.getBody());
	}
}
			
		
		
	


