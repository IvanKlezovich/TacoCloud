package com.learn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learn.model.Taco;


public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

    void save(Taco taco1);}