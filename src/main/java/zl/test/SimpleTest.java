package zl.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.AdditionalMatchers.and;
import static zl.test.service.CompareThan.gt;
import static zl.test.service.CompareThan.lt;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 19:52 by zl 创建
 **/
public class SimpleTest {

    @Test
    public void test_lt() {

        assertThat(10, gt(9));

        assertThat(10, both(gt(2)).and(lt(20)));
    }
}
