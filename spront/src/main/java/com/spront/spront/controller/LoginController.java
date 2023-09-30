package com.spront.spront.controller;

import com.spront.spront.dao.UserDao;
import com.spront.spront.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;

    @CrossOrigin
    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        int count = userDao.getUserMessage(user.getUsername(), user.getPassword());
        System.out.println("user:" + count);
        String str = "error";
        if (count > 0) {
            str = "ok";
        }
        return str;
    }
}
