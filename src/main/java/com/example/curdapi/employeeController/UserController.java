package com.example.curdapi.employeeController;

import com.example.curdapi.employeeService.UserService;
import com.example.curdapi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/" )
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/save")
    public boolean saveUser(@RequestBody Users user){
         userService.saveUsers(user);
         return true;
    }
    @PostMapping("/login")
    Users userLogin(@RequestBody Users users)throws Exception{
        return userService.userLogin(users);
    }

}
