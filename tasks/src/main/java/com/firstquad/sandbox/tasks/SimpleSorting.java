package com.firstquad.sandbox.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleSorting {

    public static void main(String[] args) {
//        int[] in = {5, 6, 3, 2, 9, 7};
//        System.out.println(Arrays.toString(insertionSort(in)));
//
//        in = new int[]{5, 6, 3, 2, 9, 7};
//        System.out.println(Arrays.toString(selectionSort(in)));
//
//        in = new int[]{5, 6, 3, 2, 9, 7};
//        System.out.println(Arrays.toString(bubbleSort(in)));
//
//        System.out.println(fib(9));
//        System.out.println(fibIter(9));

        int[] num = {170, 45, 75, 90, 802, 2, 24, 66, 23, 234, 3, 232, 44};
//
//        radixsort(num);
//
//        for (int h : num)
//            System.out.print(h + " ");

//        System.out.println(fibMemo(6, new int[6]));
//        System.out.println(findSum(num, 5));
//        System.out.println(greatestDivisor(4, 8));
//        System.out.println(Arrays.toString(merge(new int[]{1, 2, 4}, new int[]{2, 6, 8})));
        System.out.println(simpleNumbers(7));
    }

    public static int[] insertionSort(int[] in) {
        for (int i = 1; i < in.length; i++) {
            int value = in[i];
            int hole = i;
            while (hole > 0 && in[hole - 1] > value) {
                in[hole] = in[hole - 1];
                hole--;
            }
            in[hole] = value;
        }
        return in;
    }

    public static int[] selectionSort(int[] in) {
        for (int i = 0; i < in.length; i++) {
            int least = i;
            for (int j = i + 1; j < in.length; j++) {
                if (in[j] < in[least]) {
                    least = j;
                }
            }

            int tmp = in[i];
            in[i] = in[least];
            in[least] = tmp;
        }
        return in;
    }

    public static int[] bubbleSort(int[] in) {
        for (int i = 0; i < in.length - 1; i++) {
            for (int j = 0; j < in.length - i - 1; j++) {
                if (in[j] > in[j + 1]) {
                    int tmp = in[j + 1];
                    in[j + 1] = in[j];
                    in[j] = tmp;
                }
            }
        }
        return in;
    }

    public static void radixsort(int[] input) {
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // sort
        boolean flag = false;
        int tmp = -1, divisor = 1;
        while (!flag) {
            flag = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            System.out.println(Arrays.toString(buckets));

            // empty lists into input array
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : buckets[b]) {
                    input[a++] = i;
                }
                buckets[b].clear();
            }
            // move to next digit
            divisor *= 10;
        }
    }

    public static int fib(int i) {
        if (i <= 2)
            return 1;
        return fib(i - 1) + fib(i - 2);
    }


    public static int fibMemo(int i, int[] memo) {
        if (i <= 2)
            return 1;
        if (memo[i - 1] != 0) {
            return memo[i - 1];
        }
        int f = fibMemo(i - 1, memo) + fibMemo(i - 2, memo);
        memo[i - 1] = f;
        return f;
    }

    public static int fibIter(int i) {
        if (i <= 2)
            return 1;
        int res = 0;
        int a = 1;
        int b = 1;
        for (int j = 2; j < i; j++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public static List<Integer> findSum(int[] m, int sum) {
        Arrays.sort(m);
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            int a = m[i];
            int b = sum - a;
            int bIndex = Arrays.binarySearch(m, b);
            if (bIndex >= 0 && bIndex != i) {
                tmp.add(b);
            }
        }
        return tmp;
    }

    public static int greatestDivisor(int a, int b) {
        int min = a > b ? b : a;
        while (a % min != 0 || b % min != 0) {
            min--;
        }
        return min;
    }

    public static int[] merge(int[] a, int[] b) {
        int aL = 0;
        int bL = 0;
        int bR = b.length - 1;
        int aR = a.length - 1;
        int[] r = new int[a.length + b.length];

        for (int i = 0; i < r.length; i++) {
            if (aL > aR)
                r[i] = b[bL++];
            else if (bL > bR)
                r[i] = a[aL++];
            else if (a[aL] > b[bL])
                r[i] = b[bL++];
            else
                r[i] = a[aL++];
        }
        return r;
    }

    public static List<Integer> simpleNumbers(int n) {
        List<Integer> r = new ArrayList<>();
        while (n > 2) {
            int divisor = n - 1;
            int count = 0;
            while (count < 1 && divisor > 1) {
                if (n % divisor == 0) {
                    count++;
                }
                divisor--;
            }
            if (count == 0)
                r.add(n);
            n--;
        }
        return r;
    }

}