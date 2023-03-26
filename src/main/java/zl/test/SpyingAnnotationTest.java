package zl.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Description: 使用注解的方式进行mock spying
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 15:49 by zl 创建
 **/
@RunWith(MockitoJUnitRunner.class)
public class SpyingAnnotationTest {

    @Spy
    List<String> realList = new ArrayList<>();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
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
