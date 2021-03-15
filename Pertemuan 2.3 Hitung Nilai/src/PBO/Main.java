// Nama : Stevano Titondea Prayoga Putra
// NIM  : A11.2019.11831
package PBO;

import java.io.IOException;
import java.util.Scanner;

class daftarNilai {
    String nim, nama;
    float nilaiUts, nilaiUas, nilaiTugas, pNilaiUts = 0.35f, pNilaiTugas = 0.2f, pNilaiUas = 0.45f, nilaiAkhir;
    int step = 3; // --> 3 kali tahap output dengan line yang sama dengan user input
    public void hitungNilai(){
        nilaiAkhir = nilaiUts*pNilaiUts + nilaiTugas*pNilaiTugas + nilaiUas*pNilaiUas;
    }
    public float cetakNilai(){
        return (nilaiAkhir);
    }
    public void outPut() throws IOException, InterruptedException { // --> untuk mencetak persis seperti di soal
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        System.out.println("Nim\t\t: " + nim);
        System.out.println("Nama\t\t: " + nama);
        if (step == 3) {
            System.out.println("Nilai Tugas\t: " + nilaiTugas + "\t20% :" + nilaiTugas*pNilaiTugas);
            step--;
        }else if(step == 2) {
            System.out.println("Nilai Tugas\t: " + nilaiTugas + "\t20% : " + nilaiTugas*pNilaiTugas);
            System.out.println("Nilai UTS\t: " + nilaiUts + "\t35% : " + nilaiUts*pNilaiUts);
            step--;
        }else if(step == 1) {
            System.out.println("Nilai Tugas\t: " + nilaiTugas + "\t20% : " + nilaiTugas*pNilaiTugas);
            System.out.println("Nilai UTS\t: " + nilaiUts + "\t35% : " + nilaiUts*pNilaiUts);
            System.out.println("Nilai UAS\t: " + nilaiUas + "\t45% : " + nilaiUas*pNilaiUas);
            step--;
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        daftarNilai inputNilai = new daftarNilai();
        Scanner userInput = new Scanner(System.in);

        // --> clear console untuk menciptakan output yang tidak blink
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

        System.out.print("Nim\t\t: ");
        inputNilai.nim = userInput.next();
        System.out.print("Nama\t\t: ");
        String nama = userInput.next();
        nama+=userInput.nextLine(); // --> menerima input string dengan spasi
        inputNilai.nama = nama;

        // Nilai tugas
        System.out.print("Nilai Tugas\t: ");
        inputNilai.nilaiTugas = userInput.nextFloat();
        inputNilai.outPut();

        // Nilai UTS
        System.out.print("Nilai UTS\t: ");
        inputNilai.nilaiUts = userInput.nextFloat();
        inputNilai.outPut();

        // Nilai UAS
        System.out.print("Nilai UAS\t: ");
        inputNilai.nilaiUas = userInput.nextFloat();
        inputNilai.outPut();

        // Nilai Akhir
        inputNilai.hitungNilai(); // --> melakukan penghitungan (mengubah nilai atribut)
        System.out.print("Nilai Akhir\t: " + inputNilai.cetakNilai()); // --> memanggil nilai
    }
}














