package hello;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "noAddresses", types = { Book.class }) 
public interface NoAddresses {  
	public String getMessage();
 
	  
}
