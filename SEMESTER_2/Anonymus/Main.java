package SEMESTER_2.Anonymus;

public class Main {

    public static Pembayaran FungsiEWallet(String Methode)
    {
        Pembayaran Ewallet = new Pembayaran() {
            @Override
            public void proses(double jumlah) {
                System.out.println("[E-WALLET] Pembayaran $" + jumlah + " menggunakan OTP. (Provider: " + Methode + ")");
            }
        };
        return Ewallet;
    }

    public static void main(String[] args) {

        //BANK
        Pembayaran Valid = new Bank();
        Valid.proses(500);


        // Wallet
        Pembayaran GOPAY = FungsiEWallet("GO PAY");
        GOPAY.proses(150);
        Pembayaran OVO = FungsiEWallet("OVO");
        OVO.proses(75);

        //crypto
        Pembayaran crypto = (x) -> System.out.println("[CRYPTO] Membeli $" + x + " dalam Bitcoin.");
        crypto.proses(250);

    }
}
