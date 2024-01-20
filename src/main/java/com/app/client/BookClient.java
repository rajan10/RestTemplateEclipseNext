package com.app.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.binding.Book;

@Service
//restclient business logic is writtern under service
public class BookClient{
	
	public void invokeBookTicket() {
		String apiurl="https://fakerestapi.azurewebsites.net/api/v1/Books";
		Book book = new Book();
		book.setId(1001);
		book.setTitle("Rajan rocks");
		book.setDescription("Autobiographical book");
		book.setPageCount(100);
		book.setExcerpt("This is about the excerpt here of the book Rajan rocks");
		book.setPublishDate("1869-01-20");
		
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> postForEntity=rt.postForEntity(apiurl, book, String.class);//url, payload, restposttype
		System.out.println(postForEntity.getBody());
	}
}


