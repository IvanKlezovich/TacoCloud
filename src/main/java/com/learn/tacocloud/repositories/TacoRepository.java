package com.learn.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.tacocloud.models.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {}