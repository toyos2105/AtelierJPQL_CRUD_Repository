/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Service;
import streaming.entity.Journal;

/**
 *
 * @author formation
 */
@Service
public class JournalService {
//    @PersistenceContext
//    private EntityManager em;
    
    public void journaliser(String msg){
        Journal journal=new Journal(new Date()+" --- "+ msg);
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager em = myPersistence.createEntityManager();
        em.getTransaction().begin();
        System.out.println( String.format("[%s] %s", new Date(), msg) );
         em.getTransaction().commit();
        
    }
}
