package org.example.exo02.Repository;

import org.example.exo02.entity.Adresse;
import javax.persistence.*;
import java.util.List;



public class AdresseRepository {

    private EntityManager em;

    public AdresseRepository(EntityManager em) {
        this.em = em;
    }

    // Sauvegarde une nouvelle adresse dans la base de données
    public Adresse save(Adresse adresse) {
        em.getTransaction().begin();
        em.persist(adresse);
        em.getTransaction().commit();
        return adresse;
    }

    // Trouve une adresse par son ID
    public Adresse find(int id) {
        return em.find(Adresse.class, id);
    }

    // Supprime une adresse par son ID
    public boolean delete(int id) {
        Adresse adresse = find(id);
        if (adresse != null) {
            em.getTransaction().begin();
            em.remove(adresse);
            em.getTransaction().commit();
            return true;
        } else {
            System.out.println("No address found");
        }
        return false;
    }

    // Récupère toutes les adresses
    public List<Adresse> getAll() {
        return em.createQuery("select a from Adresse as a", Adresse.class).getResultList();
    }

    // Récupère les adresses par ville
    public List<Adresse> getByVille(String ville) {
        TypedQuery<Adresse> query = em.createQuery("select a from Adresse a where a.ville = :ville", Adresse.class);
        query.setParameter("ville", ville);
        return query.getResultList();
    }

}
