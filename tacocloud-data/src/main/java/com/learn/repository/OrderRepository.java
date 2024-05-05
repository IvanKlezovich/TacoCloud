package com.learn.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.model.TacoOrder;

import java.util.List;


public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}