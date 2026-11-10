package SEMESTER_2.LES.PBO_Basic.PBO_Re;

public class CALLTEST {
    public static void main(String[] args) {
        Time T = new Time();
        InoviceItem I = new InoviceItem();
        Employee E = new Employee();
        MyDate MD = new MyDate();

        //TIME
        T = new Time(1,60,60);
        T.nextSecond();
        T.nextMinute();
        System.out.println(T);

        //INOVICE ITEM
        I = new InoviceItem("001","Bahan berbahaya",1,100000);
        I.increaseQty();
        I.increaseUnitPrice(20000);
        System.out.println(I);

        //EMPLOYEE
        E = new Employee(001,"Klarisza","Jesselyn",10000);
        System.out.println(E.getAnnualsalary());

        //MYDATE
        MD = new MyDate(31,12,2024);
        MD.increaseDay();
        System.out.println(MD);
    }
}
