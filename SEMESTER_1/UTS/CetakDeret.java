package SEMESTER_1.UTS;

public class CetakDeret {

    void cetakMulai()
    {
        int Bil,batas;
        System.out.print("Bilangan : ");
        Bil = Main.scanint.nextInt();

        System.out.print("Batas : ");
        batas = Main.scanint.nextInt();

        int Hasil = 1;
        int Penjumlahan = 0;
        for (int A = 0; A < batas; A++)
        {
            Hasil *= Bil;
            Penjumlahan += Hasil;
            if(A == batas-1)
            {
                System.out.println(Hasil + " = " + Penjumlahan);
            }
            else
            {
                System.out.print(Hasil + " ");
            }
        }
    }
}
