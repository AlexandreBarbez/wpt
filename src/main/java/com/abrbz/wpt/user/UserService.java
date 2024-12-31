package com.abrbz.wpt.user;

import com.abrbz.wptapi.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserMapper mapper;
    UserRepository repository;

    public UserService(UserMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.repository = userRepository;
    }

    void createUser(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        repository.save(userEntity);
    }
}
