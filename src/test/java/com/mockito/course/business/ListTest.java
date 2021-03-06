package com.mockito.course.business;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;

public class ListTest {

    @Test
    public void mockListSize() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void mockListSize_ReturnMultipleValues() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void mockListGet() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.get(anyInt())).thenReturn("mockito-course");

        assertEquals("mockito-course", listMock.get(0));
        assertEquals("mockito-course", listMock.get(1));
    }

    @Test
    public void mockListGet_usingBDD() {

        // given
        List<String> listMock = Mockito.mock(List.class);
        given(listMock.get(anyInt())).willReturn("mockito-course");

        // when
        String firstElement = listMock.get(0);

        // then
        assertThat(firstElement, is("mockito-course"));
        assertEquals("mockito-course", listMock.get(1));
    }

//	@Test
//	public void mockList_throwAnExcepton() {
//		List listMock = Mockito.mock(List.class);
//		Mockito.when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
//
//		listMock.get(0);
//	}
}
