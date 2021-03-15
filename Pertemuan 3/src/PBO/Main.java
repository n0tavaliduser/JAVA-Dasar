// Stevano Titondea Prayoga Putra
// A11.2019.11831

package PBO;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class TV {
    int channel = 1, volumeLevel = 1;
    boolean on = false;

    // Nyalakan TV
    public void turnOn() {
        if (!on) {
            on = true;
        }else{
            System.out.println("Sudah on");
            promptEnterKey();
        }
    }

    // Matikan TV
    public void turnOff() {
        if (on) {
            on = false;
            channel = 1;
        }else{
            System.out.println("Sudah off");
            promptEnterKey();
        }
    }

    // set channel
    public void setChannel(int newChannel) {
        channel = newChannel;
    }

    // set volume
    public void setVolumeLevel(int newVolume) {
        volumeLevel = newVolume;
    }

    // Channel Up
    public void channelUp() {
        channel+=1;
    }

    // Channel Down
    public void channelDown() {
        channel-=1;
    }

    // Volume Up
    public void volumeUp() {
        volumeLevel+=1;
    }

    // Volume Down
    public void volumeDown() {
        volumeLevel-=1;
    }

    // ===============================================
    // Tambahan

    // Enter to continue
    public void promptEnterKey() {
        System.out.println("press ENTER to continue");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        TV tvSaya = new TV();
        String ch = ""; // --> mengubah nilai angka channel menjadi nama channel
        Scanner userInput = new Scanner(System.in);
        boolean tvStatus = true;

        while (tvStatus) {

            // clear console
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

            // channel encode
            if (tvSaya.channel == 1) {
                ch = "tvOne";
            }else if (tvSaya.channel == 2) {
                ch = "ANTV";
            }else if (tvSaya.channel == 3) {
                ch = "RCTI";
            }else if (tvSaya.channel == 4) {
                ch = "ANTV";
            }else if (tvSaya.channel > 4) {
                ch = String.valueOf(tvSaya.channel);
            }

            // Display
            System.out.println("=================================");
            System.out.print("TV -> ");
            System.out.println("\n=============TV==================");
            System.out.println("| Channel : " + ch);
            System.out.println("| Vol     : "+ tvSaya.volumeLevel);
            System.out.println("=================================");
            System.out.println("1|Power |2|Ch\t |3|Vol | Fitur +");
            System.out.println("\t|4|Ch+\t |5|Ch- |8| sgnal");
            System.out.println("\t|6|Vol+  |7|Vol-|");

            // user input
            System.out.print("--> ");
            String choose = userInput.next();
            switch (choose) {
                case "1" :
                    if (!tvSaya.on) {
                        tvSaya.turnOn();
                        break;
                    }else{
                        tvSaya.turnOff();
                        tvStatus=false;
                    }
                    break;
                case "2" :
                    if (tvSaya.on) {
                        System.out.print("nomor channel --> ");
                        int angka = userInput.nextInt();
                        tvSaya.setChannel(angka);
                        break;
                    }else{
                        System.out.println("tv masih mati");
                        tvSaya.promptEnterKey();
                    }
                    break;
                case "3" :
                    if (tvSaya.on) {
                        System.out.println("volume --> ");
                        int nomor = userInput.nextInt();
                        tvSaya.setVolumeLevel(nomor);
                    }
                    break;
                case "4" :
                    if (tvSaya.on) {
                        tvSaya.channelUp();
                    break;
                case "5" :
                    if (tvSaya.on) {
                        tvSaya.channelDown();
                        break;
                    }else{
                        System.out.println("tv masih mati");
                        tvSaya.promptEnterKey();
                    }
                    break;
                case "6" :
                    if (tvSaya.on) {
                        tvSaya.volumeUp();
                    }else{
                        System.out.println("tv masih mati");
                        tvSaya.promptEnterKey();
                    }
                    break;
                case "7" :
                    if (tvSaya.on) {
                        tvSaya.volumeDown();
                    break;
                case "8" :
                    tvSaya.signalStrength();
                    break;
            }
        }
    }
}
