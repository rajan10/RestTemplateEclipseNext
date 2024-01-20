package com.app.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.binding.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
//restclient business logic is writtern under service
public class BookClient{
	
	public void invokeBookTicket() {
//		String apiurl="https://fakerestapi.azurewebsites.net/api/v1/Books";
//		Book book = new Book();
//		book.setId(1001);
//		book.setTitle("Rajan rocks");
//		book.setDescription("Autobiographical book");
//		book.setPageCount(100);
//		book.setExcerpt("This is about the excerpt here of the book Rajan rocks");
//		book.setPublishDate("1869-01-20");
		
		String json ="{\"id\":1001,\"title\":\"Sajan rocks\",\"description\":\"Autobiographical book\",\"pageCount\":100,\"excerpt\":\"This is about the excerpt here of the book Sajan rocks\",\"publishDate\":\"1869-01-20\"}";
		// Use Jackson library to parse the JSON String to Java object
		ObjectMapper mapper = new ObjectMapper();
		try {
			//Deserialize JSON to Java object
			Book sajanRocks = mapper.readValue(json, Book.class);
			//Access individual attributes
			System.out.println(sajanRocks.getId());
			System.out.println(sajanRocks.getTitle());
			System.out.println(sajanRocks.getDescription());
			System.out.println(sajanRocks.getPageCount());
			System.out.println(sajanRocks.getExcerpt());
			System.out.println(sajanRocks.getPublishDate());
			
		} 
		catch (JsonProcessingException e) 
		{
			e.printStackTrace();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
			
		
		
	


