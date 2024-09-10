package org.example.exo03.repository;

import org.example.exo03.entity.Food;
import javax.persistence.EntityManager;

public class FoodRepository extends BaseRepository<Food> {
    public FoodRepository(EntityManager em) {
        super(em);
    }
}
