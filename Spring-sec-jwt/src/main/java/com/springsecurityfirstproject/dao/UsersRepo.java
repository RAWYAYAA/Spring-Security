package com.springsecurityfirstproject.dao;

import com.springsecurityfirstproject.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users,Long> {

        Users findByUsername(String username);
}
