package com.example.stin.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;



//    public UserEntity saveUser(UserEntity userEntity) {
//        return userRepository.save(userEntity);
//    }
//
//    public boolean isUserPresent(String email, String password) {
//        boolean isUserPresent = false;
//        if (userRepository.findByEmail(email) != null && userRepository.findByPassword(password) != null) {
//            isUserPresent = true;
//        }
//        return isUserPresent;
//    }

//    public String insertCodeToUser(int code, String email) {
//        return "UPDATE users SET code = ?1 where email = ?2";
//    }

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
