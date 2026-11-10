import java.util.ArrayList;
import java.util.Scanner;

public class Pertemuan3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> Data_Barang = new ArrayList<>();

        for(int A = 0; A < 2; A++){
            Barang B = new Barang();
            B.nama = scan.nextLine();
            B.stok = scan.nextInt();

        }
    }
}



