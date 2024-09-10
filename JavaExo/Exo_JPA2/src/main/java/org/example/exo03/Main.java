package org.example.exo03;

import org.example.exo03.entity.Food;
import org.example.exo03.entity.Housing;
import org.example.exo03.entity.Electronic;
import org.example.exo03.util.IHM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exo_JPA2");
        EntityManager em = emf.createEntityManager();

        Food food = Food.builder().expirationDate(LocalDate.of(2077, 9, 7)).name("Udon").price(1.59D).build();
        Electronic electronic = Electronic.builder().batterieDuration(2700).name("Iphone 15").price(1599.5D).build();
        Housing housing = Housing.builder().name("Ecran Samsung").price(999.9D).height(90).width(167).build();

        em.getTransaction().begin();
        em.persist(food);
        em.persist(electronic);
        em.persist(housing);
        em.getTransaction().commit();

        new IHM().startMenu();


    }
}
