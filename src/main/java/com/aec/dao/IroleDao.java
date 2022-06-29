package com.aec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aec.entity.Role;

public interface IroleDao extends JpaRepository<Role, Integer> {

}
