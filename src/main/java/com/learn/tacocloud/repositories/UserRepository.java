package com.learn.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.tacocloud.models.Users;

public interface UserRepository extends CrudRepository<Users, Long>{

    Users findByUsername(String username);

}
