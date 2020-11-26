package com.aginskiy.single.service;

import com.aginskiy.single.entity.SingleArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingleArrayNumberService {

    private static final Logger logger = LogManager.getLogger();

    private boolean isSimpleNumber(int number) {
        boolean isSimple = true;
        int i = 2;
        while(i <= number / 2 + 1 && isSimple) {
            if(number % i == 0) {
                isSimple = false;
            }
            ++i;
        }
        return isSimple;
    }

    private int countAllSimpleNumbers(SingleArray array) {
        int simpleNumbers = 0;
        int arrayLength = array.getSize();
        for(int i = 0; i < arrayLength; i++) {
            if(isSimpleNumber(array.getElement(i))) {
                ++simpleNumbers;
            }
        }
        return simpleNumbers;
    }

    public int[] searchAllSimpleNumbers(SingleArray array) {
        int simpleNumbers = countAllSimpleNumbers(array);
        int arrayLength = array.getSize();
        int[] simpleArray = new int[simpleNumbers];
        int counter = 0;
        for(int i = 0; i < arrayLength; i++) {
            if(isSimpleNumber(array.getElement(i))) {
                simpleArray[counter] = array.getElement(i);
                ++counter;
            }
        }
        logger.info("Returned an array of Prime numbers: " + simpleArray.toString());
        return simpleArray;
    }

    private boolean isFibonacciNumber(int number) {
        int fibonacci1 = 0;
        int fibonacci2 = 1;
        int fibonacci3 = 1;
        while(fibonacci1 < number) {
            fibonacci1 = fibonacci3 + fibonacci2;
            fibonacci3 = fibonacci2;
            fibonacci2 = fibonacci1;
        }
        return fibonacci1 == number;
    }

    private int countAllFibonacciNumbers(SingleArray array) {
        int fibonacciNumbers = 0;
        int arrayLength = array.getSize();
        for(int i = 0; i < arrayLength; i++) {
            if(isFibonacciNumber(array.getElement(i))) {
                ++fibonacciNumbers;
            }
        }
        return fibonacciNumbers;
    }

    public int[] searchAllFibonacciNumbers(SingleArray array) {
        int fibonacciNumbers = countAllFibonacciNumbers(array);
        int arrayLength = array.getSize();
        int[] fibonacciArray = new int[fibonacciNumbers];
        int counter = 0;
        for(int i = 0; i < arrayLength; i++) {
            if(isFibonacciNumber(array.getElement(i))) {
                fibonacciArray[counter] = array.getElement(i);
                ++counter;
            }
        }
        logger.info("Returned an array of Fibonacci numbers: " + fibonacciArray.toString());
        return fibonacciArray;
    }

    private boolean isDifferentDigits(int number) {
        if(("" + number).length() < 3) {
            return false;
        }
        int left = number % 10;
        int middle = (number / 10) % 10;
        int right = (number / 100) % 10;
        return left != middle & left != right && middle != right;
    }

    private int countDifferentDigitsNumbers(SingleArray array) {
        int differentNumbers = 0;
        int arrayLength = array.getSize();
        for(int i = 0; i < arrayLength; i++) {
            if(isDifferentDigits(array.getElement(i))) {
                ++differentNumbers;
            }
        }
        return differentNumbers;
    }

    public int[] searchNumbersWithDifferentDigits(SingleArray singleArray) {
        int differentNumbers = countDifferentDigitsNumbers(singleArray);
        int arrayLength = singleArray.getSize();
        int[] differentDigitsArray = new int[differentNumbers];
        int counter = 0;
        for(int i = 0; i < arrayLength; i++) {
            if(isDifferentDigits(singleArray.getElement(i))) {
                differentDigitsArray[counter] = singleArray.getElement(i);
                ++counter;
            }
        }
        logger.info("Returned an array of numbers with different digits: " + differentDigitsArray.toString());
        return differentDigitsArray;
    }
}
