package SEMESTER_2.LES.UTS.Lat_Uts3;

public class mahasiswa {
    private String nrp,nama,id_buku;
    private boolean status;

    public mahasiswa(String nrp, String nama, String id_buku, boolean status) {
        this.nrp = nrp;
        this.nama = nama;
        this.id_buku = id_buku;
        this.status = status;
    }

    public mahasiswa()
    {
        this.nrp = "";
        this.nama = "";
        this.id_buku = "";
        this.status = false;

    }

    public void copy(mahasiswa m)
    {
        this.nrp = m.nrp;
        this.nama = m.nama;
        this.id_buku = m.id_buku;
        this.status = m.status;

    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
