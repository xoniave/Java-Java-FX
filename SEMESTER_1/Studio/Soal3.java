package SEMESTER_1.Studio;

// Jangan ganti nama class di bawah ini!
import java.util.Scanner;
public class Soal3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        char [][] Data = new char[n][m];

        scan.nextLine();
        for(int A = 0; A < n; A++)
        {
            for(int B = 0; B < m; B++)
            {
                Data[A][B] = scan.next().charAt(0);
            }
        }

        int Lantai = n;

        for(int A = 0; A < n; A++)
        {
            if(Lantai % 2 != 0)
            {
                for(int B = m - 1; B >= 0; B--)
                {
                    System.out.print(Data[A][B] + " ");
                }
            }
            else {
                for(int B = 0; B < m; B++)
                {
                    System.out.print(Data[A][B] + " ");
                }
            }
            Lantai--;
            System.out.println();
        }

    }
}
