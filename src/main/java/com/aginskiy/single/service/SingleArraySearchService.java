package com.aginskiy.single.service;

import com.aginskiy.single.entity.SingleArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingleArraySearchService {

    private static final Logger logger = LogManager.getLogger();

    public int binarySearch(SingleArray array, int key, int left, int right) {
        int middle = left + (right - left) / 2;

        if (array.getElement(middle) == key) {
            logger.info("The item was searched for: " + key + " == " + middle);
            return middle;
        } else if (array.getElement(middle) > key) {
            return binarySearch(array, key, left, middle);
        } else {
            return binarySearch(array, key, middle + 1, right);
        }
    }

    public int searchMinimalElement(SingleArray array) {
        int arrayLength = array.getSize();
        int minimalElement = array.getElement(0);
        for (int i = 0; i < arrayLength; i++) {
            if (array.getElement(i) < minimalElement) {
                minimalElement = array.getElement(i);
            }
        }
        logger.info("The minimum element was searched for: " + minimalElement);
        return minimalElement;
    }

    public int searchMaximumElement(SingleArray array) {
        int arrayLength = array.getSize();
        int maximalElement = array.getElement(0);
        for (int i = 0; i < arrayLength; i++) {
            if (array.getElement(i) > maximalElement) {
                maximalElement = array.getElement(i);
            }
        }
        logger.info("The maximum element was searched for: " + maximalElement);
        return maximalElement;
    }
}
