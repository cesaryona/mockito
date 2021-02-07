package com.mockito.course;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoBusinessImpl {

	private final TodoService todoService;

	public List<String> retrieveTodosRelatedToSpring(String user) {

		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);

		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;
	}

	public void deleteTodosNotRelatedToString(String user) {

		List<String> todos = todoService.retrieveTodos(user);

		for (String todo : todos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}

	}
}
