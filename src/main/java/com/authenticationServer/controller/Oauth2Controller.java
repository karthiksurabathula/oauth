package com.authenticationServer.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.authenticationServer.config.Oauth2DataSource;

public class Oauth2Controller {

	@Autowired
	private final Oauth2DataSource oauth2DataSource = null;
	@Autowired
	ConsumerTokenServices tokenServices;
	
//	@RequestMapping(value = "/revoke", method = RequestMethod.DELETE)
//	public Object revokeToken() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		
//		Collection<OAuth2AccessToken> tokens = oauth2DataSource.tokenStore()
//				.findTokensByClientIdAndUserName("my-trusted-client", auth.getName());
//
//		if (tokens != null) {
//			for (OAuth2AccessToken token : tokens) {
//				tokenServices.revokeToken(token);
//			}
//		} else {
//		}
//
//		
//		return oauth2Service.logoutF();
//	}
}
