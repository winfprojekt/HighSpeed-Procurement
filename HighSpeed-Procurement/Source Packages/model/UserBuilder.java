package model;

import java.util.HashSet;
import java.util.Set;

public class UserBuilder {

    private String username;
    private String password;
    private Set<Role> roles = new HashSet<Role>();

    public UserBuilder withUsername(String username){
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public UserBuilder withRoles(Set<Role> roles){
        this.roles = roles;
        return this;
    }

    public UserBuilder withRole(Role role){
        this.roles.add(role);
        return this;
    }

    public  User build(){
        return new User(username,password,roles);
    }

    public static UserBuilder getBuilder(){
        return new UserBuilder();
    }
}