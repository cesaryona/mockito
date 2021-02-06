package com.mockito.course.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mockito.course.TodoBusinessImpl;
import com.mockito.course.TodoService;
import com.mockito.course.data.TodoServiceStub;

class TodoBusinessImplStubTest {

	@Test
	void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
