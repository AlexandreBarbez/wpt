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
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> createUsersWithListInput(List<@Valid User> users) {
        userService.createUsers(users);
        return new ResponseEntity<>(users.getLast(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<User> getUserById(String id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> loginUser(String id, String password) {
        return UserApi.super.loginUser(id, password);
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        return UserApi.super.logoutUser();
    }

    @Override
    public ResponseEntity<Void> updateUser(String id, User user) {
        return UserApi.super.updateUser(id, user);
    }
}
