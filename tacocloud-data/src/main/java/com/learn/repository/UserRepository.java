package com.learn.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.model.Users;

public interface UserRepository extends CrudRepository<Users, Long>{

    Users findByUsername(String username);

}
