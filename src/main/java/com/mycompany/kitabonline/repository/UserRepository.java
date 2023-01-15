package com.mycompany.kitabonline.repository;

import com.mycompany.kitabonline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
