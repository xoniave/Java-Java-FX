package SEMESTER_2.LES.Interface1_Les;

import java.util.ArrayList;

public class MenuManager {

    ArrayList<MenuItem> Data_MenuItem = new ArrayList<>();

    public MenuManager()
    {

    }

    void addMenuItem(MenuItem m)
    {
        Data_MenuItem.add(m);
    }

    void processMenu()
    {
        while (true)
        {
            System.out.println("Menu");
            for(int A = 0; A < Data_MenuItem.size(); A++)
            {
                System.out.println(Data_MenuItem.get(A));
            }
        }
    }
}
