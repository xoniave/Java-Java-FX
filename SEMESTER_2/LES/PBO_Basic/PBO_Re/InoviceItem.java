package SEMESTER_2.LES.PBO_Basic.PBO_Re;

public class InoviceItem {
    private String id,desc;
    private int qty;
    private double unitPrice;

    public InoviceItem()
    {
        this.id = "";
        this.desc = "";
        this.qty = 0;
        this.unitPrice = 0.0;
    }

    public InoviceItem(String id, String desc, int qty, double unitPrice)
    {
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getId()
    {
        return this.id;
    }

    public String getDesc()
    {
        return this.desc;
    }

    public int getQty()
    {
        return this.qty;
    }

    public double getUnitPrice()
    {
        return this.unitPrice;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public void increaseQty()
    {
        this.qty++;
    }

    public void increaseUnitPrice(int Tambah)
    {
        setUnitPrice(getUnitPrice() + Tambah);
    }

    public void decreaseQty()
    {
        if(qty > 0)
        {
            this.qty--;
        }
    }

    public void decreaseUnitPrice(int Kurang)
    {
        if(this.unitPrice > 0)
        {
            if(this.unitPrice - Kurang < 0)
            {
                this.unitPrice = 0;
            }
            else
            {
                setUnitPrice(getUnitPrice() - Kurang);
            }
        }
    }

    public String toString()
    {
        return getId() + " - " + getDesc() + " - " + getQty() + " - " + getUnitPrice();
    }
}
