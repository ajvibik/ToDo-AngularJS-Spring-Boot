package com.joseph.todo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.joseph.todo.model.Todo;
import com.joseph.todo.repository.TodoRepository;

@EnableMongoRepositories(basePackageClasses = TodoRepository.class)
@Component
public class MongoDBConfig {

	@Bean
	CommandLineRunner commandLineRunner(TodoRepository todoRepository) {
		return strings -> {
			todoRepository.save(new Todo("aaaa", "Design the Page", false));
			todoRepository.save(new Todo("bbbb", "Check the Documents", false));
			todoRepository.save(new Todo("cccc", "ru to server", false));
		};
	}

}
