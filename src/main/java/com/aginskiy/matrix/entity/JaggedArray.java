package com.aginskiy.matrix.entity;

import com.aginskiy.single.entity.SingleArray;

import java.util.Arrays;

public class JaggedArray {
    private int[][] array;

    public JaggedArray() {

    }

    public JaggedArray(int[][] array) {
        this.array = array;
    }

    public JaggedArray(int rows, int cols) {
        array = new int[rows][cols];
    }

    public int getElement(int row, int col) {
        return array[row][col];
    }

    public void setElement(int row, int col, int value) {
        array[row][col] = value;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    public int getRows() {
        return array.length;
    }

    public int getCols() {
        return array[0].length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaggedArray array1 = (JaggedArray) o;
        if(array.length != array1.getRows() || array[0].length != array1.getCols()) return false;
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                if(array[i][j] != array1.getElement(i, j)) {
                    return false;
                }
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
        final StringBuilder sb = new StringBuilder("JaggedArray{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
