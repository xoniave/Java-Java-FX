package SEMESTER_2.LES.PBO_Basic.PBO_Re;

public class Employee {
    private int id,salary;
    private String firstName,lastname;

    public Employee()
    {
        this.id = 0;
        this.firstName = "";
        this.lastname = "";
        this.salary = 0;
    }

    public Employee(int id, String firstName,String lastname,int salary)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.salary = salary;
    }

    public int getId()
    {
        return this.id;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastname()
    {
        return this.lastname;
    }

    public int getSalary()
    {
        return this.salary;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public int getAnnualsalary()
    {
        return getSalary() * 12;
    }

    public void raiseSalaryInPerson(int tambah)
    {
        setSalary(getSalary() + tambah);
    }

    public String toString()
    {
        return getId() + " - " + getFirstName() + " - " + getLastname() + " - " + getSalary() + " - " + getAnnualsalary();
    }

}
