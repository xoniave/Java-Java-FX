package SEMESTER_2.LES.UTS.Lat_Uts3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<mahasiswa> Data_Mahasiswa = new ArrayList<>();
        ArrayList<Buku> Data_Buku = new ArrayList<>();

        Buku B1 = new Buku("001","pcu1");
        Buku B2 = new Buku("002","pcu2");
        Buku B3 = new Buku("003","pcu3");
        Data_Buku.add(B1);
        Data_Buku.add(B2);
        Data_Buku.add(B3);

        mahasiswa m1 = new mahasiswa("c14240034","Bryan Nathanael Rahardja","",false);
        mahasiswa m2 = new mahasiswa("c14240066","Klarisza Jesslyn","",false);
        mahasiswa m3 = new mahasiswa("c14240007","Ryan Anthony Lawuono","",false);
        Data_Mahasiswa.add(m1);
        Data_Mahasiswa.add(m2);
        Data_Mahasiswa.add(m3);

        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);

        while (true)
        {
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Tambah Buku");
            System.out.println("4. Lihat Mahasiswa");
            System.out.println("5. Lihat Buku");
            System.out.println("6. Exit");

            int menu = scanint.nextInt();

            if(menu == 6)
            {
                break;
            }
            else {
                switch (menu)
                {
                    case 1:

                        boolean checkmaha = false,checkbuku = false;
                        int IDXMAHA = 0,IDXBUKU = 0;


                        System.out.println("Masukan id mahasiswa : ");
                        String id_mahasiswa = scanstr.nextLine();

                        for(int A = 0; A < Data_Mahasiswa.size(); A++)
                        {
                            if(Data_Mahasiswa.get(A).getNrp().equalsIgnoreCase(id_mahasiswa))
                            {
                                IDXMAHA = A;
                                if(Data_Mahasiswa.get(A).isStatus())
                                {
                                    break;
                                }
                                else {
                                    checkmaha = true;
                                }
                                break;
                            }
                        }


                        System.out.println("Masukan id buku : ");
                        String id_buku = scanstr.nextLine();

                        //Check buat buku dulu
                        for(int A = 0; A < Data_Buku.size(); A++)
                        {
                            if(id_buku.equalsIgnoreCase(Data_Buku.get(A).getId()))
                            {
                                checkbuku = true;
                                break;
                            }
                        }

                        if(checkbuku && checkmaha)
                        {
                            Data_Mahasiswa.get(IDXMAHA).setId_buku(Data_Buku.get(IDXBUKU).getId());
                            Data_Mahasiswa.get(IDXMAHA).setStatus(true);
                            System.out.println("berhasil");
                        }
                        else {
                            System.out.println("Eror karena mahaid tdk ada/ buku tdk ada / status true");
                        }

                        break;
                    case 2:

                        System.out.println("masukan nama : ");
                        String nama = scanstr.nextLine();

                        System.out.println("Masukan nrp");
                        String nrp = scanstr.nextLine();

                        mahasiswa M = new mahasiswa(nrp,nama,"",false);

                        Data_Mahasiswa.add(M);
                        System.out.println("berhasil");


                        break;
                    case 3:

                        System.out.println("masukan id buku : ");
                        String idbuku = scanstr.nextLine();

                        System.out.println("masukan nama buku : ");
                        String namabuku = scanstr.nextLine();

                        Buku B = new Buku(idbuku,namabuku);
                        Data_Buku.add(B);
                        break;
                    case 4:
                        for(int A = 0; A < Data_Mahasiswa.size(); A++)
                        {
                            System.out.println("NRP : " + Data_Mahasiswa.get(A).getNrp());
                            System.out.println("Nama : " + Data_Mahasiswa.get(A).getNama());
                            System.out.println("IDBUKU : " + Data_Mahasiswa.get(A).getId_buku());
                            System.out.println("Status : " + Data_Mahasiswa.get(A).isStatus());
                            System.out.println();
                        }
                        break;
                    case 5:

                        for(int A = 0; A < Data_Buku.size(); A++)
                        {
                            System.out.println("Id Buku : " + Data_Buku.get(A).getId());
                            System.out.println("Nama buku : " + Data_Buku.get(A).getNama_buku());
                            System.out.println();
                        }
                        break;
                }
            }

        }
    }
}
