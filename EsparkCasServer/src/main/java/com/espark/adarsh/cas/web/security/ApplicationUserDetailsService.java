package com.espark.adarsh.cas.web.security;


import com.espark.adarsh.cas.persistence.entities.User;
import com.espark.adarsh.cas.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User " + userName + " not found");
        }
        return new ApplicationUserDetails(user);
    }

}
