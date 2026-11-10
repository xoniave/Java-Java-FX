import java.util.Scanner;

public class Pertemuan1 {

    //ini sebuah fungsi main strukturnya selalu seperti ini ketika bikin main
    public static void main(String[] args) {

        //ini cara mengeluarkan output/ hasil
        System.out.println("hi");

        //static tying bisa di sebut juga data primitive
        int x = 10;
        double y = 3.14;
        String z = "123";
        boolean flag = true;

        //x = "123"; //gk bisa
        x = 20; // bisa di ubah selama data type sama

        //cara input
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan nama : ");
        String nama = scan.nextLine();


        System.out.print("masukan umur : ");
        int umur = scan.nextInt();


        System.out.println("halo nama saya " + nama + "umur saya " + umur);
        System.out.printf("halo nama saya %s umur saya %d ",nama,umur);
        System.out.println();
        //operator sederhana
        System.out.println("halo nama saya " + nama + "umur saya " + (umur+1));


        /* ini Comment untuk text panjang
        1. halo
        2. 123
        */

        // ini Comment per baris
        // 1. halo
        // 2. 123
    }
}
