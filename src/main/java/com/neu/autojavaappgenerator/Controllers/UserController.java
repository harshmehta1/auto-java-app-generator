package com.neu.autojavaappgenerator.Controllers;

import com.neu.autojavaappgenerator.Models.*;
import com.neu.autojavaappgenerator.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        List<User> user = userService.findAll();
        if (user.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {

        userService.save(user);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
}
