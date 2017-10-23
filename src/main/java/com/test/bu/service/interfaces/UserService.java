package com.test.bu.service.interfaces;

import com.test.bu.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends InterfaceService<User>, UserDetailsService {
    User findByUsername(String username);
    void delete(String id);
}
