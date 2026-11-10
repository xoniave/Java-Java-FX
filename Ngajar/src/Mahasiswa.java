class Mahasiswa {
    String nama;
    int umur;
    Alamat alamat;

    public Mahasiswa() {
        this.nama = "";
        this.umur = 0;
        this.alamat = new Alamat("");
    }

    Mahasiswa(String nama, int umur, Alamat alamat) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }


    Mahasiswa(Mahasiswa m) {  // INI namanya Overloading (Nama Fungsi sama cmn beda parameter)  , Lalu ini di sebut juga Copy Contruct karena dia tugasnya COPY dengen menerima Object sebagai Parameternya
        this.nama = m.nama;
        this.umur = m.umur;
        this.alamat = new Alamat(m.alamat);  // Ini Deep Copy  -- kalau ini 1 berubah yang spurce asli tidak berubah
        //this.alamat = m.alamat;           // Ini Shallow Copy -- kalau ini 1 berubah semua berubah

        /* PENJELESAN MENGENAI DEEP DAN SHALLOW

        DI main kan ada Mahasiswa m2 = new Mahasiswa(m1);

        Nah codingan ini berfungsi untuk mengambil data m1 dan di masukan/assign ke data m2 melalui this.nama dll

        Yang menjadi masalah adalah --> di dalam class Mahasiswa ada data object Alamat

        // SHALLOW COPY
        Saat kalian this.alamat = m.alamat --> maka dalam kasus ini isi Alamat m2(this.alamat(m2) = m.alamat(m1)) skrg adalah (address) dari Alamat m1 bukan (isi Alamat) m1
        karena dia(m.alamat / m1) mengirim address massuk ke data m2 menyebabkan ketika Alamat m2 di ubah, Alamat m1 juga ikut terubah ISINya

        //DEEP COPY
        Nah kalau yang this.alamat = new Alamat(m.alamat) --> seperti yang di jelaskan di atas dia itu ngirim nya Addres bukan isi...
                                     jadi untuk mengcounter itu lebih baik di new Alamat() dan mengisi new Alamat() tersebut dengan data isi Alamat m1
                                     Jadi kalau m2 di ubah maka m1 akan aman aman saja karena m2 punya Address sendiri


         CONTOH VISUAL

         //Shallow Copy

         M1.Alamat   ---\
                           Address --> isi alamat ("Surabaya")
         M2.Alamat   ---/


         Sehingga kalau M2.Alamat di ubah maka M1 ikut juga


         //DEEP Copy

         M1.Alamat --\ -- Address --> isi alamat ("Surabaya")
                      \
                       -------\ (kirim data alamat)   btw ini opsional gk harus isi new Alamat pakai data m1...
                               ----\ kamus kasih "none gpp juga" cuman karena ini Mengcopy jadi sekalian di copy
                                    \
         M2.Alamat --new Alamat(M1.Alamat atau "None") --> Address --> isi alamat("Surabaya")


        Sehingga kalau M2.Alamat di ubah maka M1 TIDAK berubah soalnya punya Adress sendiri2



        Note* = KALO BINGUNG Adress itu apa sih

        kalau di belakang layar coding misal kalian bikin variable int Nama

        maka Komputer akan menyimpan   Nama di Adress Random  Contoh = #2*93)9090

        Misal Komputer memanggil #2*93)9090 maka nanti muncul variable --> Nama

        singkatnya gtu .... ini terjadi di blkg layar tidak perlu tau detail plg tidak loginya paham


        Kalo kalian baca sampe sini brarti niat belajar dua point buat kalian tulis +2 di comment pas kumpulin

        KALAU SEMUA PENJELASAN INI KALIAN GK PAHAM.... SAMPEKNO AKU GTW MAU NJELASIN GMN LGI --> CHAT AKU / JAHE  no wa ada di gclassroom
         */
    }

     static class Alamat {   // INI STATIC INNER CLASS (BAsically Class dalam Class), untuk mengakses maka sepert static variable umumnya jadi Mahasiswa.Alamat
        String kota;

        Alamat(String kota) {
            this.kota = kota;
        }

        // Copy constructor
        Alamat(Alamat a) {
            this.kota = a.kota;
        } // ini menerima object alamat
    }
}