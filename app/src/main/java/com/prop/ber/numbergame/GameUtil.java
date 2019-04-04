package com.prop.ber.numbergame;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GameUtil {

    public static Integer[] getArray() {
        Integer[] arr = new Integer[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        Collections.shuffle(Arrays.asList(arr));
        return arr;
    }

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
