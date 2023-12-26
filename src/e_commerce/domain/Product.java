package e_commerce.domain;

public class Product {
    private String name;
    public int sequence = 0;

    {
        sequence++;
    }

    private Integer id = sequence;
    private Integer remain;

    private Category category;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, Integer id, Integer remain, Category category) {
        this.name = name;
        this.id = id;
        this.remain = remain;
        this.category = category;
    }

    public Product(String name,Integer remain) {
        this.name = name;
        this.remain = remain;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", remain=" + remain +
                ", category=" + category +
                '}';
    }
}

