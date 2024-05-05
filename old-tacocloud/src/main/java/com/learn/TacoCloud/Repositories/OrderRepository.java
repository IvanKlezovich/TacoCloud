package com.learn.TacoCloud.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.TacoCloud.Models.TacoOrder;
import java.util.List;


public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}