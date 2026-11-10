package SEMESTER_2.GameTernak;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private char[][] papan = new char[6][6];
    private Hewan[][] Data = new Hewan[6][6];

    public Board()
    {
        for(int A = 0; A < 6; A++)
        {
            for(int B = 0; B < 6; B++)
            {
                papan[A][B] = '.';
            }
        }

        papan[0][0] = 'P';
    }

    public void initialized()
    {
        for(int A = 0; A < 6; A++)
        {
            for(int B = 0; B < 6; B++)
            {
                System.out.print(papan[A][B]);
            }
            System.out.println();
        }
    }


    public void Shop(Player P)
    {
        Scanner scanint = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Buy Menu");
        System.out.println("1.Chicken (20 gold)");
        System.out.println("2.Cow (100 gold)");
        System.out.println("3.Sheep (60 gold)");
        System.out.println("0.Back");
        System.out.println(">> ");

        switch (scanint.nextInt())
        {
            case 1:
                if(P.getGold() >= 20)
                {
                    P.setGold(P.getGold() - 20);
                    while (true) {
                        int AcakX = rand.nextInt(6);
                        int AcakY = rand.nextInt(6);

                        if (papan[AcakX][AcakY] == '.') {
                            papan[AcakX][AcakY] = 'A';
                            Data[AcakX][AcakY] = new Ayam();
                            break;
                        }
                    }
                }
                else {
                    System.out.println("No money nigga");
                }
                break;
            case 2:
                if(P.getGold() >= 100)
                {
                    P.setGold(P.getGold() - 100);
                    while (true) {
                        int AcakX = rand.nextInt(6);
                        int AcakY = rand.nextInt(6);

                        if (papan[AcakX][AcakY] == '.') {
                            papan[AcakX][AcakY] = 'S';
                            Data[AcakX][AcakY] = new Sapi();
                            break;
                        }
                    }
                }
                else {
                    System.out.println("No money nigga");
                }
                break;
            case 3:
                if(P.getGold() >= 60)
                {
                    P.setGold(P.getGold() - 60);
                    while (true) {
                        int AcakX = rand.nextInt(6);
                        int AcakY = rand.nextInt(6);

                        if (papan[AcakX][AcakY] == '.') {
                            papan[AcakX][AcakY] = 'D';
                            Data[AcakX][AcakY] = new Sheep();
                            break;
                        }
                    }
                }
                else {
                    System.out.println("No money nigga");
                }
                break;
        }
    }


    public void AnimalMove()
    {

    }

    public void CheckHewanNabrak(int Px,int Py)
    {
        if(Data[Px][Py] instanceof Ayam)
        {
            System.out.println("You meet a chicken");
            System.out.println("Status : " + Data[Px][Py].Status);
            System.out.println("1. Kasih Makan");
            System.out.println("2. ");
            System.out.println("3. egg");
        }
        else if(Data[Px][Py] instanceof Sapi)
        {

        }
        else if(Data[Px][Py] instanceof Sheep)
        {

        }
    }


    public void PlayerGerak(String gerak,Player P)
    {
        switch (gerak)
        {
            case "W":
                if(P.getPx() > 0)
                {
                    if(papan[P.getPx() - 1][P.getPy()] == '.')
                    {
                        papan[P.getPx()][P.getPy()] = '.';
                        papan[P.getPx() - 1][P.getPy()] = 'P';
                        P.setPx(P.getPx() - 1);
                    }
                    else {
                        CheckHewanNabrak(P.getPx()-1,P.getPy());
                    }
                }
                break;
            case "A":
                if(P.getPy() > 0)
                {

                    if(papan[P.getPx()][P.getPy()-1] == '.')
                    {
                        papan[P.getPx()][P.getPy()] = '.';
                        papan[P.getPx()][P.getPy()-1] = 'P';
                        P.setPy(P.getPy() - 1);
                    }
                    else {
                        CheckHewanNabrak(P.getPx(),P.getPy()-1);
                    }


                }
                break;
            case "S":
                if(P.getPx() < 5)
                {
                    if(papan[P.getPx()+1][P.getPy()] == '.') {
                        papan[P.getPx()][P.getPy()] = '.';
                        papan[P.getPx() + 1][P.getPy()] = 'P';
                        P.setPx(P.getPx() + 1);
                    }
                    else {
                        CheckHewanNabrak(P.getPx()+1,P.getPy());
                    }
                }
                break;
            case "D":
                if(P.getPy() < 5)
                {
                    if(papan[P.getPx()][P.getPy()+1] == '.') {
                        papan[P.getPx()][P.getPy()] = '.';
                        papan[P.getPx()][P.getPy() + 1] = 'P';
                        P.setPy(P.getPy() + 1);
                    }
                    else {
                        CheckHewanNabrak(P.getPx(),P.getPy()+1);
                    }
                }
                break;
        }
    }
}
