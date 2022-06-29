package com.aec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aec.entity.Order;

@Repository
public interface IOrderDao extends JpaRepository<Order, Integer> {

    @Query(value="SELECT * FROM orders o WHERE o.id_user = :idUsr", nativeQuery = true)
    public List<Order> findOrdersByIdUser(int idUsr);

}