package com.latihan;

public class Main {

    public static void main(String[] args) {

        // Penjumlahan
        System.out.println("==========Penjumlahan==========");
        int a = 5;
        int b = 4;
        int c = a + b;
        System.out.println(a + "+" + b + "=" + c);

        // Pengurangan
        System.out.println("==========Pengurangan==========");
        a = 5;
        b = 4;
        c = a - b;
        System.out.println(a + "-" + b + "=" + c);

        // Perkalian
        System.out.println("==========Perkalian==========");
        a = 5;
        b = 4;
        c = a * b;
        System.out.println(a + "x" + b + "=" + c);

        // Pembagian
        System.out.println("==========Pembagian==========");
        c = a / b; // --> hasil berupa integer dan bukan desimal
        System.out.println(a + "/" + b + "=" + c);

        float d = 5;
        float e = 4;
        float f = d / e;
        System.out.printf("%.2f / %.2f = %.2f",d,e,f);

        // modulus
        c = a % b;
        System.out.println("\nModulus " + a + "/" + b + "=" + c);

    }
}
