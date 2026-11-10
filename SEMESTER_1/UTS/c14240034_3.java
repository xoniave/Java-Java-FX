import java.util.ArrayList;
import java.util.Scanner;

public class c14240034_3 {

    public static void InputDataNama_Nilai(ArrayList<String> nama, ArrayList<Integer> nilai,int Jumlah)
    {
        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);

        //INPUT ISI ARRAY
        for(int A = 0; A < Jumlah; A++)
        {
            System.out.print("Masukan Nama Mahasiswa ke - " + (A+1) + " : ");
            nama.add(scanstr.nextLine());
            System.out.print("Masukan nilai ujian Mahasiswa ke - " + (A+1) + " : ");
            nilai.add(scanint.nextInt());
        }
    }

    public static void TampilkanData(ArrayList<String> nama, ArrayList<Integer> nilai)
    {
        //PRINT ISI ARRAY
        for(int A = 0; A < nama.size(); A++)
        {
            System.out.println("Nama : " + nama.get(A) + ",   Nilai : " + nilai.get(A));
        }
    }

    public static void SearchDariNilai(ArrayList<String> nama, ArrayList<Integer> nilai,int NilaiDiCari)
    {
        boolean ada = false; //VARIABLE UNTUK menandai apakah terdapat siswa dengan nilai yg di cari
        for(int A = 0; A < nama.size(); A++)
        {
            if(nilai.get(A) == NilaiDiCari) //PENGECEKAN
            {
                ada = true;
                System.out.println("Nama : " + nama.get(A) + ",   Nilai : " + nilai.get(A));
            }
        }
    }

    public static void TigaNilaiTertinggi(ArrayList<String> nama, ArrayList<Integer> nilai)
    {
        if(nama.size() <= 3) //PENGECEKAN TOTAL MAHASISWA APAKAH SUDAH DI BAWAH 3
        {
            for(int A = 0; A < nama.size(); A++)
            {
                System.out.println("Nama : " + nama.get(A) + ",   Nilai : " + nilai.get(A));
            }
        }
        else { //JIKA TIDAK MAKA MASUK SINI

            //PEMBUATAN ARRAY BARU
            ArrayList<String> NamaHighest = new ArrayList<>();
            ArrayList<Integer> NilaiHighest = new ArrayList<>();

            //MENGISI ARRAY BARU DENGAN DATA YANG ADA YAITU ARRAY NILAI DAN NAMA
            for(int A = 0; A < nilai.size(); A++)
            {
                NamaHighest.add(nama.get(A));
                NilaiHighest.add(nilai.get(A));
            }

            //MELAKUKAN SORTING DARI BESAR KE KECIL AGAR BISA DI AMBIL 3 INDEX PERTAMA UNTUK 3 top siswa
            for(int A = 0; A < nilai.size()-1; A++)
            {
                for (int B = A+1; B < nilai.size(); B++)
                {
                    if(NilaiHighest.get(A) < NilaiHighest.get(B)) //SORTING
                    {
                        int Temp = NilaiHighest.get(A);
                        NilaiHighest.set(A,NilaiHighest.get(B));
                        NilaiHighest.set(B,Temp);

                        String TempNama = NamaHighest.get(A);
                        NamaHighest.set(A,NamaHighest.get(B));
                        NamaHighest.set(B,TempNama);
                    }
                }
            }

            //MENCETAK DARI 3 index pertama
            for(int A = 0; A < 3; A++)
            {
                System.out.println("Nama : " + NamaHighest.get(A) + ",   Nilai : " + NilaiHighest.get(A));
            }
        }
    }

    public static void MenghitungKelulusan(ArrayList<String> nama, ArrayList<Integer> nilai)
    {
        int Lulus = 0,TidakLulus = 0; //MEMBUAT VARIABLE JUMLAH LULUS DAN TIDAK LULUS

        //MENGECEK SISWA YANG LULUS MAUPUN TIDAK DENGAN SYARAT DI ATAS ^) KALAU LULUS
        for(int A = 0; A < nama.size();A++)
        {
            if(nilai.get(A) >= 60)
            {
                Lulus++;
            }
            else {
                TidakLulus++;
            }
        }

        //PENGHITUNGAN PERSENTASE
        double PersenLulus = ((double) Lulus /nilai.size()) * 100;
        double PersenTidakLulus = ((double) TidakLulus /nilai.size()) * 100;

        //MENCETAK
        System.out.println("Mahasiswa Lulus : " + Lulus + "(" + (int)PersenLulus + "%)");
        System.out.println("Mahasiswa TidakLulus : " + TidakLulus + "(" + (int)PersenTidakLulus + "%)");
    }

    public static void SORTINGSISWA(ArrayList<String> nama, ArrayList<Integer> nilai)
    {
        //MELAKUKAN SORTING
        for(int A = 0; A < nilai.size()-1; A++)
        {
            for (int B = A+1; B < nilai.size(); B++)
            {
                if(nilai.get(A) < nilai.get(B)) //SORTING
                {
                    int Temp = nilai.get(A);
                    nilai.set(A,nilai.get(B));
                    nilai.set(B,Temp);

                    String TempNama = nama.get(A);
                    nama.set(A,nama.get(B));
                    nama.set(B,TempNama);
                }
            }
        }

        for(int A = 0; A < nilai.size(); A++)//MENCETAK
        {
            System.out.println("Nama : " + nama.get(A) + ",   Nilai : " + nilai.get(A));
        }
    }


    public static void main(String[] args) {
        //DEKLARASI VARIABLE SCANNER DAN INPUTAN
        Scanner scan = new Scanner(System.in);

        ArrayList<String> NamaMahasiswa = new ArrayList<>();
        ArrayList<Integer> NilaiMahasiswa = new ArrayList<>();

        int Pilihan,Jumlah,NilaiYangDiCari;

        //MEMASUKI SISTEM MENU
        while (true) {
            System.out.println("1.Input Data Mahasiswa");
            System.out.println("2.Menampilkan Data Mahasiswa");
            System.out.println("3.Search Mahasiswa Berdasarkan Nilai");
            System.out.println("4.Menampilkan 3 Mahasiswa dengan Nilai tertinggi");
            System.out.println("5.Menghitung dan menampilkan jumlah mahasiswa yang lulus");
            System.out.println("6.Sorting");
            System.out.println("0.exit");
            System.out.print(">> ");
            Pilihan = scan.nextInt();

            if(Pilihan == 0)break; //JIKA 0 MAKA EXIT

            switch (Pilihan) //PILIHAN MENU
            {
                case 1: //MANGGIL FUNCTION INPUT DATA NAMA NILAI
                    System.out.print("masukan Jumlah : ");
                    Jumlah = scan.nextInt();
                    InputDataNama_Nilai(NamaMahasiswa,NilaiMahasiswa,Jumlah);
                    break;
                case 2: //FUNCTION MENCETAK DATA
                    TampilkanData(NamaMahasiswa,NilaiMahasiswa);
                    break;
                case 3: //MEMNAGIL FUNCTION NILAI YANG DI CARI
                    System.out.println("Nilai yang ingin di cari : ");
                    NilaiYangDiCari = scan.nextInt();

                    SearchDariNilai(NamaMahasiswa,NilaiMahasiswa,NilaiYangDiCari);
                    break;
                case 4://MEMANGIL FUNCTION TIGA NILAI TERTINGGI
                    TigaNilaiTertinggi(NamaMahasiswa,NilaiMahasiswa);
                    break;
                case 5: //MEMANGGIL FUNCTION MENGHITUNG KELULUSAN
                    MenghitungKelulusan(NamaMahasiswa,NilaiMahasiswa);
                    break;
                case 6://memanggil fungsi sort
                    SORTINGSISWA(NamaMahasiswa,NilaiMahasiswa);
                    break;
            }
        }
    }
}
