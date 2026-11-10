package SEMESTER_2.LES.Construct_Himpunan;

public class main {
    public static void main(String[] args) {
        Himpunan A = new Himpunan();
        Himpunan B = new Himpunan(new int[]{1,2,3,4,3,3,2});
        Himpunan C = new Himpunan(10);

        A.display();

        Himpunan D = A.appendHimpunan(B).appendHimpunan(C);

        D.display();

        Himpunan E = B.uniqueHimpunan();

        E.display();
    }
}
