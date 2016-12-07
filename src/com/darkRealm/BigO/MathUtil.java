package com.darkRealm.BigO;

/**
 * Created by Jayam on 8/24/2016.
 */
public class MathUtil {

    public static boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nThFibonaciNumber(int n) {
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        return nThFibonaciNumber(n - 1) + nThFibonaciNumber(n - 2);
    }

    public static long greatestCommonDivisorIT(long big, long small) {
        long temp = 1;
        while (small > 0) {
            temp = small;
            small = big % small;
            big = temp;
        }
        return big;
    }

    public static long greatestCommonDivisorRC(long big, long small) {
        if (small == 0) {
            return big;
        } else {
            return greatestCommonDivisorRC(small, big % small);
        }
    }

    public static int nthFibonacciNumberOptimized(int n) {
        return -1;
    }

    public static int nthPrimeNumber(int n) {
        int[] memoizedArr = new int[n];
        int primeCount = 0;
        for (int i = 2; primeCount < n; i++) {
            if (!isPrimeDivisible(i, primeCount, memoizedArr)) {
                memoizedArr[primeCount++] = n;
            }
        }
        return memoizedArr[primeCount - 1];
    }

    private static boolean isPrimeDivisible(int n, int primeCount, int[] primeArr) {
        int currentPrime = 0;
        for (int i = 0; i < primeCount; i++) {
            currentPrime = primeArr[i];
            if (currentPrime * currentPrime > n) {
                return false;
            }
            if (n % currentPrime == 0) {
                return true;
            }
        }
        return false;
    }
}