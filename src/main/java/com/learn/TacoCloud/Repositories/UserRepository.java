package com.learn.TacoCloud.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.learn.TacoCloud.Models.Users;

public interface UserRepository extends CrudRepository<Users, Long>{

    Users findByUsername(String username);

}
