package org.example.exo01;

import org.example.exo01.entity.Etudiant;

import javax.persistence.*;
import java.util.List;

public class Main {

    public static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exo01");
        em = emf.createEntityManager();


        //--------Création d'un étudiant----------
        // après avoir créé ma méthode add, je peux l'utiliser pour créer et ajouter un étudiant dans ma BDD

        Etudiant etudiant = Etudiant.builder().nom("McLane").prenom("John").classe("6B").build();
//        add(etudiant); //une fois l'étudiant créé, je peux passer cette instruction en commentaire


    }

    public static void add(Etudiant etudiant) {
        em.getTransaction().begin();  // Démarre une transaction
        em.persist(etudiant);          // Persiste l'entité 'etudiant'
        em.getTransaction().commit();  // Valide la transaction, rendant les changements permanents dans la base de données
    }


    public Etudiant find(int id) {
        return em.find(Etudiant.class, id);
    }


    public boolean delete(int id) {
        Etudiant etudiant = find(id);
        if (etudiant != null) {
            em.getTransaction().begin();
            em.remove(etudiant);
            em.getTransaction().commit();
            return true;
        } else {
            System.out.println("no student found");
        }
        return false;
    }

    public List<Etudiant> getAll (){
        return em.createQuery("Select e from Etudiant e", Etudiant.class).getResultList();

    }


//    public static Etudiant getByReference (int id){
//        try{
//            return em.getReference(Etudiant.class,id);
//        }catch (EntityNotFoundException ex){
//            System.out.println(ex.getMessage());
//            return null;
//        }
//    }
//
//    public static void edit (int id , String nom, String prenom, String classe){
//        Etudiant etudiant = getByReference(id);
//        em.getTransaction().begin();
//        etudiant.setNom(nom);
//        etudiant.setPrenom(prenom);
//        etudiant.setClasse(classe);
//
//        em.getTransaction().commit();
//    }
//
//    public static void delete (int id){
//        Etudiant etudiant = getByReference(id);
//        if(etudiant == null){
//            System.out.println("no student found");
//            return ;
//        }
//        em.getTransaction().begin();
//        em.remove(etudiant);
//        em.getTransaction().commit();
//    }

}
