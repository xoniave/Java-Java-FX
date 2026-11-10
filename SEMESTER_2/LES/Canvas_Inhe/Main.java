package SEMESTER_2.LES.Canvas_Inhe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Screen screen = new Screen();

        Point p = new Point(9, 5, '^');
        Vertical v = new Vertical(2, 1, '|', 5);
        Horizontal h = new Horizontal(3,8,'-',5);
        Rectangle r = new Rectangle(0,0,'#',9,19);

        System.out.println("----------------------------------------------");

        p.draw(screen);
        v.draw(screen);
        h.draw(screen);
        r.draw(screen);
        screen.display();
    }
}
