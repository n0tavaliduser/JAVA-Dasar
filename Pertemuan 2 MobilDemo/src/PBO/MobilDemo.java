package PBO;

class Mobil {
    String warna;
    int tahunProduksi;
}
public class MobilDemo {

    public static void main(String[] args) {
        Mobil mobilku = new Mobil();
        Mobil mobilmu = new Mobil();

        mobilku.warna = "Hitam";
        mobilku.tahunProduksi = 2006;
        mobilmu.warna = "Hijau";
        mobilmu.tahunProduksi = 2007;

        System.out.println("Warna : " + mobilku.warna);
        System.out.println("Tahun : " + mobilku.tahunProduksi);

        System.out.println("Warna : " + mobilmu.warna);
        System.out.println("Tahun : " + mobilmu.tahunProduksi);
    }
}
