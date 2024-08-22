package com.auth.service;

import com.auth.model.UserPrincipal;
import com.auth.model.Users;
import com.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user = repository.findByUsername(username);

       if(user==null){
           System.out.println("user not found!");
           throw new UsernameNotFoundException("User not Found !");
       }
       return new UserPrincipal(user);

    }
}
