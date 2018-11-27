package app.repos;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "book", type = "cd")
public class Article {

	@Id
	@JsonProperty("_id")
	private String id;
 

	private String name, message, price;

	public Article() {
		// TODO Auto-generated constructor stub
	}
	

	public Article(String id, String name, String message, String price) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.price = price;
	}


	public Article(String name, String message, String price) {
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