package com.learn.TacoCloud.Controllers;

import com.learn.TacoCloud.Models.TacoOrder;
import com.learn.TacoCloud.Repository.OrderRepository;

import jakarta.validation.Valid;

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

   private OrderRepository repository;
   
   public OrderController(OrderRepository orderRepository) {
       this.repository = orderRepository;
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
       repository.save(order);
       sessionStatus.setComplete();
       return "redirect:/";
   }
}
