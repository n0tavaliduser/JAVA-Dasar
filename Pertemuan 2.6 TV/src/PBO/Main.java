package PBO;

import java.io.IOException;
import java.util.Scanner;

class TV {
    int channel = 1, mesin = 0;

    // Nyalakan TV
    public void OnOff() {
        if (mesin == 0){
            mesin = 1;
        }else{
            mesin = 0;
        }
    }

    // Naikan channel TV
    public void ChannelUp() {
        channel+=1;
    }

    //Turunkan channel TV
    public void ChannelDown() {
        channel-=1;
    }
}
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        TV tvku = new TV();
        Scanner inputan = new Scanner(System.in);

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        boolean programLooping = true;
        while (programLooping) {
            String ch = "";
            if (tvku.mesin == 0) {
                ch = "";
            } else {
                if (tvku.channel == 1) {
                    ch = "tvOne";
                } else if (tvku.channel == 2) {
                    ch = "rcti";
                } else if (tvku.channel == 3) {
                    ch = "antv";
                } else if (tvku.channel == 4) {
                    ch = "sctv";
                } else if (tvku.channel == 5) {
                    ch = "globalTV";
                }
            }
            System.out.println("=============TVKU=============");
            if (tvku.mesin == 0) {
                System.out.println("TV MATI");
            } else if (tvku.mesin == 1) {
                System.out.println("TV NYALA");
            }
            System.out.println("Channel -- > " + ch);
            System.out.println("1. Power TV");
            System.out.println("2. Ganti Channel Naik");
            System.out.println("3. Ganti Channel Turun");
            System.out.println("0. Exit");
            System.out.print("pilihan : ");
            String pilihan = inputan.next();
            switch (pilihan) {
                case "1":
                    tvku.OnOff();
                    break;
                case "2":
                    if (tvku.channel == 5) {
                        tvku.channel = 1;
                    }else{
                        tvku.ChannelUp();
                    }
                    break;
                case "3":
                    if (tvku.channel == 1) {
                        tvku.channel = 5;
                    }else{
                        tvku.ChannelDown();
                    }
                    break;
            }
        }
    }
}

