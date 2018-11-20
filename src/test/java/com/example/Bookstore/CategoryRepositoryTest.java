package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void findBynameShouldReturnCategory() {
		List<Category> categories = categoryRepository.findByName("Horror");

		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Horror");
	}

	@Test
	public void createTest() {
		Category category = new Category("Kids");
		categoryRepository.save(category);

		categoryRepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void deleteTest() {
		
		Category category = new Category("Kids");
		categoryRepository.save(category);

		categoryRepository.delete(category);
		assertThat(category.getCategoryid()).isNotNull();

	}

}
