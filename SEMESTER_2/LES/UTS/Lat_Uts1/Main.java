package SEMESTER_2.LES.UTS.Lat_Uts1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> Data_Mahasiswa = new ArrayList<>();

        Mahasiswa Mhs1 = new Mahasiswa("C14240066","Klarisza Jesselyn");
        Mahasiswa Mhs2 = new Mahasiswa("C14240034","Bryan Nathanael Rahardja");
        Mahasiswa Mhs3 = new Mahasiswa("C14240007","Ryan Anthony Lawuono");

        Mhs1.setNilai(3);
        Mhs2.setNilai(3);
        Mhs3.setNilai(3);

        Data_Mahasiswa.add(Mhs1);
        Data_Mahasiswa.add(Mhs2);
        Data_Mahasiswa.add(Mhs3);


        for(int A = 0; A < Data_Mahasiswa.size(); A++)
        {
            Data_Mahasiswa.get(A).display();
            System.out.println();
            System.out.println("------------------------------------");
            System.out.println();
        }
    }
}
