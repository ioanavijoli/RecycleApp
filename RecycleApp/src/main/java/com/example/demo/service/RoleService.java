package com.example.demo.service;

import com.example.demo.model.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleService {
    Role getUserRole();

    Role getAdminRole();
}
