package e_commerce;

import e_commerce.domain.Category;
import e_commerce.domain.Product;
import e_commerce.domain.User;
import e_commerce.enums.RoleTypeEnum;
import e_commerce.service.CustomerService;
import e_commerce.service.EnterService;
import e_commerce.service.OwnerService;
import e_commerce.service.impl.CustomerServiceImpl;
import e_commerce.service.impl.EnterServiceImpl;
import e_commerce.service.impl.OwnerServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scInt = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);

    static OwnerService ownerService = new OwnerServiceImpl();
    static CustomerService customerService = new CustomerServiceImpl();
    static EnterService enterService = new EnterServiceImpl();

    public static void main(String[] args) {
        int control;
        User loggedUser = new User();
        while (true) {
            printEnterMenu();
            control = scInt.nextInt();
            if (control == 1) {
                System.out.print("Enter name: ");
                String name = scStr.nextLine();
                System.out.print("Enter password: ");
                String password = scStr.nextLine();
                loggedUser = enterService.register(name, password);
            } else if (control == 2) {
                System.out.print("Enter name: ");
                String name = scStr.nextLine();
                System.out.print("Enter password: ");
                String password = scStr.nextLine();
                loggedUser = enterService.login(name, password);
            }else{
                System.out.println("Try again!");
                break;
            }
            if (loggedUser.getRole().equals(RoleTypeEnum.OWNER)){
                useOwnerService(loggedUser);
            }else if(loggedUser.getRole().equals(RoleTypeEnum.CUSTOMER)){
                useCustomerService(loggedUser);
            }
        }
    }


    public static void useOwnerService(User user) {
        int controller;
        while (true) {
            printOwnerMenu();
            controller = scInt.nextInt();
            switch (controller) {
                case 1 -> {
                    System.out.print("Enter name of new category: ");
                    String categoryName = scStr.nextLine();
                    Category category = new Category(categoryName);
                    ownerService.addCategory(category);
                }
                case 2 -> {
                    System.out.print("Enter id of category: ");
                    int id = scInt.nextInt();
                    System.out.print("Enter new name of category: ");
                    String newName = scStr.nextLine();
                    ownerService.editCategory(ownerService.getCategoryById(id), newName);
                }
                case 3 -> {
                    System.out.print("Enter name of product: ");
                    String name = scStr.nextLine();
                    System.out.print("Enter amount of this product: ");
                    int amount = scInt.nextInt();
                    Product product = new Product(name, amount);
                    ownerService.addProduct(product, amount);
                }
                case 4 -> {
                    System.out.print("Enter name of product: ");
                    String name = scStr.nextLine();
                    Product product = new Product(name);
                    ownerService.deleteProduct(product);
                }
                case 5 -> {
                    ownerService.getAllProducts();
                    System.out.print("Enter id of product: ");
                    int id = scInt.nextInt();
                    System.out.print("Enter new name of product: ");
                    String newName = scStr.nextLine();
                    System.out.print("Enter new amount: ");
                    int amount = scInt.nextInt();
                    ownerService.editProduct(ownerService.getProductById(id), newName, amount);
                }
                case 0 ->{
                    return;
                }
            }
        }
    }

    public static void useCustomerService(User user) {
        int controller;
        while (true) {
            printCustomerMenu();
            controller = scInt.nextInt();
            switch (controller) {
                case 1 -> {
                    System.out.print("Enter id of category: ");
                    int id = scInt.nextInt();
                    customerService.seeAllProductsByCategory(ownerService.getCategoryById(id));
                }
                case 2 -> {
                    customerService.getAllProducts();
                    System.out.print("Enter id of product: ");
                    int id = scInt.nextInt();
                    System.out.print("Enter amount of purchasing product: ");
                    int amount = scInt.nextInt();
                    customerService.purchase(ownerService.getProductById(id), amount);
                }
            }
        }
    }

    public static void printCustomerMenu() {
        System.out.println("""
                1.See all products by category
                2.Purchase product 
                """);
    }

    public static void printOwnerMenu() {
        System.out.println("""
                1.Add category
                2.Edit category
                3.Add product
                4.Delete Product
                5.Edit Product 
                0.Exit
                """);
    }

    public static void printEnterMenu() {
        System.out.println("""
                1.Register
                2.Log in 
                """);
    }


}