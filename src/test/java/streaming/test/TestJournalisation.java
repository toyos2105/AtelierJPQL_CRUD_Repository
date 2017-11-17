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
import streaming.component.Composant1;
import streaming.config.SpringConfig;

/**
 *
 * @author formation
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class TestJournalisation {
    
    @Autowired
    private Composant1 c1;
    @Autowired
    private Composant1 c1b;
    
//    @Autowired
//    private Service2 srv2;
//    
//    @Autowired
//    private Service3 srv3;
    
    @Test
    public void test(){
        System.out.println("C1 : "+c1);
        System.out.println("C1b : "+c1b);
        
        c1.affiche();
//        srv1.ajouter();
//        srv1.modifier();
//        srv1.supprimer();
//        srv1.lister();
//        srv1.rechercher(1);
        
//        srv2.ajouter();
//        srv2.modifier();
//        srv2.supprimer();
//        srv2.lister();
//        srv2.rechercher(1);
//        
//        srv3.ajouter();
//        srv3.modifier();
//        srv3.supprimer();
//        srv3.lister();
//        srv3.rechercher(1);
    }
}
