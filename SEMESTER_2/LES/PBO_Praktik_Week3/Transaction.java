package SEMESTER_2.LES.PBO_Praktik_Week3;

public class Transaction {
    private Album ALBUM;
    private int Quantity,Total_Price;
    private String Purchase_Date;

    public Transaction()
    {
        this.ALBUM = new Album();
        this.Quantity = 0;
        this.Total_Price = 0;
        this.Purchase_Date = "";
    }

    public Transaction(Album ALBUM, int Q,int TP, String PD)
    {
        this.ALBUM = ALBUM;
        this.Quantity = Q;
        this.Total_Price = TP;
        this.Purchase_Date = PD;
    }
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(int total_Price) {
        Total_Price = total_Price;
    }

    public String getPurchase_Date() {
        return Purchase_Date;
    }

    public void setPurchase_Date(String purchase_Date) {
        Purchase_Date = purchase_Date;
    }

    public void setALBUM(Album ALBUM) {
        this.ALBUM = ALBUM;
    }

    public String toString()
    {
        return this.ALBUM.toString() + "\n" +
                "Quantity : " + getQuantity() + "\n" +
                "Purchase Date : " + getPurchase_Date() + "\n" +
                "Total_Price : " + getTotal_Price();
    }
}
