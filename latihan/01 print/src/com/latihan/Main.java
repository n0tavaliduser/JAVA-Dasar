package com.latihan;

public class Main {

    public static void main(String[] args) {
	    // print terdapat 3 jenis yaitu println, print, printf

        // print (mencetak sebaris)
        System.out.println("=========== print");
        System.out.print("Hello");
        System.out.print(" World!"); // print tanpa mengganti line baru

        // println
        System.out.println("=========== println");
        System.out.println("Hello");
        System.out.println("World!"); // print dengan diakhiri newline diakhir

        // printf
        System.out.println("=========== printf");
        System.out.printf("%s","Hello "); // mencetak dengan format string lowercase
        System.out.printf("%S","World! \n"); // mencetak dengan format string uppercase

        int angka = 1;
        System.out.printf("%d",angka); // mencetak dengan format desimal

    }
}
