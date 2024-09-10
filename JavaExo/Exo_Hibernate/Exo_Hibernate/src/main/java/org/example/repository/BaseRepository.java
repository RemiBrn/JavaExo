package org.example.repository;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseRepository<T>{

    protected EntityManager em;
    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    public abstract void createOrUpdate (T element);
    public abstract void delete (T element);
    public abstract T findById (int id,String discriminator);
    public abstract List<T> findAll ();
    public abstract List<T> findAllByType (String productClass);



}
