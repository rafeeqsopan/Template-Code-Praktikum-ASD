class Kotakkk {
    double panjang;
    double lebar;
    double tinggi;

    // Mendefinisikan method dengan parameter
    void isiData(double p, double l, double t) {
        panjang = p;
        lebar = l;
        tinggi = t;
    }

    double hitungVolume() {
        return (panjang * lebar * tinggi);
    }
}

class DemoMethod3 {
    public static void main(String[] args) {
        Kotakkk k;
        // Instansiasi objek
        k = new Kotakkk();
        // Memanggil method isiData()
        k.isiData(4, 3, 2);
        System.out.println("Volume kotak = " + k.hitungVolume());
    }
}