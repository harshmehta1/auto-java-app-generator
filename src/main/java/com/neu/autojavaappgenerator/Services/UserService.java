package com.neu.autojavaappgenerator.Services;

import com.neu.autojavaappgenerator.Models.*;
import com.neu.autojavaappgenerator.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean save(User user){
        userRepository.save(user);
        return false;
    }

    public List<User> findAll(){
        return (List<User>)userRepository.findAll();
    }

}
