package SEMESTER_2.LES.PR_Encapsulation;

public class MYDATE {
    private int Day,Month,Year;

    public MYDATE()
    {
        this.Day = 1;
        this.Month = 1;
        this.Year = 1900;
    }

    public MYDATE(int Day, int Month, int Year)
    {
        this.Day = Day;
        this.Month = Month;
        this.Year = Year;
    }

    public boolean GetLeapYear()
    {
        if(getYear() % 400 == 0)
        {
            return true;
        }
        else
        {
            if(getYear() % 100 == 0)
            {
                return true;
            }
            else {
                if(getYear() % 4 == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int getMaxDay(int Month)
    {
        if(Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12)
        {
            return 31;
        }
        else if (Month == 2){
            if(GetLeapYear())
            {
                return 29;
            }
            else {
                return 28;
            }
        }
        return 30;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        if(day > getMaxDay(this.Month))
        {
            this.Day = getMaxDay(this.Month);
        }
        else {
            Day = day;
        }
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {

        if(month >= 1 && month <= 12)
        {
            Month = month;

            if(this.Day > getMaxDay(this.Month))
            {
                this.Day = getMaxDay(this.Month);
            }

        }
        else {
            System.out.println("month hanya boleh di antara 1 - 12");
        }
    }

    public void addDays(int d)
    {
        this.Day += d;
        setDay(this.Day);
    }

    public void addMonth (int m)
    {
        this.Month += m;
        setMonth(this.Month);
    }


    public int getYear() {
        return Year;
    }

    public void setYear(int year) {

        if(Year < 0)
        {
            System.out.println("year hanya boleh >= 0");
        }
        else {
            Year = year;
        }
    }
}
