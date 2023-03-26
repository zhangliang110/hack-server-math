package zl.test.service;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;

import java.util.Comparator;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 19:53 by zl 创建
 **/
public class CompareThan<T extends Number> extends BaseMatcher<T> {

    private T value;

    private boolean greator;

    private Comparator comparator = new DefaultNumberComparable();

    public CompareThan(T value, boolean greator) {
        this.value = value;
        this.greator = greator;
    }

    public CompareThan(T value, boolean greator, Comparator comparator) {
        this.value = value;
        this.comparator = comparator;
        this.greator = greator;
    }


    @Override
    public boolean matches(Object item) {
        int bigger = this.comparator.compare(item, value);
        boolean biggerBol = bigger > 0;
        return greator ? biggerBol : !biggerBol;

    }

    @Factory
    public static <T extends Number> CompareThan<T> gt(T value) {
        return new CompareThan<>(value, true);
    }

    @Factory
    public static <T extends Number> CompareThan<T> lt(T value) {
        return new CompareThan<>(value, false);
    }

    private class DefaultNumberComparable<T extends Number> implements Comparator<T> {


        @Override
        public int compare(T actual, T input) {
            if (input instanceof Integer) {
                return actual.intValue() - input.intValue();
            }
            if (input instanceof Long) {
                boolean bigger = actual.longValue() > input.intValue();
                return bigger ? 1 : 0;
            }
            if (input instanceof Short) {
                boolean bigger = actual.shortValue() > input.shortValue();
                return bigger ? 1 : 0;
            }
            if (input instanceof Double) {
                boolean bigger = actual.doubleValue() > input.doubleValue();
                return bigger ? 1 : 0;

            }
            if (input instanceof Byte) {
                boolean bigger = actual.byteValue() > input.byteValue();
                return bigger ? 1 : 0;
            }
            if (input instanceof Float) {
                boolean bigger = actual.floatValue() > input.floatValue();
                return bigger ? 1 : 0;
            }
            throw new AssertionError("the number type not supported");
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("compare two number failed");
    }
}
