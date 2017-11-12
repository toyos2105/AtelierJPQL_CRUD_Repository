/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Test;
import streaming.entity.Film;

/**
 *
 * @author Formation
 */
public class NewEmptyJUnitTest {
    EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
    EntityManager em = myPersistence.createEntityManager();
    
    @Test
    public void Exercice1() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT f FROM Film f WHERE f.id=4");
        Film film = (Film) query.getSingleResult();
        
        System.out.println("EX 1   Nom du film="+film.getTitre());
      
    }
    
    @Test
    public void Exercice2() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) FROM Film f");
        long nbFilm = (long) query.getSingleResult();
        
        System.out.println("EX 2   nbFilm = "+nbFilm);
      
    } 
    
    @Test
    public void Exercice3() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT MIN(f.annee) FROM Film f");
        int anneeMin = (int) query.getSingleResult();
        
        System.out.println("EX 3   anneeMin = "+anneeMin);
      
    } 
    
    @Test
    public void Exercice4() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(l) FROM Lien l JOIN l.film f WHERE f.titre='Big Lebowski (The)'");
        long nbLien = (long) query.getSingleResult();
        
        System.out.println("EX 4   nbLien = "+nbLien);
      
    } 
    
    @Test
    public void Exercice5() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) FROM Film f JOIN f.?????????????? r WHERE r.nom='Polanski'");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 5   nbFilms = "+nbFilms);
      
    }   
}
