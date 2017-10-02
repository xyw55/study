package com.xyw55.gof.iterator;

/**
 * Created by xiayiwei on 12/16/16.
 */
public interface Myiterator<E> {
    E first();

    E end();

    E next();

    boolean hasNext();
}
