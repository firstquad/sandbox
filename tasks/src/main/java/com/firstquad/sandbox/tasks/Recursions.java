package com.firstquad.sandbox.tasks;

public class Recursions {

    public static void main(String[] args) {
//        System.out.println(sumN(28347, 0));
//        System.out.println(poli("124321"));
        System.out.println(fact(5, 1));
    }

    public static int sumN(int n, int sum) {
        int digit = n % 10;
        if (n < 10)
            return sum + n;
        int r = Math.floorDiv(n, 10);
        return sumN(r, sum + digit);
    }

    public static boolean poli(String in) {
        if (in.length() < 2)
            return true;
        String s = in.substring(0, 1);
        String e = in.substring(in.length() - 1, in.length());
        if (!s.equalsIgnoreCase(e))
            return false;
        return poli(in.substring(1, in.length() - 1));
    }

    public static int fact(int n, int r) {
        if (n == 0)
            return r;
        return fact(n - 1, r * n);
    }
}
