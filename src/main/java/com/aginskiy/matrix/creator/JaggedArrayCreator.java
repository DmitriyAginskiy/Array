package com.aginskiy.matrix.creator;

import com.aginskiy.matrix.entity.JaggedArray;

import java.util.Random;

public class JaggedArrayCreator {
    public void fillRandomJaggedArray(JaggedArray array, int bound) {
        Random random = new Random();
        int rows = array.getRows();
        int columns = array.getCols();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                array.setElement(i, j, random.nextInt(bound));
            }
        }
    }
}
