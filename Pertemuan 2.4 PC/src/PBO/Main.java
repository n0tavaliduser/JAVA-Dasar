package PBO;

import com.sun.nio.sctp.SendFailedNotification;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Scanner;

class PC {
    int machine = 0, ModeCPU = 0, RAM = 8192, FPS=70;

    // tombol power PC
    public void PowerOnOff() {
        int systemRAMusage = 1024;
        if (machine == 0) {
            RAM-=systemRAMusage;
            machine++;
        }else{
            RAM+=systemRAMusage;
            machine--;
        }
    }

    // overclock PC
    public void OverClock(int encoder) {
        if (encoder == 1) {
            ModeCPU = 1;
            FPS=70;
            FPS+=10;
            System.out.println("Performa dinaikan");
        }else if(encoder == 2) {
            ModeCPU = 2;
            FPS=70;
            FPS+=20;
            System.out.println("Performa Gaming");
        }else if(encoder == 3) {
            ModeCPU = 3;
            FPS=70;
            FPS+=50;
            System.out.println("Performa Maksimal");
        }
    }

    // RAM
    public int RAM() { // --> nilai fungsi RAM
        return (RAM);
    }

    // enter to continue
    public void promptEnterKey() {
        System.out.println("press ENTER to continue");
        Scanner userInput = new Scanner(System.in);
        userInput.nextLine();
    }
}
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner userInput = new Scanner(System.in);
        PC komputerSaya = new PC();

        Boolean Running = true;
        while (Running) {

            // Clear Terminal
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            // Output
            System.out.println("\n====================PC SAYA====================");
            System.out.print("Status PC -> ");
            if (komputerSaya.machine == 0) {
                System.out.print("MATI\n");
            }else{
                System.out.println("HIDUP");
            }
            System.out.println("\n===============================================");
            System.out.println("1. Power ON/OFF PC");
            System.out.println("2. Ngoding");
            System.out.println("3. Game");
            System.out.println("4. Nonton Video");
            System.out.println("0. Exit");
            System.out.print("--> ");
            String choose = userInput.next();
            switch (choose) {

                case "1" :
                    komputerSaya.PowerOnOff();
                    break;
                case "2" :
                    if (komputerSaya.machine == 1) {
                        System.out.println("====================NGODING====================");
                        System.out.println("1. Java");
                        System.out.println("2. Python");
                        System.out.println("--> ");
                        String choose2 = userInput.next();
                        switch (choose2) {
                            case "1" :
                                System.out.println("System.out.println('....');");
                                String print = userInput.next();
                                print+=userInput.nextLine();
                                System.out.println("Output --> " + print);
                                komputerSaya.promptEnterKey();
                                break;
                            case "2" :
                                System.out.println("print(...)");
                                print = userInput.next();
                                print+=userInput.nextLine();
                                System.out.println("Output --> " + print);
                                komputerSaya.promptEnterKey();
                                break;
                        }
                    }else if(komputerSaya.machine == 0) {
                        System.out.println("Nyalakan PC terlebih dahulu");
                        komputerSaya.promptEnterKey();
                    }
                    break;
                case "3" :
                    if (komputerSaya.machine == 1) {
                        int ramUsage = 4048, sisaRam = komputerSaya.RAM()-ramUsage;
                        System.out.println("====================GAMEMODE===================");
                        System.out.println("Status RAM Tersisa -> " + sisaRam + "MB");
                        System.out.println("FPS --> " + komputerSaya.FPS);
                        if (komputerSaya.FPS == 70) {
                            System.out.println("input Y : to overclock?");
                        }else if(komputerSaya.FPS > 70){
                            System.out.println("input Y : ubah pengaturan overclock?");
                        }
                        System.out.print("--> ");
                        String YesOrNo = userInput.next();
                        switch (YesOrNo) {
                            case "Y" :
                                System.out.println("1. overclock biasa");
                                System.out.println("2. overclock untuk game");
                                System.out.println("3. overclock maksimal");
                                System.out.println("--> ");
                                String choose3 = userInput.next();
                                switch (choose3) {
                                    case "1" :
                                        komputerSaya.OverClock(1);
                                        System.out.println("restart game anda");
                                        komputerSaya.promptEnterKey();
                                        break;
                                    case "2" :
                                        komputerSaya.OverClock(2);
                                        System.out.println("restart game anda");
                                        komputerSaya.promptEnterKey();
                                        break;
                                    case "3" :
                                        komputerSaya.OverClock(3);
                                        System.out.println("restart game anda");
                                        komputerSaya.promptEnterKey();
                                        break;
                                }
                        }
                        break;
                    }else{
                        System.out.println("Nyalakan PC terlebih dulu");
                        komputerSaya.promptEnterKey();
                        break;
                    }
                case "4" :
                    if (komputerSaya.machine == 1) {
                        System.out.println("====================VIDEO P====================");
                        int ramUsage = 1024, sisaRam = komputerSaya.RAM-ramUsage;
                        System.out.println("Sisa RAM --> " + sisaRam);
                        System.out.println("watching ... ");
                        System.out.println("Enter to exit video player ... ");
                        komputerSaya.promptEnterKey();
                    }else{
                        System.out.println("Nyalakan PC terlebih dahulu");
                        komputerSaya.promptEnterKey();
                    }
                    break;
                case "0" :
                    Running = false;
//                    System.exit(0); // --> bisa juga dibuat seperti ini untuk exit
            }
        }
    }
}