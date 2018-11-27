package hello;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface ArticleRepository extends PagingAndSortingRepository<Article, String> {

	public Page<Book> findByName(@Param("name") String name, Pageable page);
	 
	
	public List<Article> findByPrice(int price);
	
	public List<Article> findByMessage(String message, Pageable page);
}

