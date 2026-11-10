package SEMESTER_2.LES.UTS.Lat_Uts1;

import java.util.ArrayList;
import java.util.Random;

public class Mahasiswa {
    private String nrp,nama;
    private double ipk;
    private ArrayList<nilaiMhs> Data_Nilai = new ArrayList<>();
    private String[] grade  = {"A","B+","B","C+","C","D","E"};;
    private double[] angka = {4,3.5,3,2.5,2,1.5,1};

    public Mahasiswa()
    {
        this.nrp = "";
        this.nama = "";
    }

    public Mahasiswa(String nrp,String nama){
        this.nrp = nrp;
        this.nama = nama;
    }

    public void setNilai(int jum)
    {
        Random rand = new Random();


        for(int A = 1; A <= jum; A++)
        {
            nilaiMhs n = new nilaiMhs(("MK-" + A),grade[rand.nextInt(6)],(rand.nextInt(3) + 2),(rand.nextInt(2) + 1));
            Data_Nilai.add(n);
        }
    }

    public double hitungIPK()
    {
        int totalsks  = 0;
        double totalgrade = 0;

        for(int A = 0; A < Data_Nilai.size(); A++)
        {
            totalsks += Data_Nilai.get(A).getSks();

            int Idx = 0;

            for(int B = 0; B < grade.length; B++)
            {
                if(grade[B].equalsIgnoreCase(Data_Nilai.get(A).getGrade()))
                {
                    Idx = B;
                    break;
                }
            }

            totalgrade += Data_Nilai.get(A).getSks() * angka[Idx];
        }

        return totalgrade / totalsks;
    }

    public double hitungIPS(int sem)
    {
        int totalsks  = 0;
        double totalgrade = 0;

        for(int A = 0; A < Data_Nilai.size(); A++)
        {
            if(Data_Nilai.get(A).getSemester() == sem)
            {
                totalsks += Data_Nilai.get(A).getSks();

                int Idx = 0;

                for(int B = 0; B < grade.length; B++)
                {
                    if(grade[B].equalsIgnoreCase(Data_Nilai.get(A).getGrade()))
                    {
                        Idx = B;
                        break;
                    }
                }

                totalgrade += Data_Nilai.get(A).getSks() * angka[Idx];
            }
        }

        return totalgrade / totalsks;
    }

    public void display()
    {
        System.out.println("Nama : " + this.nama);
        System.out.println("NRP : " + this.nrp);
        System.out.println("IPK : " + hitungIPK());
        System.out.println("Data Nilai : ");

        for(int A = 0; A < Data_Nilai.size(); A++)
        {
            System.out.println((A+1) + " Nama MK : " + Data_Nilai.get(A).getNamaMK());
            System.out.println("SKS : " + Data_Nilai.get(A).getSks());
            System.out.println("Grade : " + Data_Nilai.get(A).getGrade());
            System.out.println("Semester : " + Data_Nilai.get(A).getSemester());

            System.out.println();
        }

        System.out.println("IPS 1 : " + hitungIPS(1));
        System.out.println("IPS 2 : " + hitungIPS(2));

    }

}
