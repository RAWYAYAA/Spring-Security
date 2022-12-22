package com.springsecurityfirstproject.services.ServicesImpl;

import com.springsecurityfirstproject.dao.RoleDao;
import com.springsecurityfirstproject.dao.UsersRepo;
import com.springsecurityfirstproject.entities.Role;
import com.springsecurityfirstproject.entities.Users;
import com.springsecurityfirstproject.services.UserInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService implements UserInterface {
    private  final UsersRepo userRepo;
    private  final RoleDao roleRepo;
    @Override
    public Users saveUser(Users user) {
        log.info("saving user {} to db",user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role {} to db",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role {} to userto db",roleName,username);
        Users user= userRepo.findByUsername(username);
        Role role= roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public Users getUser(String username) {
        log.info("getUser {}",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<Users> getUsers() {
        log.info("getUsers");
        return userRepo.findAll();
    }
}