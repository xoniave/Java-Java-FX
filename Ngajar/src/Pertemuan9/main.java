package Pertemuan9;

public class main {
    public static void main(String[] args) {
        //ini Anonymus
        Test T = new Test() {
            @Override
            public void run() {
                System.out.println("lol");
            }
        };
        T.run();

        //ini lambda
        Test T1 = () -> System.out.println("lambda");
        T1.run();

        //Generic
        Hitung<String> kalimat = new Hitung<>("halo");
        System.out.println(kalimat.getTemporarry());

        Hitung<Integer> angka = new Hitung<>(1);
        System.out.println(kalimat.getTemporarry());
    }
}
