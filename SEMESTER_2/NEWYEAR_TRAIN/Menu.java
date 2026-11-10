package SEMESTER_2.NEWYEAR_TRAIN;

public class Menu {
    public static void main(String[] args) {

        SISTEM Sistem_Start = new SISTEM();

        while(true)
        {
            System.out.println("INDO XXI");
            System.out.println("========");
            System.out.println("1. Login");
            System.out.println("2. Exit ");
            System.out.print(">> ");
            int Pilih = SISTEM.scanint.nextInt();

            if(Pilih == 2)
            {
                break;
            }
            else
            {
                System.out.println("Login");
                System.out.println("============");
                System.out.println("Username : ");
                String User = SISTEM.scanstr.nextLine();
                System.out.println("Password : ");
                String Pass = SISTEM.scanstr.nextLine();

                if(User.equalsIgnoreCase("Admin") && Pass.equalsIgnoreCase("Admin"))
                {

                }
                else{
                    for(int A = 0; A < SISTEM.DATA_AKUN.size(); A++)
                    {
                        if(SISTEM.DATA_AKUN.get(A).getUsername().equalsIgnoreCase(User) && SISTEM.DATA_AKUN.get(A).getPassword().equalsIgnoreCase(Pass))
                        {
                            Sistem_Start.PANEL_SISTEM(1);
                        }
                    }
                }

            }
        }
    }
}
