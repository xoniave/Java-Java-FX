package SEMESTER_1.UTS;

public class CetakMax10 {
    void Cetak()
    {
        int n = 0;
        System.out.println("angka : ");
        n = Main.scanint.nextInt();

        int ctr = 0,Baris = 1;
        for (int A = 1; A <= n; A++)
        {
            if (ctr == 10)
            {
                System.out.println();
                ctr = 0;
                Baris++;
            }
            System.out.print(A*Baris + " ");

            ctr++;
        }
        System.out.println();
    }
}
