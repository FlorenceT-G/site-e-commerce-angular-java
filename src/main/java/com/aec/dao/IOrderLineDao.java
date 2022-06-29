package com.aec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aec.entity.OrderLine;

@Repository
public interface IOrderLineDao extends JpaRepository<OrderLine, Integer> {

}