package SEMESTER_2.LES.PBO_Basic.Stock;

public class Main {
    public static void main(String[] args) {
        STOCK ST = new STOCK("R","Bejo",10000,12000);
        System.out.println(ST.getChangepercent() + "%");
    }
}

class STOCK
{
    private String Symbol,Name;
    private float previousClosingPrice,CurrentPrice;

    public STOCK()
    {
        this.Symbol = "";
        this.Name = "";
        this.previousClosingPrice = 0;
        this.CurrentPrice = 0;
    }

    public STOCK(String Symbol,String Name,float PreviousClosingPrice,float CurrentPrice)
    {
        this.Symbol = Symbol;
        this.Name = Name;
        this.previousClosingPrice = PreviousClosingPrice;
        this.CurrentPrice = CurrentPrice;
    }

    public String getSymbol() {
        return Symbol;
    }

    public String getName() {
        return Name;
    }

    public float getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(float previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public float getCurrentPrice() {
        return CurrentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        CurrentPrice = currentPrice;
    }

    public float getChangepercent()
    {
        return ((getCurrentPrice() - getPreviousClosingPrice()) / getPreviousClosingPrice()) * 100;
    }

}
