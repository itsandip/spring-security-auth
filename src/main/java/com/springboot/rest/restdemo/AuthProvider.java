package com.springboot.rest.restdemo;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider implements AuthenticationProvider {

	 @SuppressWarnings("unchecked")
	@Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	      String username = authentication.getName();
	      String password = authentication.getCredentials().toString();
	      if ("employee".equals(username) && "test@1234".equals(password)) {
	    	  
	    	  /*Collection<? extends GrantedAuthority> list = new ArrayList<>();
	    	  list.add(new GrantedAuthority("USER")); 
	    	  list.add(new GrantedAuthorityDefaults("ADMIN"));*/
	            //return new UsernamePasswordAuthenticationToken(username, password, list);
	    	  return null;
	       } else {
	            throw new BadCredentialsException("Authentication failed");
	       }
	    }
	    @Override
	    public boolean supports(Class<?>aClass) {
	        return aClass.equals(UsernamePasswordAuthenticationToken.class);
	    }

}
