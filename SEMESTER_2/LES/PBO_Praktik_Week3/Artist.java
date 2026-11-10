package SEMESTER_2.LES.PBO_Praktik_Week3;

public class Artist {
    private String Name,Genre,Bio;

    public Artist()
    {
        this.Name = "";
        this.Genre = "";
        this.Bio = "";
    }

    public Artist(String Name,String genre,String Bio)
    {
        this.Name = Name;
        this.Genre = genre;
        this.Bio = Bio;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public String toString()
    {
        return "Artist Name : " + getName() + "\n" + "Genre : " + getGenre() + "\n" + "Bio : " + getBio();
    }

}
