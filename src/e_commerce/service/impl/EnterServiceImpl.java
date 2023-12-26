package e_commerce.service.impl;

import e_commerce.domain.User;
import e_commerce.enums.RoleTypeEnum;
import e_commerce.service.EnterService;

import static e_commerce.service.CustomerService.USERS;

public class EnterServiceImpl implements EnterService {
    @Override
    public User register(String name, String password) {
        User user = new User(name, password);
        USERS.add(user);
        user.setRole(RoleTypeEnum.CUSTOMER);
        return user;
    }

    @Override
    public User login(String name, String password) {
        User userByNameAndPassword = getUserByNameAndPassword(name, password);
        if (userByNameAndPassword.getRole().equals(RoleTypeEnum.OWNER)){
            return userByNameAndPassword;
        }
        for (User user : USERS) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                System.out.println("Logged in  successfully!");
                user.setRole(RoleTypeEnum.CUSTOMER);
                return user;
            }
        }
        System.out.println("Fail!");
        return null;
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        for (User user:USERS) {
            if (user.getName().equals(name) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
