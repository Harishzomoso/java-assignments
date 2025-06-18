package org.project;

import java.util.*;

public class VampireNumbers {
    public static void main(String[] args) {
        int count = 0;
        long num = 333;
        while (count < 100) {
            if (isVampire(num)) {
                System.out.println(num);
                count++;
            }
            num++;
        }
    }

    static boolean isVampire(long num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();

        if (len % 2 != 0) return false;

        int half = len / 2;
        long lower = (long)Math.pow(10, half - 1);
        long upper = (long)Math.pow(10, half);

        for (long i = lower; i < upper; i++) {
            if (num % i == 0) {
                long j = num / i;

                if (j >= lower && j < upper) {
                    if (i % 10 == 0 && j % 10 == 0) continue;

                    char[] numChars = numStr.toCharArray();
                    String combined = String.valueOf(i) + String.valueOf(j);
                    char[] combinedChars = combined.toCharArray();
                    Arrays.sort(numChars);
                    Arrays.sort(combinedChars);
                    if (Arrays.equals(numChars, combinedChars)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
