package com.authenticationServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.authenticationServer.entity.User;
import com.authenticationServer.repository.UserRepository;

@Service(value="userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user=userRepository.findByUsername(username);
		
		if(user==null)
			throw new BadCredentialsException("Bad Credentials");
		
		new AccountStatusUserDetailsChecker().check(user);
		
		return user;
	}
}
