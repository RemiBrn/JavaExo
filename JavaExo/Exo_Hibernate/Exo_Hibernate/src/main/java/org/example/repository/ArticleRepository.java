package org.example.repository;

import org.example.entity.product.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.example.util.SessionFactorySingleton;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ArticleRepository extends BaseRepository<Article>{

    public ArticleRepository() {
        super(em);
    }

    @Override
    public void createOrUpdate(Article element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Article element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public Article findById(int id, String discriminator) {

        return null;
    }

    @Override
    public List<Article> findAll() {
        return List.of();
    }

    @Override
    public List<Article> findAllByType(String productClass) {
        return List.of();
    }

    //    private final SessionFactory sessionFactory;
//    private Session session;
//    private Scanner scanner;
//    private SimpleDateFormat dateFormat;
//
//    public ArticleRepository() {
//        sessionFactory = SessionFactorySingleton.getSessionFactory();
//        scanner = new Scanner(System.in);
//
//    }
//
//    public void createOrUpdate(Article inventaire) {
//        try {
//            session = sessionFactory.openSession();
//            Transaction transaction = session.beginTransaction();
//            session.saveOrUpdate(inventaire);
//            transaction.commit();
//        } catch (Exception ex) {
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//            ex.printStackTrace();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
//
//    public boolean delete(Article inventaire) {
//        try {
//            session = sessionFactory.openSession();
//            Transaction transaction = session.beginTransaction();
//            session.delete(inventaire);
//            transaction.commit();
//            return true;
//        } catch (Exception ex) {
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//            ex.printStackTrace();
//            return false;
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
//
//    public Article findById(int id) {
//        session = sessionFactory.openSession();
//        Article inventaire = session.get(Article.class, id);
//        session.close();
//        return inventaire;
//    }
//
//    public List<Article> getALL() {
//        session = sessionFactory.openSession();
//        List<Article> inventaire = session.createQuery("from Article", Article.class).list();
//        session.close();
//        return inventaire;
//    }
}
