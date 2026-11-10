package SEMESTER_2.LES.PBO_Basic.Copy;

public class Main {
    public static void main(String[] args) {
        Ortu OR = new Ortu("Adi",55);
        System.out.println(OR);

        Ortu CR = OR;
        System.out.println(CR);

        CR.setAll("Bryan",18);
        System.out.println(OR);
        System.out.println(CR);
    }
}
