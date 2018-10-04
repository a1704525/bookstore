package com.example.Bookstore;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookDemo(BookRepository brepository, CategoryRepository crepository) {
				return (args) -> {
				log.info("saving books");
				crepository.save(new Category("Drama"));
				crepository.save(new Category("Mystery"));
				crepository.save(new Category("Romance"));
				crepository.save(new Category("Fiction"));
				crepository.save(new Category("Horror"));
				
				brepository.save(new Book ("Harry Potter ja viisasten kivi", "J.K. Rowling", 1997, "978-952-04-0180-1", crepository.findByName("Fiction").get(0)));
				brepository.save(new Book ("Murhakierre", "John Verdon", 2012, "978-951-20-9668-8", crepository.findByName("Mystery").get(0)));
				brepository.save(new Book ("tyt", "John", 2012, "978-951-20-9668-8", crepository.findByName("Mystery").get(0)));
								
				log.info("fetch all books");
				for (Book book : brepository.findAll()) {
					log.info(book.toString());
			}

			};
	}
}
