package com.xyw55.gof.iterator;

import java.util.Arrays;

/**
 * Created by xiayiwei on 16/10/6.
 */
public class MyArrayList<E> {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(3);
        for (int i = 0; i < 4; i++) {
            myArrayList.add(i);
        }
        myArrayList.remove(2);
        myArrayList.set(1,"5");
        System.out.println(myArrayList.get(1));

        System.out.println(myArrayList);
    }


    private Object[] elementData;

    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            System.out.println("error init");
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
    }

    public void add(E e) {
        ensureCapacityInternal(size + 1);
        this.elementData[size] = e;
        size++;
    }

    public E remove(int index) {
        rangeCheck(index);
        Object oldValue = elementData[index];
        // 删除最后一个元素不用移动
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return (E) oldValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    public void set(int index, E e) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        elementData[index] = e;
    }

    public void ensureCapacityInternal(int capacity) {
        if (capacity > elementData.length) {
            Object[] newArray = new Object[size * 2];
            System.arraycopy(elementData, 0, newArray, 0, size);
            elementData = newArray;
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("range out");
        }
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new RuntimeException("range out");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }


    private class Iterator implements Myiterator<E> {
        int cursor = 0;

        @Override
        public E first() {
            return (E) elementData[0];
        }

        @Override
        public E end() {
            return (E) elementData[size];
        }

        @Override
        public E next() {
            int i = cursor;
            E next = get(i);
            cursor = i + 1;
            return next;
        }

        @Override
        public boolean hasNext() {
            return cursor <= size;
        }
    }

}
