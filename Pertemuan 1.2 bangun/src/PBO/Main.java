// Nama : Stevano Titondea Prayoga Putra
// NIM  : A11.2019.11831

package PBO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Nama : Stevano Titondea Prayoga Putra
        // NIM  : A11.2019.11831
        int luas1,keliling1,sisi,panjang,lebar,luas2,keliling2; // deklarasi
        float phi,r,a,t;

        // Segitiga
        System.out.println("==============SEGITIGA==============");
        a = 10; // assignment
        t = 5;
        float luasSegitiga = (a * t) / 2;
        System.out.println("Luas segitiga adalah --> (" + a + "x" + t + ") : 2 = " + luasSegitiga + "cm^");
        float kelSegitiga = 2*a + 2*t;
        System.out.println("Keliling segitiga adalah --> 3 x " + a + " = " + kelSegitiga + "cm");

        // Lingkaran
        System.out.println("==============LINGKARAN==============");
        phi = (float) 3.14;
        r = 10;
        float luasLingkaran = phi*r*r;
        System.out.println("Luas lingkaran adalah --> " + phi + "x" + r + "x" + r + " = " + luasLingkaran + "cm^");
        float kelLingkaran = 2*phi*r;
        System.out.printf("Keliling lingkaran adalah --> 2 x " + phi + " x " + "r" + " = " + "%.2f cm %n",kelLingkaran);

        // Kubus
        System.out.println("==============KUBUS==============");
        sisi = 10;
        int luasKubus = 6*sisi*sisi;
        int kelKubus = 12*sisi;
        System.out.println("Luas Kubus adalah --> 6 x " + sisi + "x" + sisi + " = " + luasKubus + "cm^");
        System.out.println("Keliling Kubus adalah --> 12 x " + sisi + " = " + kelKubus + "cm");


        // Nama : Stevano Titondea Prayoga Putra
        // NIM  : A11.2019.11831

        System.out.println("==========Dengan User Input==========");
        // biasanya atribut atau varibel dibuat dengan inputan maka :
        // membuat atribut dengan tipe data Scanner
        Scanner userInput = new Scanner(System.in); // userInput adalah nama variabel

        // Segitiga
        System.out.println("==============SEGITIGA SAMA SISI==============");
        System.out.print("Alas --> ");
        a = userInput.nextInt();
        System.out.print("Tinggi --> ");
        t = userInput.nextInt();
        luasSegitiga = (a * t) / 2;
        kelSegitiga = 3*a;
        System.out.println("luas segitiga adalah --> " + a + " x " + t + " : 2 " + "=" + luasSegitiga);
        System.out.println("keliling segitiga adalah --> 3 x " + a + " = " + kelSegitiga);

        // Lingkaran
        System.out.println("==============LINGKARAN==============");
        System.out.print("Jari-jari --> ");
        r = userInput.nextInt();
        luasLingkaran = phi*r*r;
        kelLingkaran = 2*phi*r;
        System.out.println("Luas lingkaran adalah --> " + phi + "x" + r + "x" + r + " = " + luasLingkaran + "cm^");
        System.out.printf("Keliling lingkaran adalah --> 2 x " + phi + " x " + "r" + " = " + "%.2f cm %n",kelLingkaran);

        // Kubus
        System.out.println("==============KUBUS==============");
        System.out.print("Sisi --> ");
        sisi = userInput.nextInt();
        luasKubus = 6*sisi*sisi;
        kelKubus = 12*sisi;
        System.out.println("Luas Kubus adalah --> 6 x " + sisi + "x" + sisi + " = " + luasKubus + "cm^");
        System.out.println("Keliling Kubus adalah --> 12 x " + sisi + " = " + kelKubus + "cm");
    }
}
