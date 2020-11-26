package com.aginskiy.matrix.service;

import com.aginskiy.matrix.entity.JaggedArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JaggedArraySortService {

    private static final Logger logger = LogManager.getLogger();

    public void sortBySumIncrease(JaggedArray array, JaggedArrayAdditionalService additionalService) {
        int rows = array.getRows();
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                if (additionalService.countSumOfRowElements(array, j) < additionalService.countSumOfRowElements(array, j + 1)) {
                    additionalService.swapRows(array, j, j + 1);
                }
            }
        }
        logger.info("Jagged Array was sorted by Increase of the sum of elements");
    }

    public void sortBySumDecrease(JaggedArray array, JaggedArrayAdditionalService additionalService) {
        int rows = array.getRows();
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                if (additionalService.countSumOfRowElements(array, j) > additionalService.countSumOfRowElements(array, j + 1)) {
                    additionalService.swapRows(array, j, j + 1);
                }
            }
        }
        logger.info("Jagged Array was sorted by Decrease of the sum of elements");
    }

    public void sortByIncreaseMaximalElement(JaggedArray array, JaggedArrayAdditionalService additionalService) {
        int rows = array.getRows();
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                if (additionalService.searchMaximalElement(array, j) < additionalService.searchMaximalElement(array, j + 1)) {
                    additionalService.swapRows(array, j, j + 1);
                }
            }
        }
        logger.info("Jagged Array was sorted by Increase of the maximum element");
    }
    public void sortByDecreaseMaximalElement(JaggedArray array, JaggedArrayAdditionalService additionalService) {
        int rows = array.getRows();
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                if (additionalService.searchMaximalElement(array, j) > additionalService.searchMaximalElement(array, j + 1)) {
                    additionalService.swapRows(array, j, j + 1);
                }
            }
        }
        logger.info("Jagged Array was sorted by Decrease of the maximum element");
    }

    public void sortByIncreaseMinimalElement(JaggedArray array, JaggedArrayAdditionalService additionalService) {
        int rows = array.getRows();
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                if (additionalService.searchMinimalElement(array, j) > additionalService.searchMinimalElement(array, j + 1)) {
                    additionalService.swapRows(array, j, j + 1);
                }
            }
        }
        logger.info("Jagged Array was sorted by Increase of the minimum element");
    }

    public void sortByDecreaseMinimalElement(JaggedArray array, JaggedArrayAdditionalService additionalService) {
        int rows = array.getRows();
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                if (additionalService.searchMinimalElement(array, j) < additionalService.searchMinimalElement(array, j + 1)) {
                    additionalService.swapRows(array, j, j + 1);
                }
            }
        }
        logger.info("Jagged Array was sorted by Decrease of the minimum element");
    }
}
