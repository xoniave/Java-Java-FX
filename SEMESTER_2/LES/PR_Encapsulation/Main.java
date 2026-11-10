package SEMESTER_2.LES.PR_Encapsulation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);

        MYDATE MD = new MYDATE();

        while (true)
        {
            System.out.println("Date Time : " + MD.getDay() + "/" + MD.getMonth() + "/" + MD.getYear());
            if(MD.GetLeapYear())
            {
                System.out.println("This is Leap Year");
            }
            else {
                System.out.println("This is not leap Year");
            }
            System.out.println("Menu : ");
            System.out.println("1.Set Day");
            System.out.println("2.Set Month");
            System.out.println("3.Set Year");
            System.out.println("4.Add Days");
            System.out.println("5.Add Months");
            System.out.println("0.Exit");
            System.out.print(">> ");
            int pilih = scanint.nextInt();
            if(pilih == 0)
            {
                break;
            }
            switch (pilih)
            {
                case 1:
                    System.out.print("Masukan Tanggal : ");
                    MD.setDay(scanint.nextInt());
                    break;
                case 2:
                    System.out.println("Masukan Bulan : ");
                    MD.setMonth(scanint.nextInt());
                    break;
                case 3:
                    System.out.println("Masukan Tahun : ");
                    MD.setYear(scanint.nextInt());
                    break;
                case 4:
                    System.out.println("Add Days : ");
                    MD.addDays(scanint.nextInt());
                    break;
                case 5:
                    System.out.println("Masukan Month : ");
                    MD.addMonth(scanint.nextInt());
                    break;
            }
        }
    }
}
