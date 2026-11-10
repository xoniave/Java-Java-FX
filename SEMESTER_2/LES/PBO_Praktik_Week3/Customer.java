package SEMESTER_2.LES.PBO_Praktik_Week3;

import java.util.ArrayList;

public class Customer {
    private String Name,Email;
    ArrayList<Transaction> Collection_Transaction = new ArrayList<>();

    public Customer()
    {
        this.Name = "";
        this.Email = "";
    }

    public Customer(String Nama, String Email)
    {
        this.Name = Nama;
        this.Email = Email;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void addCollection_Transaction(Transaction transaction)
    {
        Collection_Transaction.add(transaction);
    }

    public String toString()
    {
        return  "Nama : " + getName() + "\n" +
                "Email : " + getEmail() + "ALBUM : \n";
    }
}
