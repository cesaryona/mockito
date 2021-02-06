package com.mockito.course.data;

import java.util.Arrays;
import java.util.List;

import com.mockito.course.TodoService;

public class TodoServiceStub implements TodoService {
	
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	@Override
	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}
}