package e_commerce.service;

import e_commerce.domain.User;

public interface EnterService {
    User register(String name,String password);
    User login(String name, String password);
    User getUserByNameAndPassword(String name, String password);
}
