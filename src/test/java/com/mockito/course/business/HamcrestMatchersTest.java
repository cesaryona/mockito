package com.mockito.course.business;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void testHamcrestMatchers() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        Assert.assertThat(scores, hasSize(4));
        Assert.assertThat(scores, hasItems(99, 100));

        Assert.assertThat(scores, everyItem(greaterThan(90)));
        Assert.assertThat(scores, everyItem(lessThan(190)));

        Integer[] marks = {1, 2, 3};
        Assert.assertThat(marks, arrayWithSize(3));
        Assert.assertThat(marks, arrayContaining(1, 2, 3));
        Assert.assertThat(marks, arrayContainingInAnyOrder(3, 2, 1));

    }
}
