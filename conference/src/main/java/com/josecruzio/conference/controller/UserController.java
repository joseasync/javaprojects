package com.josecruzio.conference.controller;

import com.josecruzio.conference.model.Registration;
import com.josecruzio.conference.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstname", defaultValue = "Jose") String firstname,
                        @RequestParam(value = "lastname", defaultValue = "Cruz") String lastname,
                        @RequestParam(value = "age", defaultValue = "24") int age){
        User user = new User();

        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user")
    public User postUser(User user){
        System.out.println("User first name" + user.getFirstName());
        return user;
    }


}
