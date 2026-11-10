package SEMESTER_2.LES.MateriEncapulation;

public class StudentGrade {
    private String NRP,Nama;
    private double UTS,UAS,PRAKTIKUM,Wuts,Wuas,Wpraktikum;

    public String getNRP() {
        return NRP;
    }

    public void setNRP(String NRP) {
        this.NRP = NRP;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public double getUTS() {
        return UTS;
    }

    public void setUTS(double UTS) {

        if(UTS < 0)
        {
            this.UTS = 0;
        }
        else if(UTS > 100)
        {
            this.UTS = 100;
        }
        else
        {
            this.UTS = UTS;
        }
    }

    public double getUAS() {
        return UAS;
    }

    public void setUAS(double UAS) {
        if(UAS < 0)
        {
            this.UAS = 0;
        }
        else if(UAS > 100)
        {
            this.UAS = 100;
        }
        else
        {
            this.UAS = UAS;
        }
    }

    public double getPRAKTIKUM() {
        return PRAKTIKUM;
    }

    public void setPRAKTIKUM(double PRAKTIKUM) {
        if(PRAKTIKUM < 0)
        {
            this.PRAKTIKUM = 0;
        }
        else if(PRAKTIKUM > 100)
        {
            this.PRAKTIKUM = 100;
        }
        else
        {
            this.PRAKTIKUM = PRAKTIKUM;
        }
    }

    public double getWuts() {
        return Wuts;
    }

    public void setWuts(double wuts) {
        if(Wuts <= 0)
        {
            this.Wuts = 0;
        }
        else if(Wuts >= 1)
        {
            this.Wuts = 1;
        }
        else {
            this.Wuts = wuts;
        }
    }

    public double getWuas() {
        return Wuas;
    }

    public void setWuas(double wuas) {
        if(Wuas <= 0)
        {
            this.Wuas = 0;
        }
        else if(Wuas >= 1)
        {
            this.Wuas = 1;
        }
        else {
            this.Wuas = wuas;
        }
    }

    public double getWpraktikum() {
        return Wpraktikum;
    }

    public void setWpraktikum(double wpraktikum) {
        if(Wpraktikum <= 0)
        {
            this.Wpraktikum = 0;
        }
        else if(Wpraktikum >= 1)
        {
            this.Wpraktikum = 1;
        }
        else {
            this.Wpraktikum = wpraktikum;
        }
    }

    public double getNilaiAkhir()
    {
        return ((Wuts * UTS) + (Wuas * UAS) + (Wpraktikum * PRAKTIKUM));
    }

}
