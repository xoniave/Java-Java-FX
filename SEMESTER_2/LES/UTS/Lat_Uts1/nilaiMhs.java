package SEMESTER_2.LES.UTS.Lat_Uts1;

public class nilaiMhs {
    private String namaMK,grade;
    private int sks,semester;

    public nilaiMhs()
    {
        this.namaMK = "";
        this.grade = "";
        this.sks = 0;
        this.semester = 1;
    }

    public nilaiMhs(String namaMK, String grade,int sks,int semester)
    {
        this.namaMK = namaMK;
        this.grade = grade;
        this.sks = sks;
        this.semester = semester;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
