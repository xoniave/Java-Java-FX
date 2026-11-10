package SEMESTER_1.LES.UAS.UasTwoYearsAgo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) throws IOException {
        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);
        File MorseStr = new File("In.txt");
        File StrMorse = new File("Out.txt");

        String[][] morse = {
                {"A", ".-"},    {"B", "-..."},  {"C", "-.-."},  {"D", "-.."},   {"E", "."},
                {"F", "..-."},  {"G", "--."},   {"H", "...."},  {"I", ".."},    {"J", ".---"},
                {"K", "-.-"},   {"L", ".-.."},  {"M", "--"},    {"N", "-."},    {"O", "---"},
                {"P", ".--."},  {"Q", "--.-"},  {"R", ".-."},   {"S", "..."},   {"T", "-"},
                {"U", "..-"},   {"V", "...-"},  {"W", ".--"},   {"X", "-..-"},  {"Y", "-.--"},
                {"Z", "--.."},  {"0", "-----"}, {"1", ".----"}, {"2", "..---"}, {"3", "...--"},
                {"4", "....-"}, {"5", "....."}, {"6", "-...."}, {"7", "--..."}, {"8", "---.."},
                {"9", "----."}, {".", ".-.-.-"},{"?", "..--.."}, {"!", "-.-.--"},{" ", "/"}
        };




        boolean Loop = true;
        while (Loop)
        {
            System.out.println("1.Enkripsi");
            System.out.println("2.Dekripsi");
            System.out.println("0.Keluar");
            System.out.print("Pilihan : ");
            switch (scanint.nextInt())
            {
                case 1:
                    System.out.println("Masukan Kalimat : ");
                    String Kalimat = scanstr.nextLine();
                    try {
                        FileWriter Fw = new FileWriter("Out.txt",true);

                        String Hasil = "";
                        for(int A = 0; A < Kalimat.length(); A++)
                        {
                            String Isi = String.valueOf(Kalimat.charAt(A));
                            for(int B = 0; B < morse.length; B++)
                            {
                                if(Isi.equalsIgnoreCase(morse[B][0]))
                                {
                                    Hasil += morse[B][1] + " ";
                                    break;
                                }
                            }
                        }
                        Fw.append(Hasil).append("\n");
                        Fw.close();
                    }
                    catch (IOException e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("Masukan Kalimat : ");
                    String MORSE = scanstr.nextLine();
                    try {
                        FileWriter Fw1 = new FileWriter("In.txt",true);
                        Fw1.append(MORSE);

                        String[] Split = MORSE.split(" ");
                        String Hasil1 = "";

                        for(int A = 0; A < Split.length; A++)
                        {
                            for(int B = 0; B < morse.length; B++)
                            {
                                if(Split[A].equalsIgnoreCase(morse[B][1]))
                                {
                                    Hasil1 += morse[B][0];
                                }
                            }
                        }

                        Fw1.append(Hasil1).append("\n");
                        Fw1.close();
                    }
                    catch (IOException e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 0:
                    Loop = false;
                    break;
            }
        }
    }
}
