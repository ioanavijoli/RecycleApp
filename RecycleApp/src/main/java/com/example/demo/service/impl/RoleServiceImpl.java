package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.RoleName;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName(RoleName.USER);
    }

    public Role getAdminRole() {
        return roleRepository.findByName(RoleName.ADMIN);
    }
    public void addRole(Role role) {
        roleRepository.save(role);
    }

}
