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
        
        Query query = em.createQuery("SELECT count(f) FROM Film f JOIN f.realisateurs r WHERE r.nom='Polanski'");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 5   nbFilms Polanski réalisateur = "+nbFilms);
      
    }   
    
    @Test
    public void Exercice6() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) FROM Film f JOIN f.acteurs a WHERE a.nom='Polanski'");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 6   nbFilms Polanski acteur = "+nbFilms);
    }
    
     @Test
    public void Exercice7() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) FROM Film f JOIN f.acteurs a JOIN f.realisateurs r WHERE a.nom='Polanski' AND r.nom='Polanski'");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 7   nbFilms Polanski acteur réalisateur = "+nbFilms);
    }
    
    @Test
    public void Exercice8() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT f FROM Film f JOIN f.genre g JOIN f.pays p JOIN f.realisateurs r WHERE g.nom='Horreur' AND p.nom='UK' AND r.nom='Polanski'");
        Film film = (Film) query.getSingleResult();
        
        System.out.println("EX 8   Le titre du film d horreur anglais réalisé par roman polanski = "+ film.getTitre());
    }
    
    @Test
    public void Exercice9() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) FROM Film f JOIN f.realisateurs r WHERE r.nom='Coen' AND r.prenom='Joel'");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 9   Le nombre de films réalisés par joel coen = "+nbFilms);
      
    }
    
    @Test
    public void Exercice10() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) FROM Film f JOIN f.realisateurs r1, f.realisateurs r2 WHERE (r1.nom='Coen' AND r1.prenom='Joel') AND (r2.nom='Coen' AND r2.prenom='Ethan')");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 10   Le nombre de films réalisés par les 2 frères coen = "+nbFilms);
      
    }
    
    @Test
    public void Exercice11() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) FROM Film f JOIN f.realisateurs r1, f.realisateurs r2, f.acteurs a1 WHERE (r1.nom='Coen' AND r1.prenom='Joel') AND (r2.nom='Coen' AND r2.prenom='Ethan') AND (a1.nom='Buscemi' AND a1.prenom='Steve')");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 11   Le nombre de films réalisés à la fois par les 2 frères Coen, et interprétés par Steve Buscemi= "+nbFilms);
      
    }
    
    @Test
    public void Exercice12() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) FROM Film f JOIN f.realisateurs r1, f.realisateurs r2, f.acteurs a1, f.genre g1 WHERE (r1.nom='Coen' AND r1.prenom='Joel') AND (r2.nom='Coen' AND r2.prenom='Ethan') AND (a1.nom='Buscemi' AND a1.prenom='Steve') AND g1.nom='Policier'");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 12   Le nombre de films policiers réalisés à la fois par les 2 frères Coen, et interprétés par Steve Buscemi = "+nbFilms);
      
    }
    
    @Test
    public void Exercice13() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(saison) FROM Saison saison JOIN saison.serie serie Where serie.titre ='Dexter'");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 13   Le nombre de saisons de la série Dexter = "+nbFilms);
      
    }
    
    @Test
    public void Exercice14() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(e) FROM Episode e Where e.saison.serie.titre ='Dexter'");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 14   Le nombre total d'épisodes de la série Dexter = "+nbFilms);
      
    } 
    
    @Test
    public void Exercice15() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(e) FROM Episode e Where (e.saison.serie.titre ='Dexter') AND (e.saison.numSaison=8)");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 15   Le nombre d'épisodes de la saison 8 de la série Dexter = "+nbFilms);
      
    }
    
    @Test
    public void Exercice16() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(l) FROM Lien l JOIN l.film f, f.genre g, f.pays p Where (g.nom='Policier') AND (p.nom='USA')");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 16   Le nombre total de liens pour nos films policiers américains = "+nbFilms);
      
    }
    
    @Test
    public void Exercice17() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(l) FROM Lien l JOIN l.film f, f.genre g, f.acteurs a Where (g.nom='Horreur') AND (a.nom='Polanski')");
        long nbFilms = (long) query.getSingleResult();
        
        System.out.println("EX 17   Le nombre totals de liens pour nos films d'horreur interprétés par Polanski = "+nbFilms);
      
    }    
    
    @Test
    public void Exercice18() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT f FROM Film f JOIN f.genre g Where g.nom='Horreur' EXCEPT SELECT f FROM Film f JOIN f.acteurs a Where a.nom='Polanski' ");
        long nbFilms = (long) query.getResultList().size();
        
        System.out.println("EX 18   Tous les films d'horreur, sauf ceux interprétés par Polanski = "+nbFilms);
      
    }   
    
    @Test
    public void Exercice19() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT f FROM Film f INTERSECT SELECT f FROM Film f JOIN f.acteurs a Where a.nom='Polanski' ");
        long nbFilms = (long) query.getResultList().size();
        
        System.out.println("EX 19   Parmi tous les films, uniquement ceux interprétés par Polanski = "+nbFilms);
      
    }   
    
    @Test
    public void Exercice20() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT f FROM Film f JOIN f.acteurs a Where a.nom='Polanski' UNION SELECT f FROM Film f JOIN f.genre g Where g.nom='Horreur'  ");
        long nbFilms = (long) query.getResultList().size();
        
        System.out.println("EX 20   Tous les films interprétés par Polanski et aussi tous les films d'horreur = "+nbFilms);
      
    }   
    
    @Test
    public void Exercice21() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f),g.nom FROM Film f JOIN f.genre g GROUP BY g.nom ");
        List<Object[]> films = query.getResultList();
        
        System.out.println("EX 21   Le nombre de films réalisés pour chaque genre = ");
        for (Object[] film : films) 
            System.out.println(film[0]+" : "+film[1]);
      
    }
    
    @Test
    public void Exercice22() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) AS nb,r.nom,r.prenom FROM Film f JOIN f.realisateurs r GROUP BY r ORDER BY nb ASC, r.nom ASC, r.prenom ASC ");
        List<Object[]> films = query.getResultList();
        
        System.out.println("EX 22  Le nombre de films réalisés pour chaque réalisateur, triés par ordre croissant puis par ordre alphabétique = ");
        for (Object[] film : films) 
            System.out.println(film[0]+" : "+film[1]+" : "+film[2]);
      
    }
    
    @Test
    public void Exercice23() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(f) AS nb,r.nom,r.prenom FROM Film f JOIN f.realisateurs r GROUP BY r  HAVING nb >=2");
        List<Object[]> films = query.getResultList();
        
        System.out.println("EX 23   Le nombre de films réalisés pour chaque réalisateur, uniquement si >= 2 = ");
        for (Object[] film : films) 
            System.out.println(film[0]+" : "+film[1]+" : "+film[2]);
    }
    
    @Test
    public void Exercice24() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT serie.titre, count(serie) AS nb FROM Serie serie JOIN serie.saisons saison GROUP BY serie ORDER BY nb, serie.titre");
        List<Object[]> films = query.getResultList(); 
        
        System.out.println("EX 24   Le nombre total de saisons pour chaque série, triés par ordre croissant de saisons, puis par ordre alphabétique = ");
        for (Object[] film : films) 
            System.out.println(film[0]+" : "+film[1]);
      
    }
    
    
    @Test
    public void Exercice25() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT count(epi) AS nb,se.titre FROM Serie se JOIN se.saisons sa JOIN sa.episodes epi GROUP BY se HAVING nb>5 ORDER BY nb ");
        List<Object[]> films = query.getResultList();
        
        System.out.println("EX 25   Le nombre total d'épisodes pour chaque série, pour peu qu'il y ait plus de 5 épisodes au total. Le tout trié par nbre d'épisodes = ");
        for (Object[] film : films) 
            System.out.println(film[0]+" : "+film[1]);
      
    }
    
}