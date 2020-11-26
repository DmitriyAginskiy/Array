package com.aginskiy.single.service;

import com.aginskiy.single.entity.SingleArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingleArraySortService {

    private static final Logger logger = LogManager.getLogger();

    public void swap(SingleArray array, int firstIndex, int secondIndex) {
        int arrayBuffer = array.getElement(firstIndex);
        array.setElement(firstIndex, array.getElement(secondIndex));
        array.setElement(secondIndex, arrayBuffer);
    }

    public void sortArrayByBubble(SingleArray array) {
        int arrayLength = array.getSize();
        for(int i = 0; i < arrayLength - 1; i++) {
            for(int j = 0; j < arrayLength - 1 - i; j++) {
                if(array.getElement(j) > array.getElement(j + 1)) {
                    swap(array, j, j + 1);
                }
            }
        }
        logger.info("Array was sorted (BubbleSort): " + array.toString());
    }

    public void sortArrayBySelection(SingleArray array) {
        int arrayLength = array.getSize();
        for (int i = 0; i < arrayLength - 1; i++) {
            int minimalIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (array.getElement(j) < array.getElement(minimalIndex)) {
                    minimalIndex = j;
                }
            }
            swap(array, i, minimalIndex);
        }
        logger.info("Array was sorted (SelectionSort): " + array.toString());
    }

    public void sortArrayByInsertion(SingleArray array) {
        int arrayLength = array.getSize();
        for(int i = 1; i < arrayLength; i++) {
            for(int j = i; j > 0 && array.getElement(j - 1) > array.getElement(j); j--) {
                swap(array, j, j - 1);
            }
        }
        logger.info("Array was sorted (InsertionSort): " + array.toString());
    }
}
