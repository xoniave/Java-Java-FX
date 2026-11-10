package SEMESTER_1.UAS;
import java.io.*;
import java.util.*;
public class userPass {
    public static Scanner scanint = new Scanner(System.in);
    public static Scanner scanstr = new Scanner(System.in);

    public static void LoginAkun(File file1, File file2) {
        System.out.print("Username : ");
        String CUser = scanstr.nextLine();
        System.out.print("Password : ");
        String CPass = scanstr.nextLine();

        boolean Ada = false;
        try {
            Scanner scanf1 = new Scanner(file1);
            Scanner scanf2 = new Scanner(file2);
            while (scanf1.hasNextLine()) {
                String User = scanf1.nextLine();
                String Pass = scanf2.nextLine();
                if(User.equalsIgnoreCase(CUser) && Pass.equalsIgnoreCase(CPass)){
                    Ada = true;
                }
            }
            scanf1.close();
            scanf2.close();
            if(Ada){
                System.out.println("Berhasil LOGIN");
            }
            else {
                System.out.println("Tidak Di temukan");
            }
        }
        catch (IOException e) {
            System.out.println("Eror : " + e.getMessage());
        }
    }
    public static void DaftarAkun() {
        try{
            FileWriter Fw1 = new FileWriter("Username.txt",true);
            FileWriter Fw2 = new FileWriter("Password.txt",true);

            System.out.print("Username : ");
            Fw1.append(scanstr.nextLine()).append("\n");
            System.out.print("Password : ");
            Fw2.append(scanstr.nextLine()).append("\n");

            Fw1.close();
            Fw2.close();
        }
        catch (IOException e) {
            System.out.println("Eror : ");
        }
    }

    public static void main(String[] args) {
        File file1 = new File("Username.txt");
        File file2 = new File("Password.txt");
        boolean Loop = true;

        while(Loop) {
            System.out.println("1. Login Akun");
            System.out.println("2. Daftar Akun");
            System.out.println("3. Exit");
            System.out.print("Pilih : ");
            switch (scanint.nextInt()) {
                case 1:
                    LoginAkun(file1,file2);
                    break;
                case 2:
                    DaftarAkun();
                    break;
                case 3:
                    Loop = false;
                    break;
            }
        }
    }
}
