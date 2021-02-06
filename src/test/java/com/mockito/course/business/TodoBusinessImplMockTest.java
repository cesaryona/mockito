package com.mockito.course.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.mockito.course.TodoBusinessImpl;
import com.mockito.course.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		TodoService todoServiceMock = Mockito.mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);

		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	void testRetrieveTodosRelatedToSpring_WithEmptyList() {
		TodoService todoServiceMock = Mockito.mock(TodoService.class);
		List<String> todos = Arrays.asList();
		Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);

		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}

	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		// given
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

		// when
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");

		// then
		assertThat(todos.size(), is(2));
	}

}
