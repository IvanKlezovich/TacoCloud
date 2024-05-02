package com.learn.TacoCloud.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.TacoCloud.Models.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {}