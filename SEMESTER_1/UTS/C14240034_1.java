import java.util.ArrayList;
import java.util.Scanner;

public class C14240034_1 {
    public static void main(String[] args) {

        //DEKLARASI VARIABLE DAN SCANNER
        Scanner scanstr = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);

        double Celcius = 0;
        String Tekanan,Batuk,Sesak_Napas,Sakit_Tenggorokan,Nyeri_Otot,Sakit_Kepala,Mual,Pengeelihatan_Kabur,Pusing,Diare;
        boolean ada = false;
        ArrayList<String> DATADIAGNOSIS = new ArrayList<>();

        //SYSTEM UNTUK INPUT
        System.out.print("Berapa suhu badan anda ? (Dalam derajat Celcius): ");
        Celcius = scanint.nextDouble();
        System.out.print("Bagaimana Tekanan darah anda ? (rendah/normal/tinggi): ");
        Tekanan = scanstr.nextLine();
        System.out.print("Apakah anda mengalami batuk ? (ya/tidak): ");
        Batuk = scanstr.nextLine();
        System.out.print("Apakah anda mengalami Sesak napas ? (ya/tidak): ");
        Sesak_Napas = scanstr.nextLine();
        System.out.print("Apakah anda mengalami sakit tenggorokan? (ya/tidak) :");
        Sakit_Tenggorokan = scanstr.nextLine();
        System.out.print("Apakah anda mengalami nyeri otot? (ya/tidak) : ");
        Nyeri_Otot = scanstr.nextLine();
        System.out.print("Apakah anda mengalami sakit kepala (ya/tidak) : ");
        Sakit_Kepala = scanstr.nextLine();
        System.out.print("Apakah anda mengalami mual ? (ya/tidak) : ");
        Mual = scanstr.nextLine();
        System.out.print("Apakah anda mengalami pengelihatan kabur? (ya/tidak) : ");
        Pengeelihatan_Kabur = scanstr.nextLine();
        System.out.print("Apakah anda mengalami pusing? (ya/tidak) : ");
        Pusing = scanstr.nextLine();
        System.out.print("Apakah anda mengalami diare? (ya/tidak) : ");
        Diare = scanstr.nextLine();

        //PENGECEKAN TERHADAP PENYAKIT
        //1.Batuk
        if(Batuk.equals("ya") && Sesak_Napas.equals("ya") && Celcius > 37.5 && (Tekanan.equals("normal") || Tekanan.equals("tinggi")))
        {
            DATADIAGNOSIS.add("Pneumonia");
            ada = true;
        }
        if(Batuk.equals("ya") && Sakit_Tenggorokan.equals("ya") && Celcius >= 37 && Celcius <= 37.5)
        {
            DATADIAGNOSIS.add("Flu");
            ada = true;
        }
        if(Batuk.equals("ya") && Nyeri_Otot.equals("ya") && Celcius > 38.5)
        {
            DATADIAGNOSIS.add("Demam Berdarah");
            ada = true;
        }
        if(Sakit_Kepala.equals("ya") && Mual.equals("ya") && Pengeelihatan_Kabur.equals("ya"))  //2. Sakit Kepala dan Mual
        {
            DATADIAGNOSIS.add("Migrain");
            ada = true;
        }
        if(Sakit_Kepala.equals("ya") && Mual.equals("ya") && Pusing.equals("ya") && Tekanan.equals("rendah"))
        {
            DATADIAGNOSIS.add("Vertigo");
            ada = true;
        }
        if(Diare.equals("ya") && Mual.equals("ya") && (Celcius >= 36 && Celcius <= 37.5)) //3. DIare
        {
            DATADIAGNOSIS.add("Keracunan Makanan");
            ada = true;
        }
        if(Diare.equals("ya") && Celcius > 37.5)
        {
            DATADIAGNOSIS.add("infeksi usus");
            ada = true;
        }
        if(!ada) {
            DATADIAGNOSIS.add("Penyakit Tidak Dikenal");
        }

        //mencetak data yang sudah di simpan beserta koma nya
        for(int A = 0; A < DATADIAGNOSIS.size(); A++)
        {
            if(A == DATADIAGNOSIS.size()-1)
            {
                System.out.print(DATADIAGNOSIS.get(A));
            }
            else {
                System.out.print(DATADIAGNOSIS.get(A) + ",");
            }
        }

    }
}