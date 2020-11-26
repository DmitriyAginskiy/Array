package com.aginskiy.single.main;

import com.aginskiy.single.creator.SingleArrayCreator;
import com.aginskiy.single.entity.SingleArray;
import com.aginskiy.single.service.SingleArraySortService;

public class SingleArrayMain {
    public static void main(String[] args) {
        SingleArray array = new SingleArray(15);
        SingleArrayCreator arrayCreator = new SingleArrayCreator();
        arrayCreator.fillArrayFromRandom(array, 1, 100);
        SingleArraySortService arraySortService = new SingleArraySortService();
        arraySortService.sortArrayByBubble(array);
        System.out.println(array.toString());
    }
}
