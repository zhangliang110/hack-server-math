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
import static org.mockito.Mockito.when;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 15:41 by zl 创建
 **/
@RunWith(MockitoJUnitRunner.class)
public class SpyingTest {

    @Before
    public void init() {

    }

    @After
    public void after() {

    }

    @Test
    public void test_spying() {
        List<String> listStr = new ArrayList<>();
        List<String> mockList = Mockito.spy(listStr);
        mockList.add("zhangl");
        mockList.add("mockito");

        assertThat(mockList.get(0), equalTo("zhangl"));
        assertThat(mockList.get(1), equalTo("mockito"));

        when(mockList.isEmpty()).thenReturn(true);
        when(mockList.size()).thenReturn(1);

        assertThat(mockList.get(0), equalTo("zhangl"));
        assertThat(mockList.get(1), equalTo("mockito"));
        assertThat(mockList.isEmpty(), equalTo(true));
        assertThat(mockList.size(), equalTo(1));

    }
}
