package e_commerce.service;

import e_commerce.domain.Category;
import e_commerce.domain.Product;
import e_commerce.domain.User;

import java.util.LinkedList;
import java.util.List;

public interface CustomerService {
    List<User> USERS = new LinkedList<>();
    void getAllProducts();
    void  seeAllProductsByCategory(Category category);
    void purchase(Product product,int amount);

}
