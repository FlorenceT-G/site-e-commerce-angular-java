package com.aec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aec.entity.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	IUserService uService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * Pour se connecter à la bdd cette méthode doit appeler une api de JPA
		*/
		
		Optional<com.aec.entity.User> user = uService.chercherParUsername(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));
		
		return new CustomUserDetails(user.get());
		/*
			List<GrantedAuthority> l = getGrantedAuthority(user.get());
			return new User(user.get().getUsername(), user.get().getPassword(), l);
		*/
	}
	
	/*
	private List<GrantedAuthority> getGrantedAuthority(com.app.entity.User u) {
		List<GrantedAuthority> l = new ArrayList<>();
		
		Role role = u.getRole();
		System.out.println("label: " + role.getLabelRole());
		l.add(new SimpleGrantedAuthority(role.getLabelRole()));
		
		for(int i = 0 ; i < l.size() ; i++) System.out.println("authority: " + l.get(i).getAuthority());
		return l;
	}
	*/

}
