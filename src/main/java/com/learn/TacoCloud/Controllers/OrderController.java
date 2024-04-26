package com.learn.TacoCloud.Controllers;

import com.learn.TacoCloud.Models.TacoOrder;
import com.learn.TacoCloud.RepositoryJdbc.JdbcOrderRepository;
import com.learn.TacoCloud.RepositoryJdbc.OrderRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.support.SessionStatus;


@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
   private final OrderRepository orderRepo;
   @Autowired
   public OrderController(OrderRepository orderRepository) {
       this.orderRepo = orderRepository;
   }
   @GetMapping("/current")
   public String orderForm(){
        return "orderForm";
    }
   @PostMapping()
   public String processOrder(@Valid TacoOrder order,
       Errors errors, SessionStatus sessionStatus) {
       if(errors.hasErrors()){
           return "orderForm";
       }
       log.info("Processing taco: {}", order);
       orderRepo.save(order);
       sessionStatus.setComplete();
       return "redirect:/";
   }
}
