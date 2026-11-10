package SEMESTER_2.digimon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SISTEM {
    public static Scanner ScanInt = new Scanner(System.in);
    public static Scanner ScanStr = new Scanner(System.in);
    public static PLAYER P = new PLAYER();
    public static int Hari = 1;


    void Menu() {
        System.out.println("Player Name : " + P.getNama());
        System.out.println("Banyak Digimon : " + P.getINVENTORY().size());
        System.out.println("- Hari " + Hari + "-");
        System.out.println("Uang : " + P.getUang());
        System.out.println("1.Beli Digimon");
        System.out.println("2.Train Digimon");
        System.out.println("3.Beri Makan");
        System.out.println("4.Lihat Status");
        System.out.println("5.Ganti Hari");
        System.out.println("0.Exit");
        System.out.print(">> ");
    }

    void Beli_Digi(String Nick) {
        System.out.println("==BUY YOUR DIGIMON==");
        System.out.println("1.Agumon");
        System.out.println("2.Gabumon");
        System.out.println("3.Renamon");
        System.out.print(">> ");

        switch (ScanInt.nextInt()) {
            case 1:
                DIGIMON A = new Agumon();

                if(Nick.equalsIgnoreCase(""))
                {
                    Nick = "Agumon";
                }
                A.setNickname(Nick);
                P.setINVENTORY(A);
                break;
            case 2:
                DIGIMON G = new Gabumon();
                if(Nick.equalsIgnoreCase(""))
                {
                    Nick = "Gabumon";
                }
                G.setNickname(Nick);
                P.setINVENTORY(G);
                break;
            case 3:
                DIGIMON R = new Renamon();
                if(Nick.equalsIgnoreCase(""))
                {
                    Nick = "Renamon";
                }
                R.setNickname(Nick);
                P.setINVENTORY(R);
                break;
        }
    }

    void List_Digi(ArrayList<DIGIMON> INVENTORY)
    {
        for(int A = 0; A < INVENTORY.size(); A++)
        {
            System.out.println((A+1) + ". " + INVENTORY.get(A).getNickname());
        }
    }

    void check(DIGIMON Shortcut, int IDX_DIGI)
    {
        if(!Shortcut.isEvolved())
        {
            if (Shortcut instanceof  Agumon temp)
            {
                temp.Evo(Shortcut.getStr(),Shortcut.getInt(),Shortcut.getAgi());
            }
            if (Shortcut instanceof  Gabumon temp)
            {
                temp.Evo(Shortcut.getStr(),Shortcut.getInt(),Shortcut.getAgi());
            }
            if (Shortcut instanceof  Renamon temp)
            {
                temp.Evo(Shortcut.getStr(),Shortcut.getInt(),Shortcut.getAgi());
            }
        }
    }

    void Train(ArrayList<DIGIMON> INVENTORY)
    {
        int IDX_DIGI = 0;
        Random random = new Random();

        System.out.println("PILIH DIGIMON YANG MAU DI LATIH");
        List_Digi(INVENTORY);
        System.out.print("Pilih Digi : ");
        IDX_DIGI = ScanInt.nextInt() - 1;

        DIGIMON Shortcut = P.getINVENTORY().get(IDX_DIGI);

        System.out.println();
        System.out.println("==========================================");
        System.out.println();

        System.out.println("==TRAIN YOUR DIGIMON==");
        System.out.println("1.STR");
        System.out.println("2.INT");
        System.out.println("3.AGI");
        System.out.print(">> ");

        switch (ScanInt.nextInt())
        {
            case 1:
                Shortcut.setStr(Shortcut.getStr() + random.nextInt(3)+1);
                check(Shortcut,IDX_DIGI);
                System.out.println("Digi train his muscle");
                break;
            case 2:
                Shortcut.setInt(Shortcut.getInt() + random.nextInt(3)+1);
                check(Shortcut,IDX_DIGI);
                System.out.println("Digi train his aura");
                break;
            case 3:
                Shortcut.setAgi(Shortcut.getAgi() + random.nextInt(3)+1);
                check(Shortcut,IDX_DIGI);
                System.out.println("Digi train his speed");
                break;
        }
    }

    void LihatStatus(ArrayList<DIGIMON> INVENTORY)
    {
        int IDX_DIGI = 0;
        System.out.println("PILIH DIGIMON YANG MAU DI LIHAT");
        List_Digi(INVENTORY);
        System.out.print("Pilih Digi : ");
        IDX_DIGI = ScanInt.nextInt() - 1;

        System.out.println(P.getINVENTORY().get(IDX_DIGI).toString());

    }

    void FEED(ArrayList<DIGIMON> INVENTORY)
    {
        int IDX_DIGI = 0;
        System.out.println("PILIH DIGIMON YANG MAU DI KASIH MAKAN");
        List_Digi(INVENTORY);
        System.out.print("Pilih Digi : ");
        IDX_DIGI = ScanInt.nextInt() - 1;

        P.getINVENTORY().get(IDX_DIGI).setMakan(true);
    }

    void GANTIHARI(ArrayList<DIGIMON> INVENTORY)
    {
        for(int A = 0; A < INVENTORY.size(); A++)
        {
            if(INVENTORY.get(A) instanceof Agumon)
            {
                if(INVENTORY.get(A).isEvolved())
                {
                    P.setUang(P.getUang() + 100);
                }
                else {
                    P.setUang((int) (P.getUang() + (100 * 2.5)));
                }
            }
            else if(INVENTORY.get(A) instanceof Gabumon)
            {
                if(INVENTORY.get(A).isEvolved())
                {
                    P.setUang(P.getUang() + 75);
                }
                else {
                    P.setUang((int) (P.getUang() + (75 * 2.5)));
                }
            }
            else if(INVENTORY.get(A) instanceof Renamon)
            {
                if(INVENTORY.get(A).isEvolved())
                {
                    P.setUang(P.getUang() + 150);
                }
                else {
                    P.setUang((int) (P.getUang() + (150 * 2.5)));
                }
            }
        }
    }

    void Game() {
        int menu = -1;
        while (menu != 0) {
            Menu();
            menu = ScanInt.nextInt();

            if (menu == 1) {
                if (P.getUang() >= 500) {
                    System.out.print("Masukan NickName Digimon : ");
                    String Nick = ScanStr.nextLine();

                    P.setUang(P.getUang() - 500);
                    Beli_Digi(Nick);
                } else {
                    System.out.println("Bro tried to buy Digimon without enough money");
                }
            } else if (menu == 2) {

                if(P.getINVENTORY().isEmpty())
                {
                    System.out.println("Bro tried to upgrade without SEMESTER_2.digimon ?");
                }
                else {
                    if (P.getUang() >= 50) {
                        P.setUang(P.getUang() - 50);
                        Train(P.getINVENTORY());
                    } else {
                        System.out.println("Bro tried to Train Digimon without enough money");
                    }
                }
            } else if (menu == 3) {
                if (P.getUang() >= 10) {
                    P.setUang(P.getUang() - 10);
                    FEED(P.getINVENTORY());
                } else {
                    System.out.println("Bro tried to Feed Digimon without enough money");
                }

            } else if (menu == 4) {
                LihatStatus(P.getINVENTORY());
            } else if (menu == 5) {
                Hari++;
                GANTIHARI(P.getINVENTORY());
            }
        }
    }
}

