package com.mockito.course;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoBusinessImpl {

	private TodoService todoService;

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
}
