package org.demo;

import java.util.List;

import org.config.BaseTest;
import org.core.json.JsonUTils;
import org.junit.Test;
import org.spring.action.user.User;
import org.spring.action.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {
        User user1 = new User();
        // user1.setId("id1");
        user1.setEmail("nasdghia@gmai.com");
        user1.setAddress("ajsdfasd");
        user1.setUsername("userName");

        userService.saveUser(user1);
        userService.saveUser(user1);
        userService.saveUser(user1);
        userService.saveUser(user1);
        printUsers();

        User userCreated = userService.findById(1);
        User user2 = userService.findById(2);
        userCreated.setAddress("Hai Ha Village, Hai Hau distric, Nam Dinh province.");
        user2.setAddress("Hai Ha Village, Hai Hau distric, Nam Dinh province.");
        userCreated.setEmail("tuannghiatoregister@gmail.com");
        user2.setEmail("tuannghiatoregister@gmail.com");
        userService.updateUser(userCreated);
        userService.updateUser(user2);
        System.out.println(JsonUTils.toJson(userService.findById(1)));
        
        userService.deleteUserById(1);
    }

    private void printUsers() {
        System.out.println("\n============================");
        userService.findAllUsers().stream().forEach(System.out::println);
        System.out.println("============================\n");
    }
}
