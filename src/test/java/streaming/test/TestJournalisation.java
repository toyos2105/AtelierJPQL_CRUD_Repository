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
import streaming.component.Parent;
import streaming.config.SpringConfig;
import streaming.dao.FilmDAO;
import streaming.dao.LienDAO;
import streaming.entity.Film;

/**
 *
 * @author formation
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class TestJournalisation {
    
    @Autowired
    public Parent p;
    
    @Autowired
    public FilmDAO daofilm;
    
    @Autowired
    public LienDAO daolien;

    
//    @Autowired
//    private Composant1 c1;
//    @Autowired
//    private Composant1 c1b;
    
//    @Autowired
//    private Service2 srv2;
//    
//    @Autowired
//    private Service3 srv3;
    
    @Test
    public void test(){
        
//        System.out.println("p : "+p);
        long l;
        Film f;
        f=daofilm.findOneById(4);
        System.out.println("findOneById : "+f.getTitre());
        System.out.println("count() : "+daofilm.count());
        System.out.println("anneeMin() : "+daofilm.anneeMin());
        System.out.println("countByFilmTitre() : "+daolien.countByFilmTitre("Big Lebowski (The)"));
        System.out.println("countByRealisateursNom() : "+daofilm.countByRealisateursNom("Polanski"));
        System.out.println("countByActeursNom() : "+daofilm.countByActeursNom("Polanski"));
        
        f = daofilm.findOneByRealisateursNomAndActeursNom("Polanski","Polanski");
        System.out.println("findOneByRealisateursNomAndActeursNom() : "+f.getTitre());
        
        f = daofilm.findOneByGenreNomAndPaysNomAndRealisateursNomAndRealisateursPrenom("Horreur","UK","Polanski","Roman");
        System.out.println("findOneByGenreNomAndPaysNomAndRealisateursNomAndRealisateursPrenom() : "+f.getTitre());
        
        l = daofilm.countByRealisateursNomAndRealisateursPrenom("Coen","Joel");
        System.out.println("countByRealisateursNomAndRealisateursPrenom() : "+l);
   
        l = daofilm.countByRealisateursNomAndRealisateursPrenomOrRealisateursPrenom("Coen","Joel","Ethan");
        System.out.println("countByRealisateursNomAndRealisateursPrenomOrRealisateursPrenom() : "+l);
        
        
        
        
//        System.out.println("C1 : "+c1);
//        System.out.println("C1b : "+c1b);
//        
//        c1.affiche();
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
