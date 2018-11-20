package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
    private BookRepository repository;

    @Test
    public void findByAuthorShouldReturnBook() {
        List<Book> books = repository.findByAuthor("John Verdon");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Murhakierre");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Koululaisen ohjelmointikirja", "Rohan Sinha", 2017, "978-952-321-435-4", new Category("Kids"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

    
	@Test
	public void deleteTest() {
		
		Book book = new Book("Koululaisen ohjelmointikirja", "Rohan Sinha", 2017, "978-952-321-435-4", new Category("Kids"));
    	repository.save(book);

		repository.delete(book);
		assertThat(book.getId()).isNotNull();

	}
 
}
