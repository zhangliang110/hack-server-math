package zl.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 15:12 by zl 创建
 **/
@RunWith(MockitoJUnitRunner.class)
public class MockItoTest {

    private List<String> list;

    @Before
    public void init() {
        list = Mockito.mock(ArrayList.class);
    }

    @After
    public void destroy() {
        reset(list);
    }

    @Test
    public void test_stubbingWithAnswer() {
        when(list.get(anyInt())).thenAnswer(invocationOnMock -> {
            Integer index = invocationOnMock.getArgument(0, Integer.class);
            return String.valueOf(index * 100);
        });
        when(list.get(1)).thenCallRealMethod();
        assertThat(list.get(0), equalTo("0"));
        assertThat(list.get(999), equalTo("999"));
    }
}
