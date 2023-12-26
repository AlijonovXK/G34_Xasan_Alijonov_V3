package e_commerce.domain;

import e_commerce.enums.RoleTypeEnum;

public class User {
    public int sequence = 0;
    {
        sequence++;
    }
    private Integer id=sequence;

    private String name;
    private String password;
    private RoleTypeEnum role;

    public RoleTypeEnum getRole() {
        return role;
    }

    public void setRole(RoleTypeEnum role) {
        this.role = role;
    }

    public User(String name, String password, RoleTypeEnum role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
