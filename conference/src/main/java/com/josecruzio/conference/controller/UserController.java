package com.josecruzio.conference.controller;

import com.josecruzio.conference.model.Registration;
import com.josecruzio.conference.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.*;

@RestController
@BasePathAwareController
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

    @ApiOperation(value="Post User anotacao para o Swagger", notes ="anotacao dentro da documentacao")
    @PostMapping("/user")
    public User postUser(User user){
        System.out.println("User first name" + user.getFirstName());
        return user;
    }


}
