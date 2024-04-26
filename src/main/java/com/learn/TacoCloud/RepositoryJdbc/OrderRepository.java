package com.learn.TacoCloud.RepositoryJdbc;

import com.learn.TacoCloud.Models.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}