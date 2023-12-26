package e_commerce.service.impl;

import e_commerce.domain.Category;
import e_commerce.domain.Product;
import e_commerce.service.CustomerService;

import static e_commerce.service.OwnerService.PRODUCTS;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void getAllProducts() {
        for (Product product:PRODUCTS) {
            System.out.println(product);
        }
    }

    @Override
    public void seeAllProductsByCategory(Category category) {
        for (Product product:PRODUCTS){
           if (product.getCategory().getId().equals(category.getId())){
               System.out.println(product);
           }
        }
    }

    @Override
    public void purchase(Product product, int amount) {
        if (product.getRemain()==0){
            System.out.println("Fail");
            return;
        }
        for (Product product1:PRODUCTS) {
            if (product1.getId().equals(product.getId())){
                if (amount>product1.getRemain()){
                    System.out.println("There only " + product1.getRemain() + " such product");
                    return;
                }
                product1.setRemain(product1.getRemain()-amount);
                System.out.println("You have purchased successfully : " + product.getName() + " -> " + amount);
            }
        }
    }
}
