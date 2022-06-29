	package com.aec.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aec.entity.User;

public interface IUserDao extends JpaRepository<User, Integer>{
	
	//@Query("SELECT u FROM User WHERE u.username = :un AND u.password = :p")
	//public Optional<User> findUserLogIn(@Param("un") String username, @Param("p") String password);
	public Optional<User> findByUsername(String username);

}
