package com.abrbz.wpt.user;

import com.abrbz.wptapi.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void createUsers(List<User> users) {
        users.forEach(this::createUser);
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }

    public User getUserById(String id) {
        return repository.findById(id).map(userEntity -> {
            return mapper.toModel(userEntity);
        }).orElseThrow();
    }
}
