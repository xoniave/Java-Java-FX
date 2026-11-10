package SEMESTER_2.LES.PBO_Basic.Account;

public class MainAcc {
    public static void main(String[] args) {
        ACCOUNT A1 = new ACCOUNT(1972, 10000);
        ACCOUNT A2 = new ACCOUNT(1923,0);

        A1.transferTo(5000,A2);
        System.out.println(A1.toString());
        System.out.println(A2.toString());
    }
}

class ACCOUNT{
    private int number;
    private double balance = 0.0;

    public ACCOUNT(int number)
    {
        this.number = number;
    }

    public ACCOUNT(int number, double balance)
    {
        this.number = number;
        this.balance = balance;
    }

    public int getNumber() {
        return this.number;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public String toString()
    {
        return "SEMESTER_2.LES.PBO.Account [" + getNumber() + "," + getBalance() + "]";
    }

    public void credit(double amount)
    {
        this.balance += amount;
    }

    public void debit(double amount)
    {
        if(this.balance > amount)
        {
            this.balance -= amount;
        }
        else {
            System.out.println("Amount exceeded");
        }
    }

    public void transferTo(double amount, ACCOUNT akun)
    {
        if(this.balance > amount)
        {
            this.balance -= amount;
            akun.credit(amount);
        }
        else
        {
            System.out.println("Amount exceeded");
        }
    }

}
