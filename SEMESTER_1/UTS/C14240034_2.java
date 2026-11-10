import java.util.Scanner;

public class C14240034_2 {
    public static void main(String[] args) {

        //DEKLARASI VARIABLE DAN SCANNER
        Scanner scan = new Scanner(System.in);

        int Pilih,Jumlah,TotalBelanja,Uang,Harga; //VARIABLE PENAMPUNG
        String Barang = "";

        //INPUTAN
        System.out.println("Pilih produk (1:Soda - 10.000, 2: Snack - 5.000) : ");
        Pilih = scan.nextInt();
        System.out.println("Masukan Jumlah barang yang ingin di beli : ");
        Jumlah = scan.nextInt();

        //PENGISIAN HARGA DAN NAMA BARANG UNTUK PENGGUNAAN OUTPUT DAN HITUNG
        if(Pilih == 1)
        {
            Harga = 10000;
            Barang = "Soda";
        }
        else {
            Harga = 5000;
            Barang = "Snack";
        }

        TotalBelanja = Harga * Jumlah; //MENGHITUNG TOTAL BELANJA
        System.out.println("Harga Total : " + TotalBelanja);
        System.out.print("Masukan Uang : ");
        Uang = scan.nextInt();

        //PENGECEKAN APAKAH UANG MELEBIHI
        if(Uang > TotalBelanja)
        {
            System.out.println("Selamat menikmati " + Jumlah + " " + Barang + "! uang kembalian anda Rp " + (Uang - TotalBelanja));
        }
        else if(Uang == TotalBelanja)  //APAKAH UANG SAMA
        {
            System.out.println("Selamat menikmati " + Jumlah + " " + Barang + "!");
        }
        else { //JIKA KURANG MAKA MINTA INPUTAN
            while (Uang < TotalBelanja) //MEMINTA INPUT UANG HINGGA MENCUKUPI
            {
                System.out.println("Uang belum cukup, Silahkan tambahkan");
                System.out.print("masukan Uang : ");
                Uang+= scan.nextInt();
            }
            //PENGECEKAN UNTUK OUTPUT
            if(Uang > TotalBelanja)
            {
                System.out.println("Transaksi Berhasil Selamat menikmati " + Jumlah + " " + Barang + "! uang kembalian anda Rp " + (Uang - TotalBelanja));
            }
            else if(Uang == TotalBelanja)
            {
                System.out.println("Transaksi berhasil Selamat menikmati " + Jumlah + " " + Barang + "!");
            }
        }
    }
}
