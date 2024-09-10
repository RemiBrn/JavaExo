package org.example.exo02.Repository;
import org.example.exo02.entity.Examen;
import javax.persistence.*;
import java.util.List;


public class ExamenRepository {

    private EntityManager em;

    public ExamenRepository(EntityManager em) {
        this.em = em;
    }

    // Sauvegarde un nouvel examen dans la base de données
    public Examen save(Examen examen) {
        em.getTransaction().begin();
        em.persist(examen);
        em.getTransaction().commit();
        return examen;
    }

    // Trouve un examen par son ID
    public Examen find(int id) {
        return em.find(Examen.class, id);
    }

    // Supprime un examen par son ID
    public boolean delete(int id) {
        Examen examen = find(id);
        if (examen != null) {
            em.getTransaction().begin();
            em.remove(examen);
            em.getTransaction().commit();
            return true;
        } else {
            System.out.println("No exam found");
        }
        return false;
    }

    // Récupère tous les examens
    public List<Examen> getAll() {
        return em.createQuery("select e from Examen as e", Examen.class).getResultList();
    }

    // Récupère les examens par matière
    public List<Examen> getByMatiere(String matiere) {
        TypedQuery<Examen> query = em.createQuery("select e from Examen e where e.matiere = :matiere", Examen.class);
        query.setParameter("matiere", matiere);
        return query.getResultList();
    }

    // Récupère les examens par étudiant
    public List<Examen> getByStudent(int studentId) {
        TypedQuery<Examen> query = em.createQuery("select e from Examen e where e.student.id = :studentId", Examen.class);
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }
}
