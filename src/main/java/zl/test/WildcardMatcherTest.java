package zl.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import zl.test.service.SimpleService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 16:34 by zl 创建
 **/
@RunWith(MockitoJUnitRunner.class)
public class WildcardMatcherTest {

    @Mock
    private SimpleService service;

    @Test
    public void test_wildcardMethod() {
        when(service.methodA(anyInt(), anyString(), anyCollection(), isA(Serializable.class))).thenReturn(100);

        int result = service.methodA(123, "123", new ArrayList<>(), String.class);
        assertThat(result, equalTo(100));
    }

    @Test
    public void test_MethodASpecial() {
        when(service.methodA(anyInt(), eq("Alex"), anyCollection(), isA(Serializable.class))).thenReturn(200);
        when(service.methodA(anyInt(), eq("zhang"), anyCollection(), isA(Serializable.class))).thenReturn(100);

        int result = service.methodA(123, "Alex", Collections.emptyList(), String.class);
        assertThat(result, equalTo(200));

        int result2 = service.methodA(123, "zhang", Collections.emptyList(), String.class);
        assertThat(result2, equalTo(100));
    }

    @Test
    public void test_MethodBSpecial() {
        List<Object> emptyList = Collections.emptyList();
        doNothing().when(service).methodB(anyInt(), eq("Alex"), anyCollection(), isA(Serializable.class));
        service.methodB(1, "Alex", emptyList, String.class);

        verify(service, times(1)).methodB(1, "Alex", emptyList, String.class);

        doNothing().when(service).methodB(anyInt(), eq("zhang"), anyCollection(), isA(Serializable.class));


    }

    @After
    public void destroy() {
        reset(service);
    }
}
