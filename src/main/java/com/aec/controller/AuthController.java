package com.aec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aec.jwtConfig.AuthentificationRequest;
import com.aec.jwtConfig.AuthentificationResponse;
import com.aec.jwtConfig.jwtUtil;
import com.aec.service.CustomUserDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private jwtUtil jwtokenUtil;

	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("incorrect username and/or password",e);
		}
		
		final UserDetails userdetails=customUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		System.out.println(userdetails.getUsername());
		
		final String jwt=jwtokenUtil.generateToken(userdetails);
		
		System.out.println(jwt);
				
		return new ResponseEntity(new AuthentificationResponse(jwt), HttpStatus.OK);
	}
	
}