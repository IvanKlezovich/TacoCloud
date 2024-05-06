package com.learn.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.tacocloud.models.TacoOrder;

import java.util.List;


public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}