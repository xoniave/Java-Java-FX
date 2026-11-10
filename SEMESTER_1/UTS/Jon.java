package SEMESTER_1.UTS;

import java.util.Scanner;

public class Jon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String Hari,Waktu,Hujan;

        System.out.print("Hari apa : ");
        Hari = scan.nextLine();

        System.out.print("Waktu : ");
        Waktu = scan.nextLine();

        System.out.print("Hujan : ");
        Hujan = scan.nextLine();

        //Check
        if((Hari.equalsIgnoreCase("Senin") || Hari.equalsIgnoreCase("Selasa") ||Hari.equalsIgnoreCase("Rabu") || Hari.equalsIgnoreCase("Kamis") ||Hari.equalsIgnoreCase("Jumat")) && (Waktu.equalsIgnoreCase("Pagi") || Waktu.equalsIgnoreCase("Siang")))
        {
            System.out.println("joni di Sekolah");
        }
        else if((Waktu.equalsIgnoreCase("Sore") && Hujan.equalsIgnoreCase("Tidak")) && (!Hari.equalsIgnoreCase("Selasa") || !Hari.equalsIgnoreCase("Kamis")) )
        {
            System.out.println("joni bermain bola");
        }
        else if( (Hujan.equalsIgnoreCase("Iya") || Hujan.equalsIgnoreCase("Tidak")) && (Hari.equalsIgnoreCase("Selasa") || Hari.equalsIgnoreCase("Kamis")))
        {
            System.out.println("joni les");
        }
        else if((Hari.equalsIgnoreCase("Sabtu") || Hari.equalsIgnoreCase("Minggu")) && Hujan.equalsIgnoreCase("Tidak"))
        {
            System.out.println("joni ke mall");
        }
        else if((Hari.equalsIgnoreCase("Sabtu") || Hari.equalsIgnoreCase("Minggu")) && Hujan.equalsIgnoreCase("Iya"))
        {
            System.out.println("joni bermain game");
        }
        else if(Hari.equalsIgnoreCase("Minggu") && Waktu.equalsIgnoreCase("Pagi"))
        {
            System.out.println("joni gereja");
        }
        else {
            System.out.println("joni tidur");
        }


    }
}
