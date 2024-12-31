package com.abrbz.wpt.user;

import com.abrbz.wptapi.api.UserApi;
import com.abrbz.wptapi.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController implements UserApi {

    UserService userService;

    public UserController(UserService userService ) {
        this.userService = userService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return UserApi.super.getRequest();
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        User newUser = new User();
        newUser.setFirstName("Alex");
        newUser.setEmail("Alex@gmail.com");
        newUser.setLastName("Barbez");

        userService.createUser(newUser);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> createUsersWithListInput(List<@Valid User> user) {
        return UserApi.super.createUsersWithListInput(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        return UserApi.super.deleteUser(username);
    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        return UserApi.super.getUserByName(username);
    }

    @Override
    public ResponseEntity<String> loginUser(String username, String password) {
        return UserApi.super.loginUser(username, password);
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        return UserApi.super.logoutUser();
    }

    @Override
    public ResponseEntity<Void> updateUser(String username, User user) {
        return UserApi.super.updateUser(username, user);
    }
}
