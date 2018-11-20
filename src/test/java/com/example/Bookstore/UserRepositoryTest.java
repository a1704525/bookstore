package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	 @Autowired
	  private UserRepository userRepository;
	 
	 
	   @Test
	    public void findByUsernameShouldReturnUser() {
	        User user = userRepository.findByUsername("user");
	        
	      
	        assertThat(user.getUsername()).isEqualTo("user");
	    }

	  @Test
	  public void createTest() {
	    User user = new User("Tom", "rgdgdgdfgfdgfdgfdgs3243", "user");
	    userRepository.save(user);
	    
	    userRepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }   
	   
	  @Test
		public void deleteTest() {
			
		  	User user = new User("Tomsdsdsds", "rgdsdsdsdsds3243", "user");
		    userRepository.save(user);

		    userRepository.delete(user);
			assertThat(user.getId()).isNotNull();

		}
	  }

	
