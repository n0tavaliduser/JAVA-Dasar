// Nama     : Stevano Titondea Prayoga Putra
// NIM      : A11.2019.11831

package PBO;

public class Main {

    public static void main(String[] args) {

        // println (print newline)
        System.out.println("NIM\t\t\t: -");
        System.out.println("Nama\t\t: N0tavaliduser");
        System.out.println("Alamat\t\t: -");
        System.out.println("Kota\t\t: -"); // --> format variabel dengan %S String uppercase
        System.out.println("Kode Pos\t: -");
        System.out.println("Telp\t\t: - ");
        System.out.println("Hp\t\t\t: -");
        System.out.println("Email\t\t: -");

        // print (print sebaris)
        System.out.print("NIM\t\t\t: -\n");
        System.out.print("Nama\t\t: N0tavaliduser\n");
        System.out.print("Alamat\t\t: -\n");
        System.out.print("Kota\t\t: -\n"); // --> format variabel dengan %S String uppercase
        System.out.print("Kode Pos\t: -\n");
        System.out.print("Telp\t\t: - \n");
        System.out.print("Hp\t\t\t: -\n");
        System.out.print("Email\t\t: -\n");


        // 1 contoh atribut
        String kota = "Nama Kota"; // --> nilai String dengan semarang (lowercase)
        int kodePos = 11312; // --> Masih dalam range tipe data integer

        // Tugas menampilkan data pribadi
        System.out.printf("NIM\t\t\t: %s \n","-");
        System.out.printf("Nama\t\t: NAVU%n");
        System.out.printf("Alamat\t\t: -%n");
        System.out.printf("Kota\t\t: %S",kota); // --> format variabel dengan %S String uppercase
        System.out.printf("\nKode Pos\t: %d\n",kodePos);
        System.out.printf("Telp\t\t: - %n");
        System.out.printf("Hp\t\t\t: -%n");
        System.out.printf("Email\t\t: -%n");
    }
}
