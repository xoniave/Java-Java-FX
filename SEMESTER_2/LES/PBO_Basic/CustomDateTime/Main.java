package SEMESTER_2.LES.PBO_Basic.CustomDateTime;

public class Main {
    public static void main(String[] args) {
        DateTime DT1 = new DateTime(2025,12,5,7,50);
        DateTime DT2 = new DateTime(2025,11,5,7,50);

        //SOMETHING WONG ABOUT THIS

        if(DT1.isBefore(DT2))
        {
            System.out.println("Sebelum");
        }
        else if(DT1.isAfter(DT2))
        {
            System.out.println("Sesudah");
        }
    }
}
