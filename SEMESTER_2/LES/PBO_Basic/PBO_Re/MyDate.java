package SEMESTER_2.LES.PBO_Basic.PBO_Re;

public class MyDate {
    private int day,month,year;

    public MyDate()
    {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public MyDate(int day,int month,int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay()
    {
        return this.day;
    }

    public int getMonth()
    {
        return this.month;
    }

    public int getYear()
    {
        return this.year;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setCompleteDate(int day,int month,int year)
    {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void increaseDay()
    {
        if(getDay() == 31)
        {
            increaseMonth();
            setDay(1);
        }
        else {
            setDay(getDay() + 1);
        }

    }

    public void increaseMonth()
    {
        if(getMonth() == 12)
        {
            increaseYear();
            setMonth(1);
        }
        else {
            setMonth(getMonth() + 1);
        }
    }

    public void increaseYear()
    {
        setYear(getYear() + 1);
    }

    public void decreaseDay()
    {
        if(getDay() == 1)
        {
            decreaseMonth();
            setDay(31); //anggap saja /bln 31
        }
        else {
            setDay(getDay() - 1);
        }
    }

    public void decreaseMonth()
    {
        if(getMonth() == 1)
        {
            decreaseYear();
            setMonth(12);
        }
        else
        {
            setMonth(getMonth() - 1);
        }

    }

    public void decreaseYear()
    {
        setYear(getYear() - 1);
    }

    public String toString()
    {
        return getDay() + " - " + getMonth() + " - " + getYear();
    }
}
