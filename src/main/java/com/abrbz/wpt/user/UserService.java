package com.abrbz.wpt.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;
    UserRepository repository;
    PasswordEncoder passwordEncoder;

    public UserService(UserMapper mapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.repository = userRepository;
        this.userMapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    void createUser(com.abrbz.wptapi.model.User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(userEntity);
    }

    public void createUsers(List<com.abrbz.wptapi.model.User> users) {
        users.forEach(this::createUser);
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }

    public com.abrbz.wptapi.model.User getUserById(String id) {
        return repository.findById(id).map(userMapper::toModel).orElseThrow();
    }

    public void updateUser(Long id, com.abrbz.wptapi.model.User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        userEntity.setId(id);
        repository.save(userEntity);
    }
}
