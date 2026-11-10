public class Hewan {
    protected String Name;

    public Hewan(){
        this.Name = "";
    }

    public Hewan(String Name){
        this.Name = Name;
    }

    void setName(String Name){
        this.Name = Name;
    }

    void Jalan(){
        System.out.println("Unknown");
    }
}
