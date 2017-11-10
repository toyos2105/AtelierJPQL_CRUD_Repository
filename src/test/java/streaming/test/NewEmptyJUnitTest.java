/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Formation
 */
public class NewEmptyJUnitTest {
    EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
    EntityManager em = myPersistence.createEntityManager();
    
    public void Exercice() {
        em.getTransaction().begin();
        
        
        
        
        
        em.getTransaction().commit();
        
        
    }
    
    
}
