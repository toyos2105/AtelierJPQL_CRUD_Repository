/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import junit.framework.Assert;
import org.junit.Test;
import streaming.entity.Film;

/**
 *
 * @author formation
 */
public class JPQLTest {

    @Test
    public void req12() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(""
                + "SELECT   f "
                + "FROM     Film f "
                + "         JOIN f.genre g "
                + "WHERE    g.nom='Policier' "
                + "INTERSECT "
                + "SELECT   f "
                + "FROM     Film f "
                + "         JOIN f.realisateurs r "
                + "WHERE    r.nom='Coen' "
                + "         AND r.prenom='Ethan' "
                + "INTERSECT "
                + "SELECT   f "
                + "FROM     Film f "
                + "         JOIN f.realisateurs r "
                + "WHERE    r.nom='Coen' "
                + "         AND r.prenom='Joel' "
                + "INTERSECT "
                + "SELECT   f "
                + "FROM     Film f "
                + "         JOIN f.acteurs a "
                + "WHERE    a.nom='Buscemi' "
                + "         AND a.prenom='Steve' ");
                

        Assert.assertEquals(1L, query.getResultList().size() );
    }
    
    @Test
    public void req11() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(""
                + "SELECT   COUNT(f) "
                + "FROM     Film f "
                + "         JOIN f.realisateurs r1 "
                + "         JOIN f.realisateurs r2 "
                + "         JOIN f.acteurs a "
                + "WHERE    r1.nom='Coen' "
                + "         AND r2.nom='Coen' "
                + "         AND r1.prenom='Joel' "
                + "         AND r2.prenom='Ethan' "
                + "         AND a.nom='Buscemi' "
                + "         AND a.prenom='Steve'");

        Assert.assertEquals(2L, query.getSingleResult() );
    }
    
    @Test
    public void req10v2() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(""
                + "SELECT   COUNT(f) "
                + "FROM     Film f "
                + "         JOIN f.realisateurs r "
                + "         JOIN f.realisateurs r2 "
                + "WHERE    r.nom='Coen' "
                + "         AND r.prenom='Ethan' "
                + "         AND r2.nom='Coen'"
                + "         AND r2.prenom='Joel'");

        Assert.assertEquals(2L, query.getSingleResult() );
    }
    
    @Test
    public void req10() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(""
                + "SELECT   f "
                + "FROM     Film f "
                + "         JOIN f.realisateurs r "
                + "WHERE    r.nom='Coen' "
                + "         AND r.prenom='Ethan' "
                + "INTERSECT "
                + "SELECT   f "
                + "FROM     Film f "
                + "         JOIN f.realisateurs r "
                + "WHERE    r.nom='Coen' "
                + "         AND r.prenom='Joel' ");

        Assert.assertEquals(2L, query.getResultList().size() );
    }
    
    @Test
    public void req9() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(""
                + "SELECT   COUNT(f) "
                + "FROM Film f "
                + "     JOIN f.realisateurs r "
                + "WHERE r.nom='Coen' AND "
                + "      r.prenom='Joel'");

        Assert.assertEquals(2L, query.getSingleResult() );
    }
    
//    @Test
//    public void reqTest() {
//
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
//        EntityManager em = factory.createEntityManager();
//
//        Query query = em.createQuery(""
//                + "SELECT  f "
//                + "FROM     Film f "
//                + "         JOIN f.genre g "
//        );
//
//        List l = query.getResultList();
//        
//        System.err.println( "***" + l.size() );
//    }

//    @Test
    public void req8() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(""
                + "SELECT   f.titre "
                + "FROM     Film f "
                + "         JOIN f.genre g "
                + "         JOIN f.pays p "
                + "         JOIN f.realisateurs r "
                + "WHERE    g.nom='Horreur' "
                + "         AND p.nom='UK' "
                + "         AND r.nom='Polanski'");

        String titre = (String) query.getSingleResult();
        Assert.assertEquals("Le bal des vampire", titre);
    }

//    @Test
    public void req7() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(""
                + "SELECT COUNT(f) "
                + "FROM Film f "
                + "     JOIN f.acteurs a "
                + "     JOIN f.realisateurs r "
                + "WHERE a.nom='Polanski' "
                + "      AND r.nom='Polanski'");
        long n = (long) query.getSingleResult();

        Assert.assertEquals(1, n);
    }

//    @Test
    public void req4() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery(""
                + "SELECT COUNT(l) "
                + "FROM Lien l "
                + "     JOIN l.film f "
                + "WHERE f.titre='Big Lebowski'");
        long n = (long) query.getSingleResult();

        Assert.assertEquals(0, n);
    }

//    @Test
    public void req3() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT MIN(f.annee) FROM Film f");
        int n = (int) query.getSingleResult();

        Assert.assertEquals(1968, n);
    }

//    @Test
    public void req2() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT COUNT(f) FROM Film f");
        long n = (long) query.getSingleResult();

        Assert.assertEquals(4, n);
    }

//    @Test
    public void req1() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT f FROM Film f WHERE f.id=4");
        Film film = (Film) query.getSingleResult();

        Assert.assertEquals("Fargo", film.getTitre());
    }
}
