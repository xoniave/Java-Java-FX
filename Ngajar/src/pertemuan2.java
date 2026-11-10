import java.util.ArrayList;
import java.util.Scanner;

public class pertemuan2 {

    public static int TambahAngka(ArrayList<Integer> DataAngka,int x){
        x = x + 1;
        DataAngka.add(1);
        return x;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

//        if(x.equals("manusia")){     // kalau string harus equals kalo nda nanti dia bandingin sama memory
//            System.out.println("manusia");
//        }
//        else if(x.equals("babi")){
//            System.out.println("bukan manusia");
//        }

//        switch (x)   Switch berguna untuk nilai tetap dan bukan logika kompleks kayak 1<10 dst
//        {
//            case 1:
//                System.out.println("aku manusia");
//                break;
//            case 2:
//                System.out.println("aku babi");
//                break;
//            default:
//                System.out.println("nothing");
//        }


/*        for(int A = 0; A == 10; A--){
            System.out.println(A);
        }


        while (true){
            System.out.println("1. Makan");
            System.out.println("2. Minum");
            System.out.println("3. keluar");
            System.out.println("pilih : ");
        }*/
//
//        int B = 10;
//        do{
//            B-=1;
//        }while(B > 0);
//
        ArrayList<Integer> DataAngka = new ArrayList<>();
//
//        if(DataAngka.isEmpty())
//        {
//            System.out.println("ada isinya");
//        }
//
//        //0   1  2  3  4
//        //10 10 10  10 10
//
//        int[][] DataAngkaLama = new int[10][10];

        TambahAngka(DataAngka,x);

    }
}
