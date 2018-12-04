package com.authenticationServer.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Service;

import com.authenticationServer.config.Oauth2DataSource;

@Service
public class Oauth2Service {

	@Autowired
	private final Oauth2DataSource oauth2DataSource = null;
	@Autowired
	ConsumerTokenServices tokenServices;
		
	public void logoutByUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		
//		Collection<OAuth2AccessToken> tokens = oauth2DataSource.tokenStore().findTokensByClientIdAndUserName("my-trusted-client", username);
//		if (tokens != null) {
//			for (OAuth2AccessToken token : tokens) {
//
//				if (tokenServices.revokeToken(token.getValue())) {
//				} else {
//				}				
//			}
//		}
	}
}
