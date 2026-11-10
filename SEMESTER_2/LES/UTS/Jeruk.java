package SEMESTER_2.LES.UTS;

public class Jeruk {
    private static int[] Diameter = {0,0,0,0,0};

    public void SetJmlh(int dim,int jmlh)
    {
        if(dim == 5)
        {
            Diameter[0] += jmlh;
        }
        else if(dim == 6)
        {
            Diameter[1] += jmlh;
        }
        else if(dim == 7)
        {
            Diameter[2] += jmlh;
        }
        else if(dim == 7.5)
        {
            Diameter[3] += jmlh;
        }
        else if(dim == 8)
        {
            Diameter[4] += jmlh;
        }
    }

    public String toString()
    {
        return
        "Total Jeruk Berdiamter 5 cm adalah " + Diameter[0] + " buah \n" +
        "Total Jeruk Berdiamter 6 cm adalah " + Diameter[1] + " buah \n" +
        "Total Jeruk Berdiamter 7 cm adalah " + Diameter[2] + " buah \n" +
        "Total Jeruk Berdiamter 7.5 cm adalah " + Diameter[3] + " buah \n" +
        "Total Jeruk Berdiamter 8 cm adalah " + Diameter[4] + " buah \n";
    }
}
