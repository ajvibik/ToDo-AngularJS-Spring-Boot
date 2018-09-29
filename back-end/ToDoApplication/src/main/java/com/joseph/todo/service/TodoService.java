package com.joseph.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.todo.model.Todo;
import com.joseph.todo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> getAllTodos() {
		List<Todo> todos = new ArrayList<Todo>();
		todoRepository.findAll().forEach(todos::add);
		return todos;
	}

	public Optional<Todo> getTodo(String id) {
		return todoRepository.findById(id);
	}

	public void addTodo(Todo todo) {
		todoRepository.save(todo);
	}

	public void updateTodo(String id, Todo todo) {
		todoRepository.findById(id).map(todoData -> {
			todoData.setText(todo.getText());
			todoData.setDone(todo.isDone());
			Todo updatedTodo = todoRepository.save(todoData);
			return updatedTodo;
		});

	}

	public void deleteTodo(String id) {
		todoRepository.deleteById(id);

	}
}
