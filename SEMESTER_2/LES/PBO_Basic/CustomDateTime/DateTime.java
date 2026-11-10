package SEMESTER_2.LES.PBO_Basic.CustomDateTime;

public class DateTime {
    private int Year,Month,Day,Hour,Minute;

    public DateTime()
    {
        setAll(0,0,0,0,0);
    }

    public DateTime(int Year,int Month,int Day,int Hour,int Minute)
    {
        setAll(Year,Month,Day,Hour,Minute);
    }

    public void setAll(int Year,int Month,int Day,int Hour,int Minute)
    {
        this.Year = Year;

        if(Month > 12)
        {
            this.Month = Month % 12;
        }
        if(Day < 1)
        {
            this.Day = 1;
        }
        else if(Day > 31)
        {
            this.Day = 31;
        }
        if(Hour > 23)
        {
            this.Hour = 23;
        }
        else if(Hour < 0) {
            this.Hour = 0;
        }
        if(Minute > 60)
        {
            this.Minute = 60;
        }
        else if(Minute < 0)
        {
            this.Minute = 0;
        }
    }

    public void setDate(int Year,int Month,int Day)
    {
        this.Year = Year;

        if(Month > 12)
        {
            this.Month = Month % 12;
        }
        if(Day < 1)
        {
            this.Day = 1;
        }
        else if(Day > 31)
        {
            this.Day = 31;
        }
    }

    public void setTime(int Hour, int Minute)
    {
        if(Hour > 23)
        {
            this.Hour = 23;
        }
        else if(Hour < 0) {
            this.Hour = 0;
        }
        if(Minute > 60)
        {
            this.Minute = 60;
        }
        else if(Minute < 0)
        {
            this.Minute = 0;
        }
    }

    public boolean isBefore(DateTime Before)
    {
        if (Before.Year < this.Year) {
            return true;
        }
        else if (Before.Year == this.Year)
        {
            if (Before.Month < this.Month)
            {
                return true;
            }
            else if (Before.Month == this.Month)
            {
                if (Before.Day < this.Day)
                {
                    return true;
                }
                else if (Before.Day == this.Day)
                {
                    if (Before.Hour < this.Hour)
                    {
                        return true;
                    }
                    else if (Before.Hour == this.Hour)
                    {
                        return Before.Minute < this.Minute;
                    }
                }
            }
        }

        return false;
    }

    public boolean isAfter(DateTime After)
    {
        if (After.Year > this.Year) {
            return true;
        }
        else if (After.Year == this.Year)
        {
            if (After.Month > this.Month)
            {
                return true;
            }
            else if (After.Month == this.Month)
            {
                if (After.Day > this.Day)
                {
                    return true;
                }
                else if (After.Day == this.Day)
                {
                    if (After.Hour > this.Hour) {
                        return true;
                    } else if (After.Hour == this.Hour) {
                        return After.Minute > this.Minute;
                    }
                }
            }
        }
        return false;
    }

}
