package com.example.curdapi.employeeService;

import com.example.curdapi.entity.Users;



public interface UserService {
    boolean saveUsers(Users user);
    Users userLogin(Users users) throws Exception;
}
