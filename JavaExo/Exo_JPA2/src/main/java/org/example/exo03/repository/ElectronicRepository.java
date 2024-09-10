package org.example.exo03.repository;

import org.example.exo03.entity.Electronic;

import javax.persistence.EntityManager;

public class ElectronicRepository extends BaseRepository <Electronic>{
    public ElectronicRepository(EntityManager em) {
        super(em);
    }
}
