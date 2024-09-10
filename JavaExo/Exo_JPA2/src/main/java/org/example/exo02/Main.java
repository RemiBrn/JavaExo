package org.example.exo02;

import org.example.exo02.Repository.ExamenRepository;
import org.example.exo02.entity.Examen;
import org.example.exo02.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exo_JPA2");
        EntityManager em = emf.createEntityManager();

        // == CREATION D'UN ETUDIANT ==
        //---------------------------------------------------------------

//        StudentRepository studentRepository = new StudentRepository(em);
//
//        Student student = Student.builder().firstname("titi").lastname("tutu").classe("classe2").build();

//        studentRepository.save(student);
//
//        System.out.println(studentRepository.find(1));
//
//        System.out.println("liste des etudiants");
//
//        studentRepository.getALl().forEach(System.out::println);

        // == ASSOCIER UNE ADRESSE A UN ETUDIANT EXISTANT ==
        //---------------------------------------------------------------

        // 1. récupérer l'id de l'étudiant

//        int studentId = 1;
//        Student student = em.find(Student.class, studentId);
//
//        // 2. création d'une nouvelle adresse :
//        Adresse adresse = Adresse.builder()
//                .numero(17)
//                .rue("rue du 8 mai")
//                .ville("Lille")
//                .codePostal(59000).build();
//
//        // 3. lier l'adresse à l'étudiant
//        adresse.setStudent(student);
//        student.setAdresse(adresse);
//
//
//        em.getTransaction().begin();
//        em.persist(adresse);
//        em.getTransaction().commit();

        // == CHANGER DES  DONNEES EXISTANTES DANS ETUDIANT  ==
        //---------------------------------------------------------------

//          int studentId = 1;
//          Student student = em.find(Student.class, studentId);

        // 2. Modifier les attributs

//        if (student != null) {//
//            student.setFirstname("McLane");
//            student.setLastname("John");
//            student.setClasse("5A");
//
//      // 3. Persister les modifications
//            em.getTransaction().begin();
//            em.merge(student);
//            em.getTransaction().commit();
//
//            System.out.println("L'étudiant a été mis à jour avec succès !");
//        } else {
//            System.out.println("L'étudiant avec l'ID " + studentId + " n'a pas été trouvé.");
//        }

        // == CREATION D'UN ETUDIANT ET D'UNE ADRESSE EN MEME TEMPS ==
        //---------------------------------------------------------------

//        // 1. Etudiant
//        Student newStudent = Student.builder()
//                .firstname("Marty")
//                .lastname("McFly")
//                .classe("6B")
//                .build();
//
//        // 2. Adresse
//        Adresse nouvelleAdresse = Adresse.builder()
//                .numero(155)
//                .rue("Avenue des Lions")
//                .ville("Paris")
//                .codePostal(75000)
//                .build();
//
//        // 3. Établir la relation entre l'étudiant et l'adresse
//        nouvelleAdresse.setStudent(newStudent);
//        newStudent.setAdresse(nouvelleAdresse);
//
//
//        em.getTransaction().begin();
//        em.persist(newStudent);
//        em.getTransaction().commit();

        // ==  CREATION D'EXAMEN ET LIAISON AVEC ETUDIANT ==
        //---------------------------------------------------------------

        Student student = em.find(Student.class, 2);

//        Examen exam1 = Examen.builder()
//                .date("13/04/2023")
//                .note(12)
//                .matiere("Mathématique")
//                .build();
//
//        Examen exam2 = Examen.builder()
//                .date("11/06/2023")
//                .note(19)
//                .matiere("Géographie")
//                .build();

                Examen exam3 = Examen.builder()
                .date("17/06/2023")
                .note(19)
                .matiere("Histoire")
                .build();

        // 3. lier l'adresse à l'étudiant
//        exam3.setStudent(student);
//        ExamenRepository.save(exam3);


//
//        em.getTransaction().begin();
//        em.persist(exam1);
//        em.persist(exam2);
//        em.getTransaction().commit();






    }
}