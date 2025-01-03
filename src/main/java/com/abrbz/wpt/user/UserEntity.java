package com.abrbz.wpt.user;

import jakarta.persistence.*;

@Entity
@Table(name = "wpt-user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private Integer userStatus;

    protected UserEntity() {
    }

    public UserEntity(String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getUserStatus() {
        return userStatus;
    }
}
