package SEMESTER_2.LES.MateriEncapulation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);
        StudentGrade SG = new StudentGrade();

        boolean LOOP = true;
        while (LOOP)
        {
            System.out.println("Report Card : ");
            System.out.println("NRP : " + SG.getNRP());
            System.out.println("Nama : " + SG.getNama());
            System.out.println("UTS : " + SG.getUTS());
            System.out.println("UAS : " + SG.getUAS());
            System.out.println("PRAKTIKUM : " + SG.getPRAKTIKUM());
            System.out.println("Nilai Akhir : " + SG.getNilaiAkhir());


            System.out.println("-------------------");
            System.out.println("1.Input data");
            System.out.println("2.Input UTS");
            System.out.println("3.Input UAS");
            System.out.println("4.Input Praktikum");
            System.out.println("5.Input Bobot (UTS,UAS,PRAKTIKUM)");
            System.out.println("0.Exit");
            System.out.print(">> ");

            switch (scanint.nextInt())
            {
                case 1:
                    System.out.print("Masukan Nama : ");
                    SG.setNama(scanstr.nextLine());
                    System.out.print("Masukan NRP : ");
                    SG.setNRP(scanstr.nextLine());
                    break;
                case 2:
                    System.out.print("Masukan Nilai UTS : ");
                    SG.setUTS(scanint.nextInt());
                    break;
                case 3:
                    System.out.print("Masukan Nilai UAS : ");
                    SG.setUAS(scanint.nextInt());
                    break;
                case 4:
                    System.out.print("Masukan Nilai PRAKTIKUM : ");
                    SG.setPRAKTIKUM(scanint.nextInt());
                    break;
                case 5:
                    System.out.print("Masukan Weight UTS : ");
                    SG.setWuts(scanint.nextInt());

                    System.out.print("Masukan Weight UAS : ");
                    SG.setWuas(scanint.nextInt());

                    System.out.print("Masukan Weight PRAKTIKUM : ");
                    SG.setWpraktikum(scanint.nextInt());
                    break;
                case 0:
                    LOOP = false;
                    break;
            }
        }
    }
}
