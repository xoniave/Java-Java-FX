package SEMESTER_2.Anonymus;

public class Bank implements Pembayaran{

    @Override
    public void proses(double jumlah) {
        if(jumlah <= 0)
        {
            System.out.println("Harus positif");
        }
        System.out.println("[BANK] Transfer sebesar $" + jumlah +"diproses");
    }
}
