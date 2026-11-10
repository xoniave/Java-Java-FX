public class Pertemuan5 {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("RIna",21,new Mahasiswa.Alamat("Sby"));
        Mahasiswa m2 = new Mahasiswa(m1);

        m2.alamat.kota = "JKT";
        System.out.println(m1.nama); // Rina
        System.out.println(m1.umur); // 21
        System.out.println(m1.alamat.kota); // SBY
        System.out.println(m2.nama); // bejo
        System.out.println(m2.umur); // 21
        System.out.println(m2.alamat.kota); // SBY


        /*
        kALAU BINGUNG kenapa bisa m1.alamat.kota

        Di dalam Mahasiswa --> ada Alamat (object) --> dalam Alamat ada Kota

        jadi untuk tau dia dari kota mana aksesnya harus   M1.alamat.kota

         */
    }
}
