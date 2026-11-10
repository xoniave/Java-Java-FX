package SEMESTER_1.UTS;

public class CheckInputan {

    int check(char Inputan)
    {
        int Hasil = -1;

        if(Inputan >= '0' && Inputan <= '9')
        {
            Hasil = 1;
        }
        else if(Inputan >= 'A' && Inputan <= 'Z' || Inputan >= 'a' && Inputan <= 'z')
        {
            Hasil = 2;
        }
        else if(Inputan == '+' || Inputan == '-' || Inputan == '*' || Inputan == '/' || Inputan == '%')
        {
            Hasil = 3;
        }

        return Hasil;
    }

    void Check()
    {
        char Inputan;
        System.out.print("Masukan Inputan : ");
        Inputan = Main.scanstr.next().charAt(0);

        if(check(Inputan) == 1)
        {
            System.out.println("Output : " + Inputan + " adalah Angka");
        }
        else if(check(Inputan) == 2)
        {
            System.out.println("Output : " + Inputan + " adalah Alfabet");
        }
        else if(check(Inputan) == 3)
        {
            System.out.println("Output : " + Inputan + " adalah Operator");
        }
        else {
            System.out.println("Output : " + Inputan + " adalah Karakter lain");
        }

    }
}
