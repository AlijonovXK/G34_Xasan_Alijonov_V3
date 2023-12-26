package e_commerce.service;

import e_commerce.domain.Category;
import e_commerce.domain.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface OwnerService {
    List<Category> CATEGORIES = new LinkedList<>();
    List<Product>PRODUCTS = new LinkedList<>();
    Product getProductById(Integer id);
    void addCategory(Category category);
    Category getCategoryById(Integer id);
    void showAllCategories();
    void  getAllProducts();

    void editCategory(Category category,String newName);

    boolean addProduct(Product product, int amount);

    boolean deleteProduct(Product product);
    boolean editProduct(Product product,String newName,Integer newAmount);
}
