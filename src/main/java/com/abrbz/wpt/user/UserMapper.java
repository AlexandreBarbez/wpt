package com.abrbz.wpt.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserMapper {

    public UserEntity toEntity(com.abrbz.wptapi.model.User user) {
        return new UserEntity(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone());
    }

    public com.abrbz.wptapi.model.User toModel(UserEntity userEntity) {
        com.abrbz.wptapi.model.User userModel = new com.abrbz.wptapi.model.User();
        userModel.setLastName(userEntity.getLastName());
        userModel.setFirstName(userEntity.getFirstName());
        userModel.setEmail(userEntity.getEmail());
        userModel.setPassword(userEntity.getPassword());
        userModel.setPhone(userEntity.getPhone());
        return userModel;
    }
}
