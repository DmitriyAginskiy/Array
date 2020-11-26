package com.aginskiy.single.entity;

import java.util.Arrays;

public class SingleArray {

    private int[] array;

    public SingleArray() {

    }

    public SingleArray(int[] array) {
        this.array = array;
    }

    public SingleArray(int size) {
        array = new int[size];
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSize() {
        return array.length;
    }


    public int getElement(int index) {
        return array[index];
    }

    public void setElement(int index, int value) {
        array[index] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleArray array1 = (SingleArray) o;
        if(array.length != array1.array.length) return false;
        for(int i = 0; i < array.length; i++) {
            if(array[i] != array1.getElement(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SingleArray{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
