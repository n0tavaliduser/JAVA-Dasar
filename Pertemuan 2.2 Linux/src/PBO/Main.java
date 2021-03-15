package PBO;

import java.util.ArrayList;
import java.util.Scanner;

class Mobil2 {

    // Atribut class Mobil2
    int machine = 0,gigi = 0, tahunProduksi;
    String warna, memilih = "belum"; // --> Mobil yang digunakan
    ArrayList<String> garage = new ArrayList<String>();

    // Hidupkan mesin
    public void hidupkanMesin(){
        if (machine == 1) {
            System.out.println("mesin mobil " + warna + " " + garage.get(garage.indexOf(warna)+1) + " sudah menyala");
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
            machine-=1;
            memilih = "belum";
        }
    }

    public void ubahGigiNaik() {
        if (gigi < 6) {
            gigi += 1;
        } else {
            System.out.println("Max Gear");
            promptEnterKey();
        }
    }

    public void ubahGigiTurun() {
        if (gigi > -1){
            gigi-=1;
        }else{
            System.out.println("Min Gear");
            promptEnterKey();
        }
    }

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

    public int carIndex() {
        return garage.indexOf(warna);
    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
public class Main {

    public static void main(String[] args) {
        Mobil2 mobilSaya = new Mobil2();
        Scanner userInput = new Scanner(System.in);
        while(true){

            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (mobilSaya.garage.size()) {
                case 0 :
                    mobilSaya.tambahMobil();
                    break;
            }
            // Untuk mengubah gigi 0 ke N dan -1 sebagai R
            String gigiEncoder = "";
            if (mobilSaya.gigi == 0){
                gigiEncoder = "N";
            }else if(mobilSaya.gigi == -1){
                gigiEncoder = "R";
            }else{
                gigiEncoder = String.valueOf(mobilSaya.gigi);
            }

            // Memilih mobil dari garasi
            if (mobilSaya.memilih == "belum") {
                System.out.println("========PILIH MOBIL========");
                System.out.print("Warna \t\t--> ");
                String warna = userInput.next();
                if (mobilSaya.garage.contains(warna)) {
                    mobilSaya.warna = warna;
                    mobilSaya.memilih = "sudah";
                }else{
                    System.out.println("Tidak ada mobil warna " + warna);
                }
            }else if(mobilSaya.memilih == "sudah"){
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
                System.out.println("===========================");
                System.out.println("1. Nyalakan Mesin");
                System.out.println("2. Matikan Mesin");
                System.out.println("3. Gear Up");
                System.out.println("4. Gear Down");
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
                    case "0" :
                        System.exit(0);
                }
            }
        }
    }
}
