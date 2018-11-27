package app.repos;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "library", type = "book")
public class Book {

	@Id
	@JsonProperty("_id")
	private String id;

	private String name, message, price, author;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	//
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
	public Book(String id, String name, String message, String price) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.price = price;
	}


	public Book(String name, String message, String price) {
		super();
		this.name = name;
		this.message = message;
		this.price = price;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}