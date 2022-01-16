package com.scalar.common;

/**
 * @author t0k02w6 on 15/01/22
 * @project scalar-ds
 */
public class QueryTriplet<T, S, U> {
    T first;
    S second;
    U third;

    public QueryTriplet(T first, S second, U third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public U getThird() {
        return third;
    }

    public void setThird(U third) {
        this.third = third;
    }
}

