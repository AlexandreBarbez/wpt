package com.abrbz.wpt.user;

import com.abrbz.wptapi.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPhone(), user.getUserStatus());
    }

    public static User toModel(UserEntity user) {
        User userModel = new User();
        userModel.setLastName(user.getLastName());
        userModel.setFirstName(user.getFirstName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setPhone(user.getPhone());
        userModel.setUserStatus(user.getUserStatus());
        return userModel;
    }
}
