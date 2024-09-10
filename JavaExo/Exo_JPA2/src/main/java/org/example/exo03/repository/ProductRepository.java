package org.example.exo03.repository;
import javax.persistence.EntityManager;
import org.example.exo03.entity.Product;

public class ProductRepository extends BaseRepository<Product>{
    public ProductRepository(EntityManager em) {
        super(em);
    }

}
