package SEMESTER_2.LES.Interface1_Les;

public abstract class MenuItem implements inter {
    protected int menuNum;
    protected String menuStr;

    public MenuItem(int menuNum,String menuStr)
    {
        this.menuNum = menuNum;
        this.menuStr = menuStr;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public void setMenuNum(int menuNum) {
        this.menuNum = menuNum;
    }

    public String getMenuStr() {
        return menuStr;
    }

    public void setMenuStr(String menuStr) {
        this.menuStr = menuStr;
    }

    

}
