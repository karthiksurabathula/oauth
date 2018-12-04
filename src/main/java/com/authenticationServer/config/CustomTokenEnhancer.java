package com.authenticationServer.config;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.authenticationServer.entity.User;

public class CustomTokenEnhancer extends JwtAccessTokenConverter  implements TokenEnhancer  {
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());
		Set<GrantedAuthority> permisssion = new HashSet<GrantedAuthority>();
		info.put("name", user.getFirstname() + " "+ user.getLastname());	
		user.getRoles().forEach(r -> {
			r.getPermissions().forEach(p -> {
				permisssion.add(new SimpleGrantedAuthority(p.getName()));
			});
		});
		info.put("permisssions", permisssion);
		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(info);
		return customAccessToken;
	}
}