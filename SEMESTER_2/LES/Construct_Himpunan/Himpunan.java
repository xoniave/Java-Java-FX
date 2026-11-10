package SEMESTER_2.LES.Construct_Himpunan;

import java.util.ArrayList;

public class Himpunan {
    private ArrayList<Integer> lst = new ArrayList<>();

    public Himpunan() {
        this.lst = new ArrayList<>();
    }

    public Himpunan(ArrayList<Integer> luar){
        this.lst = new ArrayList<>(luar);
    }

    public Himpunan(int[] Luar){
        for(int A = 0; A < Luar.length; A++)
        {
            this.lst.add(Luar[A]);
        }
    }

    public Himpunan(int sebuahBil){
        this.lst.add(sebuahBil);
    }

    public Himpunan (Himpunan lain){
        this.lst = new ArrayList<>(lain.lst);
    }

    public Himpunan appendHimpunan(Himpunan B){
        Himpunan Copy = new Himpunan(this.lst);

        for(int A = 0; A < B.lst.size(); A++)
        {
            Copy.lst.add(B.lst.get(A));
        }

        return Copy;
    }

    public Himpunan uniqueHimpunan(){
        Himpunan Tampung = new Himpunan();

        for (int A = 0; A < this.lst.size(); A++)
        {
            if(!Tampung.lst.contains(this.lst.get(A)))
            {
                Tampung.lst.add(this.lst.get(A));
            }
        }

        return Tampung;
    }

    public Himpunan minusHimpunan(Himpunan B){
        Himpunan Tampung = new Himpunan();

        for(int A= 0; A < this.lst.size(); A++)
        {
            if(!B.lst.contains(this.lst.get(A)))
            {
                Tampung.lst.add(this.lst.get(A));
            }
        }
        return Tampung;
    }

    public void display(){
        System.out.println(lst);
    }

}
