package com.aginskiy.single.service;

import com.aginskiy.single.creator.SingleArrayCreator;
import com.aginskiy.single.entity.SingleArray;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class SingleArraySearchServiceTest {
    private static SingleArray singleArray;
    private static SingleArray sortedSingleArray;
    private static SingleArraySearchService singleArraySearchService;
    private static SingleArrayCreator singleArrayCreator;
    private static Random random;
    private static int[] array;

    @BeforeClass
    public void setUp() {
        singleArray = new SingleArray(15);
        singleArraySearchService = new SingleArraySearchService();
        singleArrayCreator = new SingleArrayCreator();
        singleArrayCreator.fillArrayFromRandom(singleArray, 10, 100);
        sortedSingleArray = new SingleArray(15);
        random = new Random();
        array = new int[singleArray.getSize()];
        for(int i = 0; i < array.length; i++) {
            array[i] = singleArray.getElement(i);
        }
        sortedSingleArray.setArray(array);
    }

    @Test
    public void testBinarySearch() {
        int key = array[random.nextInt(array.length)];
        Arrays.sort(array);
        int actual = singleArraySearchService.binarySearch(sortedSingleArray, key, 0, sortedSingleArray.getSize());
        int expected = Arrays.binarySearch(array, key);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSearchMinimalElement() {
        int expected = -1;
        singleArray.setElement(random.nextInt(singleArray.getSize()), expected);
        int actual = singleArraySearchService.searchMinimalElement(singleArray);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSearchMaximumElement() {
        int expected = 1000;
        singleArray.setElement(random.nextInt(singleArray.getSize()), expected);
        int actual = singleArraySearchService.searchMaximumElement(singleArray);
        Assert.assertEquals(actual, expected);
    }
}