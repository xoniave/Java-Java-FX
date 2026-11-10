package SEMESTER_2.LES.PBO_Praktik_Week3;

public class Album {
    private String Title;
    private int Release_Year,Price;
    private Artist ARTIST = new Artist();

    public Album()
    {
        this.Title = "";
        this.Release_Year = 0;
        this.Price = 0;
    }

    public Album(String Title,int Ry, int P)
    {
        this.Title = Title;
        this.Release_Year = Ry;
        this.Price = P;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getRelease_Year() {
        return Release_Year;
    }

    public void setRelease_Year(int release_Year) {
        Release_Year = release_Year;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setARTIST(String Name,String Genre,String Bio) {
        this.ARTIST.setName(Name);
        this.ARTIST.setGenre(Genre);
        this.ARTIST.setBio(Bio);
    }

    public String toString()
    {
        return  "Title : " + getTitle() + "\n" +
                this.ARTIST.toString() + "\n" +
                "Release Year : " +getRelease_Year() + "\n" +
                "Price : " + getPrice();
    }
}
