package SEMESTER_2.LES.PBO_Praktik_Week3;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
    Scanner scanint = new Scanner(System.in);
    Scanner scanstr = new Scanner(System.in);
    private ArrayList<Album> DATA_ALBUM = new ArrayList<>();
    private ArrayList<Customer> DATA_CUSTOMER = new ArrayList<>();

    private void AddAlbum()
    {
        Album A = new Album();

        // FILL ALBUM REQUIREMENTS
        System.out.print("Input Title : ");
        A.setTitle(scanstr.nextLine());
        System.out.print("Input Release Year : ");
        A.setRelease_Year(scanint.nextInt());
        System.out.print("Input Price : ");
        A.setPrice(scanint.nextInt());

        System.out.print("Input Artist Name: ");
        String Nama = scanstr.nextLine();
        System.out.print("Input Artist Genre: ");
        String Genre = scanstr.nextLine();
        System.out.print("Input Artist Bio: ");
        String Bio = scanstr.nextLine();

        A.setARTIST(Nama,Genre,Bio);

        DATA_ALBUM.add(A);
    }

    private void RegisterCustomer()
    {
        Customer C = new Customer();

        System.out.print("Input Customer Name : ");
        C.setName(scanstr.nextLine());
        System.out.print("Input Customer Email : ");
        C.setEmail(scanstr.nextLine());

        DATA_CUSTOMER.add(C);
    }

    private void Sell()
    {
        for(int A = 0; A < DATA_ALBUM.size(); A++)
        {
            System.out.println("No : " + A);
            System.out.println(DATA_ALBUM.get(A).toString());
            System.out.println();
        }

        System.out.println("Choose Album >> ");
        int Pilih = scanint.nextInt();

        Transaction T = new Transaction(); //Create object
        System.out.print("Purchase Date : ");
        T.setPurchase_Date(scanstr.nextLine());
        System.out.print("Quantity : ");
        T.setQuantity(scanint.nextInt());

        T.setALBUM(DATA_ALBUM.get(Pilih));
        T.setTotal_Price(T.getQuantity() * DATA_ALBUM.get(Pilih).getPrice());

        //Search Customer
        System.out.println("Masukan Email Customer : ");
        String Email = scanstr.nextLine();

        boolean Ada = false;
        int Idx = 0;
        for(int A = 0; A < DATA_CUSTOMER.size(); A++)
        {
            if(Email.equalsIgnoreCase(DATA_CUSTOMER.get(A).getEmail()))
            {
                Ada = true;
                Idx = A;
                break;
            }
        }

        if(Ada)
        {
            DATA_CUSTOMER.get(Idx).addCollection_Transaction(T);
        }
        else {
            System.out.println("Customer Tidak Ditemukan");
        }
    }

    public void CustomerList()
    {
        for(int A = 0; A < DATA_CUSTOMER.size(); A++)
        {
            System.out.println("No : " + A);
            System.out.println(DATA_CUSTOMER.get(A).toString());
            for(int B = 0; B < DATA_CUSTOMER.get(A).Collection_Transaction.size(); B++)
            {
                System.out.println(DATA_CUSTOMER.get(A).Collection_Transaction.get(B).toString());
            }
            System.out.println();
        }
    }

    public void Menu()
    {
        while (true)
        {
            System.out.println("1.Add Album");
            System.out.println("2.Register Customer");
            System.out.println("3.Sell an Album");
            System.out.println("4.Customer List");
            System.out.println("0.Exit");
            System.out.print(">> ");
            int Pilih = scanint.nextInt();

            if(Pilih == 0)
            {
                break;
            }

            switch (Pilih)
            {
                case 1:
                    AddAlbum();
                    break;
                case 2:
                    RegisterCustomer();
                    break;
                case 3:
                    Sell();
                    break;
                case 4:
                    CustomerList();
                    break;
            }
        }
    }
}
