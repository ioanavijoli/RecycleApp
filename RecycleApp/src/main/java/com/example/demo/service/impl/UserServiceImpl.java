package com.example.demo.service.impl;

import com.example.demo.exception.RecyclingCenterNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.RecyclingCenter;
import com.example.demo.model.User;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username" + username);
        }
        return user;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        return UserDetailsImpl.build(user);
    }


    public ArrayList<User> findUserByName(String name) throws UserNotFoundException {
        ArrayList<User> userList=userRepository.findAllByUsernameContains(name);
        if(userList.isEmpty()){
            throw new UserNotFoundException("No user found");
        }
        return userList;
    }
}
