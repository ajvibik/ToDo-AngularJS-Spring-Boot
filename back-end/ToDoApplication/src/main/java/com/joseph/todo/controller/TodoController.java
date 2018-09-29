package com.joseph.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joseph.todo.model.Todo;
import com.joseph.todo.service.TodoService;

@RestController
@CrossOrigin("*")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping("/todo")
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@RequestMapping("/todo/{id}")
	public Optional<Todo> getTodoById(@PathVariable String id) {
		return todoService.getTodo(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/todo")
	private void addTodo(@RequestBody Todo todo) {
		todoService.addTodo(todo);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/todo/{id}")
	public void updateTopic(@PathVariable("id") String id, @RequestBody Todo todo) {
		todoService.updateTodo(id, todo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/todo/{id}")
	public void deleteTopics(@PathVariable String id) {
		todoService.deleteTodo(id);
	}

}
