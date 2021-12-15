package com.example.curdapi.employeeService.empServicesImpl;

import com.example.curdapi.employeeService.UserService;
import com.example.curdapi.entity.Users;
import com.example.curdapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean saveUsers(Users user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public Users userLogin(Users users) throws Exception {
        String tempName = users.getUsername();
        String tempPassword = users.getPassword();

        Users userObj =null;
        if(tempName != null & tempPassword != null){
            userObj = FetchUser(tempName,tempPassword);

        }if(userObj ==null){
            throw new Exception("Bad");
        }
        return userObj;
    }

    public Users FetchUser(String username,String password){
        return userRepository.findByUsernameAndPassword( username , password);
    }

}
