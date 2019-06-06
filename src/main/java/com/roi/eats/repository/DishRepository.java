package com.roi.eats.repository;

import com.roi.eats.domain.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {
}
