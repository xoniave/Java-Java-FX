package SEMESTER_1.LES.LatihanLogika;

import java.util.Scanner;

public class A2 {

    public static int CheckSpeed(int OldTime,int OldDistance,int CurrentTime,int CurrentDistance)
    {

        System.out.println("Ct : " + CurrentTime);
        System.out.println("Ot : " + OldTime);

        System.out.println("Cd : " + CurrentDistance);
        System.out.println("Od : " + OldDistance);

        return (CurrentDistance - OldDistance) / (CurrentTime - OldTime);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukan Sample : ");
        int N = scan.nextInt();

        int LastWaktu = 0,LastJarak = 0,MaxSpeed = 0,Speed = 0,CTime = 0,Cdis = 0;
        for (int A = 0; A < N; A++)
        {

            CTime = scan.nextInt();
            Cdis = scan.nextInt();

            if(A >= 1)
            {
                Speed = CheckSpeed(LastWaktu,LastJarak,CTime,Cdis);
                System.out.println(Speed);
            }
            if(MaxSpeed < Speed)
            {
                MaxSpeed = Speed;
            }

            LastWaktu = CTime;
            LastJarak = Cdis;
        }

        System.out.println("Max Speed : " + MaxSpeed);
    }
}
