package com.aginskiy.single.creator;

import com.aginskiy.single.entity.SingleArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class SingleArrayCreator {

    private static final Logger logger = LogManager.getLogger();

    public void fillArrayFromConsole(SingleArray array) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = array.getSize();
        for(int i = 0; i < arrayLength; i++) {
            System.out.println("Element A[" + i + "]: ");
            array.setElement(i, scanner.nextInt());
        }
        scanner.close();
        logger.info("(Console) Generated Array: " + array.toString());
    }

    public void fillArrayFromRandom(SingleArray array, int start, int end) {
        Random random = new Random();
        int arrayLength = array.getSize();
        for(int i = 0; i < arrayLength; i++) {
            int element = start + random.nextInt(end - start);
            array.setElement(i, element);
        }
        logger.info("(Random) Generated Array: " + array.toString());
    }

    public void fillArrayFromFile(SingleArray array, File file) throws InvalidNumberOfValuesException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            int size = array.getSize();
            int fileNumbersCount = 0;
            for(int i = 0; i < size + 1 && scanner.hasNextInt(); i++) {
                ++fileNumbersCount;
            }
            if(fileNumbersCount != size) {
                throw new InvalidNumberOfValuesException("Invalid number of values inside the file");
            }
            for(int i = 0; i < size && scanner.hasNextInt(); i++) {
                array.setElement(i, scanner.nextInt());
            }
        } catch(FileNotFoundException e) {
            logger.error("Throw an exception: " + e);
        } finally {
            scanner.close();
        }
        logger.info("(File) Generated Array: " + array.toString());
    }
}
