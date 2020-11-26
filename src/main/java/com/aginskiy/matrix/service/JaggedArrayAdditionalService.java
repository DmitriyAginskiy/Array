package com.aginskiy.matrix.service;

import com.aginskiy.matrix.entity.JaggedArray;

public class JaggedArrayAdditionalService {

    public int countSumOfRowElements(JaggedArray array, int row) {
        int columns = array.getCols();
        int sum = 0;
        for(int i = 0; i < columns; i++) {
            sum += array.getElement(row, i);
        }
        return sum;
    }

    public int searchMaximalElement(JaggedArray array, int row) {
        int columns = array.getCols();
        int maximalElement = array.getElement(row, 0);
        for(int i = 0; i < columns; i++) {
            if(array.getElement(row, i) > maximalElement) {
                maximalElement = array.getElement(row, i);
            }
        }
        return maximalElement;
    }

    public int searchMinimalElement(JaggedArray array, int row) {
        int columns = array.getCols();
        int minimalElement = array.getElement(row, 0);
        for(int i = 0; i < columns; i++) {
            if(array.getElement(row, i) < minimalElement) {
                minimalElement = array.getElement(row, i);
            }
        }
        return minimalElement;
    }

    public void swapElements(JaggedArray array, int row1, int col1, int row2, int col2) {
        int arrayBuffer = array.getElement(row1, col1);
        array.setElement(row1, col1, array.getElement(row2, col2));
        array.setElement(row2, col2, arrayBuffer);
    }

    public void swapRows(JaggedArray array, int row1, int row2) {
        int columns = array.getCols();
        for(int i = 0; i < columns; i++) {
            swapElements(array, row1, i, row2, i);
        }
    }
}
