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

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
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
				
				// Create users: admin/admin user/user
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
				
				
				log.info("fetch all books");
				for (Book book : brepository.findAll()) {
					log.info(book.toString());
			}

			};
	}
}
