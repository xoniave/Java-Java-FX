package SEMESTER_2.PR.PR1;

public class Main {
    public static void main(String[] args) {
        Rumah R1 = new Rumah("Jl. Merpati No. 5");
        R1.Add_Kamar(1,25);
        R1.Add_Kamar(2,20);

        Kamar K1 = R1.getData_Kamar(0);
        Kamar K2 = R1.getData_Kamar(1);

        K1.Add_Perabotan("Tempat Tidur","Kayu");
        K1.Add_Perabotan("Lemari","Besi");

        K2.Add_Perabotan("Meja","Kayu");
        K2.Add_Perabotan("Kursi","Plastik");

        System.out.println(R1);
        K1.Tampilkan();
        K2.Tampilkan();

    }
}
