package com.aginskiy.single.service;

import com.aginskiy.single.creator.SingleArrayCreator;
import com.aginskiy.single.entity.SingleArray;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class SingleArraySortServiceTest {
    private static SingleArray singleArray;
    private static SingleArrayCreator singleArrayCreator;
    private static SingleArraySortService singleArraySortService;
    private static Random random;
    private static int[] array;

    @BeforeClass
    public void setUp() {
        singleArray = new SingleArray(15);
        singleArrayCreator = new SingleArrayCreator();
        singleArraySortService = new SingleArraySortService();
        random = new Random();
    }

    @BeforeMethod
    public void setUpMethod() {
        singleArrayCreator.fillArrayFromRandom(singleArray, 10, 100);
        array = new int[singleArray.getSize()];
        for(int i = 0; i < array.length; i++) {
            array[i] = singleArray.getElement(i);
        }
        Arrays.sort(array);
    }

    @Test
    public void testSwap() {
        int firstSwappedIndex = random.nextInt(singleArray.getSize());
        int secondSwappedIndex = random.nextInt(singleArray.getSize());
        int firstElementBuffer = singleArray.getElement(firstSwappedIndex);
        int secondElementBuffer = singleArray.getElement(secondSwappedIndex);
        int swapBuffer = singleArray.getElement(firstSwappedIndex);
        singleArray.setElement(firstSwappedIndex, singleArray.getElement(secondSwappedIndex));
        singleArray.setElement(secondSwappedIndex, swapBuffer);
        boolean isSwapped = (singleArray.getElement(firstSwappedIndex) == secondElementBuffer)
                            && (singleArray.getElement(secondSwappedIndex) == firstElementBuffer);
        Assert.assertTrue(isSwapped);
    }
    @Test
    public void testSortArrayByBubble() {
        singleArraySortService.sortArrayByBubble(singleArray);
        SingleArray expected = new SingleArray(array);
        SingleArray actual = singleArray;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortArrayBySelection() {
        singleArraySortService.sortArrayBySelection(singleArray);
        SingleArray expected = new SingleArray(array);
        SingleArray actual = singleArray;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortArrayByInsertion() {
        singleArraySortService.sortArrayByInsertion(singleArray);
        SingleArray expected = new SingleArray(array);
        SingleArray actual = singleArray;
        Assert.assertEquals(actual, expected);
    }
}