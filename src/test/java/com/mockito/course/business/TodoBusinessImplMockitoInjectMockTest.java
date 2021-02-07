package com.mockito.course.business;

import com.mockito.course.TodoBusinessImpl;
import com.mockito.course.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_WithEmptyList() {
        List<String> todos = Arrays.asList();
        Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {

        // given
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allTodos);

        // when
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        // then
        assertThat(todos.size(), is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring() {

        // given
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance", "Learn to read", "Learn to read");
        Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(allTodos);

        // when
        todoBusinessImpl.deleteTodosNotRelatedToString("Dummy");

        // then
        Mockito.verify(todoServiceMock, Mockito.times(1)).deleteTodo("Learn to Dance");
        Mockito.verify(todoServiceMock, Mockito.times(2)).deleteTodo("Learn to read");

    }

}
