package com.joseph.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joseph.todo.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {

}
