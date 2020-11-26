package com.aginskiy.matrix.main;

import com.aginskiy.matrix.creator.JaggedArrayCreator;
import com.aginskiy.matrix.entity.JaggedArray;
import com.aginskiy.matrix.service.JaggedArrayAdditionalService;
import com.aginskiy.matrix.service.JaggedArraySortService;

public class JaggedArrayMain {
    public static void main(String[] args) {
        JaggedArray jaggedArray = new JaggedArray(15, 15);
        JaggedArrayCreator jaggedArrayCreator = new JaggedArrayCreator();
        jaggedArrayCreator.fillRandomJaggedArray(jaggedArray, 100);
        JaggedArraySortService sortService = new JaggedArraySortService();
        JaggedArrayAdditionalService additionalService = new JaggedArrayAdditionalService();
        sortService.sortByIncreaseMaximalElement(jaggedArray, additionalService);
    }
}
