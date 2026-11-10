class Buku {
    String judul;
    int harga;
    Penerbit penerbit;

    // Constructor biasa
    Buku(String judul, int harga, Penerbit penerbit) {
        this.judul = judul;
        this.harga = harga;
        this.penerbit = penerbit;
    }

    // Copy Constructor (Deep Copy)
    Buku(Buku b) {
        this.judul = b.judul;
        this.harga = b.harga;
        this.penerbit = new Penerbit(b.penerbit);
    }

    // Method overloading - Display biasa
    void display() {
        System.out.println("Judul      : " + judul);
        System.out.println("Harga      : " + harga);
        System.out.println("Penerbit   : " + penerbit.namaPenerbit);
    }

    // Method overloading - Display dengan diskon
    void display(double diskon) {
        int hargaDiskon = (int) (harga - (harga * diskon / 100));
        System.out.println("Judul      : " + judul);
        System.out.println("Harga      : " + hargaDiskon);
        System.out.println("Penerbit   : " + penerbit.namaPenerbit);
    }

    // Static Inner Class
    static class Penerbit {
        String namaPenerbit;

        Penerbit(String namaPenerbit) {
            this.namaPenerbit = namaPenerbit;
        }

        // Copy Constructor Penerbit
        Penerbit(Penerbit p) {
            this.namaPenerbit = p.namaPenerbit;
        }
    }
}