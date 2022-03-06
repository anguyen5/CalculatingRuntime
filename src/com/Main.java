package com;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        long timer1, timer2, timer3;
        long[] N = new long[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000, 521000, (long) 1e6, (long) 2e6, (long) 4e6,
                (long) 8e6, (long) 1.67e7, (long) 3.3e7, (long) 6.5e7, (long) 1.3e8, (long) 2.6e8};

        for(int n = 0;  n < N.length; n++) {
            int[] numList = new int[(int) N[n]];
            Random rand = new Random();

            for (int i = 0; i < numList.length; i++) {
                numList[i] = rand.nextInt(100000) - 100000/2;
            }

            System.out.print("Numbers(N): " + N[n]);
            if(n < 7) {
                timer1 = System.nanoTime();
                range1(numList);
                System.out.print(" Runtime1: " + (System.nanoTime() - timer1) / 1E6);

                timer2 = System.nanoTime();
                range2(numList);
                System.out.print(" Runtime2: " + (System.nanoTime() - timer2) / 1E6);
            }

            timer3 = System.nanoTime();
            range3(numList);
            System.out.println(" Runtime3: " + (System.nanoTime() - timer3)/1E6);
        }

    }

    // returns the range of values in the given array;
    // the difference between elements furthest apart
    // example: range({17, 29, 11, 4, 20, 8}) is 25
    public static int range1(int[] numbers) {
        int diff = 0, maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    // returns the range of values in the given array;
    // the difference between elements furthest apart
    // example: range({17, 29, 11, 4, 20, 8}) is 25
    public static int range2(int[] numbers) {
        int diff = 0, maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
               diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    // returns the range of values in the given array;
    // example: range({17, 29, 11, 4, 20, 8}) is 25
    public static int range3(int[] numbers) {
        int max = numbers[0];     // find max/min values
        int min = max;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max - min;
    }


}
