package SEMESTER_1.UTS;

public class PembagianBuah {

    void Start() {
        int Pilihan,Kelengkeng = 0,Jeruk = 0,Apel = 0,Plastik = 1,Terkecil;

        while (true) {
            System.out.println("1. Masukan Jumlah Buah");
            System.out.println("2. Tampilkan Hasil");
            System.out.println("3.Exit");
            Pilihan = Main.scanint.nextInt();

            if(Pilihan == 3) break;

            switch (Pilihan)
            {
                case 1:
                    System.out.println("Jumlah Buah Kelengkeng : ");
                    Kelengkeng = Main.scanint.nextInt();

                    System.out.println("Jumlah Buah Jeruk : ");
                    Jeruk = Main.scanint.nextInt();

                    System.out.println("Jumlah Buah Apel : ");
                    Apel = Main.scanint.nextInt();

                    if(Kelengkeng < Jeruk && Kelengkeng < Apel)
                    {
                        Terkecil = Kelengkeng;
                    }
                    else if(Jeruk < Kelengkeng && Jeruk < Apel)
                    {
                        Terkecil = Jeruk;
                    }
                    else {
                        Terkecil = Apel;
                    }


                    for(int A = Terkecil; A > 1; A--)
                    {
                        if(Kelengkeng % A == 0 && Jeruk % A == 0 && Apel % A == 0)
                        {
                            Plastik = A;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Plastik : " + Plastik);

                    System.out.println("Kelengkeng : " + (Kelengkeng/Plastik));
                    System.out.println("Jeruk : " + (Jeruk/Plastik));
                    System.out.println("Apel : " + (Apel/Plastik));
                    break;
            }
        }
    }
}
