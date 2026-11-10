package SEMESTER_2.LES.PBO_Basic.PBO_Re;

public class Time {
    private int hour,minute,second;

    public Time()
    {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute,int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour()
    {
        return this.hour;
    }

    public int getMinute()
    {
        return this.minute;
    }

    public int getSecond()
    {
        return this.second;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    public void setSecond(int second)
    {
        this.second = second;
    }

    public void nextHour()
    {
        if(this.hour == 23) {
            this.hour = 0;
        } else {
            this.hour++;
        }
    }

    public void nextMinute()
    {
        if(this.minute == 60) {
            nextHour();
            this.minute = 0;
        } else {
            this.minute++;
        }
    }

    public void nextSecond() {
        if (this.second == 60) {
            nextMinute();
            this.second = 0;
        } else {
            this.second++;
        }
    }

    public void prevHour()
    {
        if(this.hour == 0) {
            this.hour = 23;
        } else {
            this.hour--;
        }
    }

    public void prevMinute()
    {
        if(this.minute == 0) {
            prevHour();
            this.minute = 60;
        } else {
            this.minute--;
        }
    }

    public void prevSecond()
    {
        if (this.second == 0) {
            prevMinute();
            this.second = 60;
        } else {
            this.second--;
        }
    }

    public String toString()
    {
        return getHour() + " : " + getMinute() + " : " + getSecond();
    }
}
