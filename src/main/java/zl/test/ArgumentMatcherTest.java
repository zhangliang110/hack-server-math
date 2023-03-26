package zl.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 16:02 by zl 创建
 **/
@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatcherTest {

    public List<String> strList = new ArrayList<>();

    @Before
    public void init() {
        strList = mock(ArrayList.class);
    }

    @Test
    public void test_list() {
        when(strList.get(0)).thenReturn("100");

        assertThat(strList.get(0), equalTo("100"));

        assertThat(strList.get(1), nullValue());
    }

    @Test
    public void test_complex() {
        Foo mockFoo = mock(Foo.class);
        when(mockFoo.function(Mockito.any())).thenReturn(100);
        int result = mockFoo.function(new Child());
        assertThat(result, equalTo(100));

        result = mockFoo.function(new Child2());
        assertThat(result, equalTo(100));


    }

    static class Foo {
        int function(Parent t) {
            return t.work();
        }
    }

    interface Parent {
        int work();
    }

    class Child implements Parent {
        @Override
        public int work() {
            return 0;
        }
    }

    class Child2 implements Parent {

        @Override
        public int work() {
            throw new RuntimeException("throw exception");
        }
    }
}
