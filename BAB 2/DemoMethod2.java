// Program Latihan Praktikum 2.5.2
class Kotakk {
    double panjang;
    double lebar;
    double tinggi;

    // mendefinisikan method yang mengembalikan tipe double
    double hitungVolume() {
        // menghitung volume
        double vol = panjang * lebar * tinggi;
        // mengembalikan nilai
        return vol;
    }
}

class DemoMethod2 {
    public static void main(String[] args) {
        Kotakk k1, k2, k3;
        // instansiasi objek
        k1 = new Kotakk();
        k2 = new Kotakk();
        k3 = new Kotakk();
        // mengisi data untuk objek k1
        k1.panjang = 4;
        k1.lebar = 3;
        k1.tinggi = 2;
        // mengisi data untuk objek k2
        k2.panjang = 6;
        k2.lebar = 5;
        k2.tinggi = 4;
        // mengisi data untuk objek k3
        k3.panjang = 8;
        k3.lebar = 7;
        k3.tinggi = 6;
        System.out.println("Volume k1 = " + k1.hitungVolume());
        System.out.println("Volume k2 = " + k2.hitungVolume());
        System.out.println("Volume k3 = " + k3.hitungVolume());
    }
}