package e_commerce.service.impl;

import e_commerce.domain.Category;
import e_commerce.domain.Product;
import e_commerce.domain.User;
import e_commerce.enums.RoleTypeEnum;
import e_commerce.service.OwnerService;

import static e_commerce.service.CustomerService.USERS;

public class OwnerServiceImpl implements OwnerService {
    {
     USERS.add(new User("Xasan","09102006", RoleTypeEnum.OWNER));
    }

    @Override
    public Product getProductById(Integer id) {
        for (Product product:PRODUCTS) {
            if (product.getId().equals(id)){
                return product;
            }
        }return null;
    }

    @Override
    public void showAllCategories() {
        for (Category category:CATEGORIES) {
            System.out.println(category.getId() + " -id : " + category.getCategoryName());
        }
    }

    @Override
    public void getAllProducts() {
        for (Product product:PRODUCTS) {
            System.out.println(product);
        }
    }

    @Override
    public Category getCategoryById(Integer id) {
        for (Category category:CATEGORIES) {
            if (category.getId().equals(id)){
                return category;
            }
        } return null;
    }

    @Override
    public void addCategory(Category category) {
        for (Category category1 : CATEGORIES) {
            if (category1.getCategoryName().equals(category.getCategoryName())) {
                System.out.println("There exists such category!");
                return;
            }
        }
        CATEGORIES.add(category);
        System.out.println("Success");
    }

    @Override
    public void editCategory(Category category, String newName) {
        for (Category category1 : CATEGORIES) {
            if (category1.getId().equals(category.getId())) {
                category1.setCategoryName(newName);
                System.out.println("Success!");
            }
        }
    }

    @Override
    public boolean addProduct(Product product, int amount) {
        for (Product product1 : PRODUCTS) {
            if (product1.getName().equals(product.getName())) {
                System.out.println("There exists such product already!");
                return false;
            }
        }
        PRODUCTS.add(product);
        product.setRemain(amount);
        return true;
    }

    @Override
    public boolean deleteProduct(Product product) {
        if (!(product.getName() == null)) {
            PRODUCTS.remove(product);
            System.out.println("Success");
            return true;
        }
        return false;
    }

    @Override
    public boolean editProduct(Product product, String newName, Integer newAmount) {
        for (Product product1:PRODUCTS) {
            if (product1.getId().equals(product.getId())){
                product1.setRemain(newAmount);
                product.setName(newName);
                System.out.println("Success!");
                return true;
            }
        }
        System.out.println("Fail");
        return false;
    }
}
