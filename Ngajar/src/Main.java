import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data awal default
        Buku buku = new Buku("Laskar Pelangi", 85000, new Buku.Penerbit("Gramedia"));

        int pilihan;

        do {
            System.out.println("\n===== MENU BUKU =====");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Input Buku");
            System.out.println("3. Deep Copy");
            System.out.println("4. Tampilkan Buku Dengan Diskon");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== DATA BUKU ===");
                    buku.display();
                    break;

                case 2:
                    System.out.print("\nInput Judul Buku     : ");
                    buku.judul = input.nextLine();

                    System.out.print("Input Harga Buku     : ");
                    buku.harga = input.nextInt();
                    input.nextLine();

                    System.out.print("Input Nama Penerbit  : ");
                    buku.penerbit.namaPenerbit = input.nextLine();

                    System.out.println("\nData buku berhasil diinput.");
                    break;

                case 3:
                    Buku copyBuku = new Buku(buku); // Deep Copy

                    System.out.print("\nInput Penerbit Buku Copy: ");
                    String penerbitBaru = input.nextLine();

                    copyBuku.penerbit.namaPenerbit = penerbitBaru;

                    System.out.println("\nBuku Awal");
                    buku.display();

                    System.out.println("\nCopy Buku");
                    copyBuku.display();
                    break;

                case 4:
                    System.out.print("\nInput Diskon : ");
                    double diskon = input.nextDouble();

                    System.out.println();
                    buku.display(diskon);
                    break;

                case 5:
                    System.out.println("\nProgram selesai.");
                    break;

                default:
                    System.out.println("\nPilihan tidak valid.");
            }

        } while (pilihan != 5);

        input.close();
    }
}