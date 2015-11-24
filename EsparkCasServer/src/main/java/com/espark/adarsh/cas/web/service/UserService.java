package com.espark.adarsh.cas.web.service;

import com.espark.adarsh.cas.persistence.entities.User;
import com.espark.adarsh.cas.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


    public User getUserByUserName(String userName) {
        return userRepository.findOne(userName);
    }
	
	public User getUserByUserName(String userName,String userPwd) {
        return userRepository.findOne(userName);
    }
}
