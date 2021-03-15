// Nama : Stevano Titondea Prayoga Putra
// NIM  : A11.2019.11831
package PBO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Mobil2 {

    // Atribut class Mobil2
    int machine = 0,gigi = 0, speed = 0;
    String warna, memilih = "belum"; // --> Mobil yang digunakan
    ArrayList<String> garage;

    Mobil2() {
        garage = new ArrayList<>();
    }

    // Hidupkan mesin
    public void hidupkanMesin(){
        if (machine == 1) {
            System.out.print("mesin mobil " + warna + " ");
            System.out.println(garage.get(garage.indexOf(warna)+1) + " sudah menyala");
            promptEnterKey();
        }else{
            machine+=1;
        }
    }

    // Matikan mesin
    public void matikanMesin(){
        if (gigi != 0){
            System.out.println("masukan ke gigi netral lalu matikan");
            promptEnterKey();
        }else{
            if (machine == 1){
                machine-=1;
            }else if(machine == 0){
                memilih = "belum";
            }
        }
    }

    // Menaikan gigi
    public void ubahGigiNaik() {
        if (gigi < 6) {
            gigi += 1;
        } else {
            System.out.println("Max Gear");
            promptEnterKey();
        }
    }

    // Menurunkan gigi
    public void ubahGigiTurun() {
        if (gigi > -1){
            gigi-=1;
        }else{
            System.out.println("Min Gear");
            promptEnterKey();
        }
    }

    // Menambahkan mobil ke dalam garasi
    public void tambahMobil() {
        System.out.println("========TAMBAH MOBIL=======");
        Scanner userInput = new Scanner(System.in);
        System.out.print("Warna mobil\t--> ");
        String warna = userInput.next();
        garage.add(warna);
        // tambahkan tahun ke garasi
        System.out.print("Tahun produksi\t--> ");
        String tahun = userInput.next();
        garage.add(tahun);
        System.out.println("===========================");
    }

    // index warna mobil yang digunakan
    public int carIndex() {
        return garage.indexOf(warna);
    }

    // movement Speed
    public int speed() {
        Random random = new Random();
        return random.nextInt((2 - 1) + 1) + 1;
    }

    public void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Mobil2 mobilSaya = new Mobil2();
        Scanner userInput = new Scanner(System.in);
        while(true){

            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

            // Harus ada mobil terlebih dahulu sebelum menggunakan
            if (mobilSaya.garage.size() == 0) {
                mobilSaya.tambahMobil();
            }

            // Untuk mengubah gigi 0 ke N dan -1 sebagai R
            String gigiEncoder;
            if (mobilSaya.gigi == 0){
                gigiEncoder = "N";
            }else if(mobilSaya.gigi == -1){
                gigiEncoder = "R";
            }else{
                gigiEncoder = String.valueOf(mobilSaya.gigi);
            }

            // Memilih mobil dari garasi
            int number = 1;
            if (mobilSaya.memilih.equals("belum")) {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                System.out.println("========GARASIMOBIL========");
                for (int i = 0; i < mobilSaya.garage.size(); i+=2){
                    System.out.printf("Mobile ke %d ",number);
                    System.out.println(mobilSaya.garage.get(i));
                    number++;
                }
                System.out.println("========PILIH MOBIL========");
                System.out.println("NOTE : input 1 tambah mobil ");
                System.out.print("Warna \t\t--> ");
                String warna = userInput.next();
                if ("1".equals(warna)) {
                    mobilSaya.tambahMobil();
                } else {
                    if (mobilSaya.garage.contains(warna)) {
                        mobilSaya.warna = warna;
                        mobilSaya.memilih = "sudah";
                    } else {
                        System.out.println("Tidak ada mobil warna " + warna);
                        System.out.println("Ingin tambahkan mobil ");
                        System.out.println("1. Ya");
                        System.out.println("2. Tidak");
                        String yesNo = userInput.next();
                        switch (yesNo) {
                            case "1":
                                mobilSaya.tambahMobil();
                                break;
                            case "2":
                                mobilSaya.promptEnterKey();
                        }
                    }
                }
            }else if(mobilSaya.memilih.equals("sudah")){
                // Main menu
                System.out.println("=========DASHBOARD=========");
                switch (mobilSaya.machine){
                    case 0 :
                        System.out.println("Mesin --> Mati");
                        break;
                    case 1 :
                        System.out.println("Mesin --> Hidup" + "|" + " Gigi --> " + gigiEncoder);
                        System.out.println("___________________________");
                        System.out.println("Mobil --> " + mobilSaya.warna + " Tahun " + mobilSaya.garage.get(mobilSaya.carIndex()+1));
                }
                System.out.println("\n===========================");
                System.out.println("1. Nyalakan Mesin");
                System.out.println("2. Matikan Mesin");
                System.out.println("3. Gear Up");
                System.out.println("4. Gear Down");
                System.out.println("5. Simulator GAS");
                System.out.println("0. Exit");
                System.out.print("Choose --> ");
                String choose = userInput.next();
                switch(choose){
                    case "1" :
                        mobilSaya.hidupkanMesin();
                        break;
                    case "2" :
                        mobilSaya.matikanMesin();
                        break;
                    case "3" :
                        if (mobilSaya.machine == 0){
                            System.out.println("Mobil masih dalam keadaan mati");
                            mobilSaya.promptEnterKey();
                        }else{
                            mobilSaya.ubahGigiNaik();
                        }
                        break;
                    case "4" :
                        if (mobilSaya.machine == 0){
                            System.out.println("Mobil masih dalam keadaan mati");
                            mobilSaya.promptEnterKey();
                        }else{
                            mobilSaya.ubahGigiTurun();
                        }
                        break;
                    case "5" :
                        if (mobilSaya.machine == 0){ // --> Syarat pertama mesin hidup atau bernilai 1
                            System.out.println("Mobil masih dalam keadaan mati");
                            mobilSaya.promptEnterKey();
                        }else{
                            if (mobilSaya.gigi <= 0 | mobilSaya.gigi != 1) { // --> Syarat kedua gigi di 1
                                System.out.println("Harus masuk ke gigi 1");
                                mobilSaya.promptEnterKey();
                            }else{
                                while (mobilSaya.speed < 220) {
                                    System.out.println("=========SIMULATOR=========");
                                    System.out.println("Mesin --> Hidup" + "|" + " Gigi --> " + mobilSaya.gigi);
                                    System.out.println("___________________________");
                                    System.out.println("Mobil --> " + mobilSaya.warna + " Tahun " + mobilSaya.garage.get(mobilSaya.carIndex()+1));
                                    mobilSaya.speed = mobilSaya.speed + mobilSaya.speed();
                                    String random = Integer.toString(mobilSaya.speed);
                                    System.out.print("SPEED ");
                                    Simulator(random, TimeUnit.MILLISECONDS, 100);
                                    if (mobilSaya.speed >= 200) {
                                        mobilSaya.speed*=0; // --> mengembalikan atribut speed ke 0
                                        mobilSaya.gigi*=0; // --> mengembalikan gigi ke 0
                                        System.out.println("\nSelesai, mobil dalam keadaan baik\n");
                                        mobilSaya.promptEnterKey();
                                        break; // --> sampai di speed 200 maka akan berhenti
                                    }else if (mobilSaya.speed > 173) {
                                        mobilSaya.gigi=6;
                                    }else if(mobilSaya.speed > 118) {
                                        mobilSaya.gigi=5;
                                    }else if(mobilSaya.speed > 67) {
                                        mobilSaya.gigi=4;
                                    }else if(mobilSaya.speed > 43) {
                                        mobilSaya.gigi=3;
                                    }else if(mobilSaya.speed > 21) {
                                        mobilSaya.gigi=2;
                                    }
                                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                                }
                            }
                        }
                        break;
                    case "0" :
                        System.exit(0);
                }
            }
        }
    }
    public static void Simulator(String data, TimeUnit unit, long delay) throws InterruptedException {
        Mobil2 simulasiGas = new Mobil2();
        simulasiGas.speed+=2;
        System.out.print("--> " + data + " KM/H");
        unit.sleep(delay);
    }
}














