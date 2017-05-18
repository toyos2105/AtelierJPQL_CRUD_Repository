/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.config.SpringConfig;
import streaming.service.Service1;
import streaming.service.Service2;
import streaming.service.Service3;

/**
 *
 * @author formation
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class TestJournalisation {
    
    @Autowired
    private Service1 srv1;
    
    @Autowired
    private Service2 srv2;
    
    @Autowired
    private Service3 srv3;
    
    @Test
    public void test(){
        
        srv1.ajouter();
        srv1.modifier();
        srv1.supprimer();
        srv1.lister();
        srv1.rechercher(1);
        
        srv2.ajouter();;
        srv2.modifier();
        srv2.supprimer();
        srv2.lister();
        srv2.rechercher(1);
        
        srv3.ajouter();;
        srv3.modifier();
        srv3.supprimer();
        srv3.lister();
        srv3.rechercher(1);
    }
}
