package com.springsecurityfirstproject.services;
import com.springsecurityfirstproject.entities.Role;
import com.springsecurityfirstproject.entities.Users;

import java.util.List;

public interface UserInterface {



        Users saveUser(Users user);
        Role saveRole(Role role);
        void addRoleToUser(String username,String roleName);
        Users getUser(String username);
        List<Users>getUsers();
    }

