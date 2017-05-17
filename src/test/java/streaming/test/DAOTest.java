/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.config.SpringConfig;
import streaming.dao.FilmDAO;
import streaming.entity.Film;

/**
 *
 * @author formation
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class DAOTest {
    
    @Autowired
    private FilmDAO filmDao;
    
    
    
    @Test
    public void req7(){
        
        long nbFilms = filmDao.countByRealisateursNomAndActeursNom("Polanski", "Polanski");
        
        Assert.assertEquals(1L, nbFilms);
    }
    
    @Test
    public void test1(){
        
        
        Assert.assertEquals(1L, filmDao.compteFilmsParNomActeur("Polanski") );
    }
}
