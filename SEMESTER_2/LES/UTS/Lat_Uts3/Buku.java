package SEMESTER_2.LES.UTS.Lat_Uts3;

public class Buku {
    private String id,nama_buku;

    public Buku()
    {
        this.id = "";
        this.nama_buku = "";
    }

    public Buku(String id, String nama_buku)
    {
        this.id = id;
        this.nama_buku = nama_buku;
    }

    public void copy(Buku b)
    {
        this.id = b.id;
        this.nama_buku = b.nama_buku;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_buku() {
        return nama_buku;
    }

    public void setNama_buku(String nama_buku) {
        this.nama_buku = nama_buku;
    }
}
