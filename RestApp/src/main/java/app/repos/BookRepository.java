package app.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "library", path = "book"  )
public interface BookRepository extends PagingAndSortingRepository<Book, String> {
	@RestResource(exported = false)
	public Page<Book> findByName(@Param("name") String name, Pageable page);
	@RestResource(exported = false)
	public List<Book> findByPrice(int price);
	public List<Book> findByAuthor(String author);
 
}
