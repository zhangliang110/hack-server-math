package zl.test.service;

import java.io.Serializable;
import java.util.Collection;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 16:35 by zl 创建
 **/
public class SimpleService {

    public int methodA(int i, String s, Collection<?> c, Serializable serializable) {
        if (i == 0) {
            throw new RuntimeException("000 can't hold zero");
        }
        return 0;
    }

    public void methodB(int i, String s, Collection<?> c, Serializable serializable) {
        throw new RuntimeException();
    }
}
