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
    public void Exercice() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT f FROM Film f WHERE f.id=4");
        Film film = (Film) query.getSingleResult();

        Assert.assertEquals("Fargo", film.getTitre());
        
        System.out.println(film.getTitre());
        
        //em.getTransaction().commit();
        
        
    }
    
    
}
