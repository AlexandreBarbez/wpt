package com.abrbz.wpt.user;

import com.abrbz.wpt.security.JwtService;
import com.abrbz.wptapi.api.UserApi;
import com.abrbz.wptapi.model.User;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Controller
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "bearerAuth", scheme = "bearer")
public class UserController implements UserApi {

    AuthenticationManager authenticationManager;
    JwtService jwtService;
    UserService userService;

    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
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
    public ResponseEntity<String> loginUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateJwtToken(authentication);

        return ResponseEntity.ok(jwt);
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        return UserApi.super.logoutUser();
    }

    @Override
    public ResponseEntity<Void> updateUser(Long id, User user) {
        userService.updateUser(id,user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
