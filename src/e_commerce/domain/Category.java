package e_commerce.domain;

public class Category {
    public  int sequence = 0;
    {
        sequence++;
    }
    private Integer id = sequence;
    private String categoryName;

    public Category(String category,Integer id) {
        this.categoryName = category;
        this.id = id;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}