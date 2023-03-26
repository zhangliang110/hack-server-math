package zl.test;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Description: assert matcher相关用法
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 19:41 by zl 创建
 **/
public class AssertMatcherTest {

    @Test
    public void test_v1() {
        double a = 123.23d;
        assertThat(a, either(equalTo(123.23)).or(equalTo(1231.12333)));
        assertThat(a, both(equalTo(123.23)).and(not(equalTo(33.2))));


        assertThat(a, allOf(is(123.23d), not(is(222.2d)), not(is(23.23))));

        assertThat(Stream.of(1, 2, 3).allMatch(i -> i > 0), equalTo(true));
        assertThat(Stream.of(1, 2, 3).anyMatch(i -> i > 2), equalTo(true));

    }

    @Test
    public void test_v2(){
        double price = 23.2d;
        assertThat("price not illegal", price, is(23.11));
    }
}
