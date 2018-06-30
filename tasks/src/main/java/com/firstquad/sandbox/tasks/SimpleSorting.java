package com.firstquad.sandbox.tasks;

import java.util.Arrays;

public class SimpleSorting {

    public static void main(String[] args) {
        int[] in = {5, 6, 3, 2, 9, 7};
        System.out.println(Arrays.toString(insertionSort(in)));

        in = new int[]{5, 6, 3, 2, 9, 7};
        System.out.println(Arrays.toString(selectionSort(in)));

        in = new int[]{5, 6, 3, 2, 9, 7};
        System.out.println(Arrays.toString(bubbleSort(in)));

        System.out.println(fib(9));
        System.out.println(fibIter(9));
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
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length; j++) {
                if (in[j] > in[i]) {
                    int tmp = in[i];
                    in[i] = in[j];
                    in[j] = tmp;
                }
            }
        }
        return in;
    }

    public static int fib(int i) {
        if (i <= 2)
            return 1;
        return fib(i - 1) + fib(i - 2);
    }

    public static int fibIter(int i) {
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

}