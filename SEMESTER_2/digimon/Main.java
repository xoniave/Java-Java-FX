package SEMESTER_2.digimon;

public class Main {
    public static void main(String[] args) {

        System.out.print("Masukan Nama Player : ");
        SISTEM.P.setNama(SISTEM.ScanStr.nextLine());

        SISTEM S = new SISTEM();
        S.Game();
    }
}
