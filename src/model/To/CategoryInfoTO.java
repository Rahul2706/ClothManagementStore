package model.To;

public class CategoryInfoTO {
    private String categoryid;
    private String categoryname;

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
    public String toString(){
        return categoryname ;
    }

}