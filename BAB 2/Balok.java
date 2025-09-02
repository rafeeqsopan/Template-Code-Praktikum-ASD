// Program Latihan Praktikum 2.5.4
import java.util.Scanner;
class Balok {
    int p, l, t;

    int volume(int p, int l, int t) {
        return (p * l * t);
    }

    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        
        System.out.print("Panjang = ");
        int a = masuk.nextInt();
        
        System.out.print("Lebar = ");
        int b = masuk.nextInt();
        
        System.out.print("Tinggi = ");
        int c = masuk.nextInt();
        
        Balok coba = new Balok();
        
        System.out.print("\nVolume balok = " + coba.volume(a, b, c));
        
        masuk.close();
    }
}