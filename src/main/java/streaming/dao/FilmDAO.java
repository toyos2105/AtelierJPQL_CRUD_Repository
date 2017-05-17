/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Film;

/**
 *
 * @author formation
 */
public interface FilmDAO extends CrudRepository<Film, Long>{
    
    @Query("SELECT COUNT(f) FROM Film f JOIN f.realisateurs r JOIN f.realisateurs r2 WHERE r.nom=?1 AND r.prenom=?2 AND r2.nom=?3 AND r2.prenom=?4")
    public long compterFilmsRealisesPar2RealSimulatnement(String nom1, String prenom1, String nom2, String prenom2);
    
    public long countByRealisateursNomAndRealisateursPrenom(String nom, String prenom);
    
    public Film findOneByGenreNomAndPaysNomAndRealisateursNomAndRealisateursPrenom(String genre, String pays, String nomReal, String prenomReal);
    
    public long countByRealisateursNomAndActeursNom(String nomReal, String nomAct);
    
    @Query("SELECT COUNT(f) FROM Film f JOIN f.acteurs a WHERE a.nom=?1")
    public long compteFilmsParNomActeur(String n);
    
    public long countByActeursNom(String n);
}
