package org.example.exo03.repository;

import org.example.exo03.entity.Housing;

import javax.persistence.EntityManager;

public class HousingRepository extends BaseRepository<Housing>{
    public HousingRepository(EntityManager em) {
        super(em);
    }
}
