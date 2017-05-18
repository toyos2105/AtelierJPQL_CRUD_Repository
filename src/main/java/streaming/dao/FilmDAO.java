/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Film;

/**
 *
 * @author formation
 */
public interface FilmDAO extends CrudRepository<Film, Long>{
    
    @Query("   SELECT   r.nom, r.prenom, COUNT(f) AS total "
            + "FROM     Film f "
            + "         JOIN f.realisateurs r "
            + "GROUP BY r.id "
            + "HAVING total>=2 ")
    public Object[][] req23();
    
    @Query("   SELECT   r.prenom, r.nom, COUNT(f) AS total "
            + "FROM     Film AS f "
            + "         JOIN f.realisateurs r "
            + "GROUP BY r "
            + "ORDER BY total, r.nom, r.prenom   ")
    public Object[][] req22();
    
    @Query("   SELECT   g.nom, COUNT(f) "
            + "FROM     Film f "
            + "         JOIN f.genre g "
            + "GROUP BY g")
    public Object[][] req21();
    
    @Query("   SELECT   f "
            + "FROM     Film f "
            + "         JOIN f.acteurs a "
            + "WHERE    a.nom=?1 "
            + "UNION "
            + "SELECT   f "
            + "FROM     Film f "
            + "         JOIN f.genre g "
            + "WHERE    g.nom=?2")
    public List<Film> req20(String nomActeur, String nomGenre);
    
    public List<Film> findAllByActeursNom(String nom);
    
    @Query("   SELECT   f "
            + "FROM     Film f "
            + "         JOIN f.acteurs a "
            + "INTERSECT "
            + "SELECT   f "
            + "FROM     Film f "
            + "         JOIN f.acteurs a "
            + "WHERE    a.nom=?1")
    public List<Film> req19(String nomActeur);
    
    @Query("   SELECT   f "
            + "FROM     Film f "
            + "         JOIN f.genre g "
            + "WHERE    g.nom=?1 "
            + "EXCEPT "
            + "SELECT   f "
            + "FROM     Film f "
            + "         JOIN f.acteurs a "
            + "WHERE    a.nom=?2")
    public List<Film> req18(String nomGenre, String nomActeur);
    
    @Query("   SELECT   COUNT(f) "
            + "FROM     Film f "
            + "         JOIN f.realisateurs r1 "
            + "         JOIN f.realisateurs r2 "
            + "         JOIN f.acteurs a "
            + "         JOIN f.genre g "
            + "WHERE    r1.nom=?1 "
            + "         AND r1.prenom=?2 "
            + "         AND r2.nom=?3 "
            + "         AND r2.prenom=?4 "
            + "         AND a.nom=?5 "
            + "         AND a.prenom=?6 "
            + "         AND g.nom=?7")
    public long req12(String nomReal1, String prenomReal1, String nomReal2, String prenomReal2, String nomActeur, String prenomAct, String genre);
    
    @Query("   SELECT   COUNT(f) "
            + "FROM     Film f "
            + "         JOIN f.realisateurs r1 "
            + "         JOIN f.realisateurs r2 "
            + "         JOIN f.acteurs a "
            + "WHERE    r1.nom=?1 "
            + "         AND r1.prenom=?2 "
            + "         AND r2.nom=?3 "
            + "         AND r2.prenom=?4 "
            + "         AND a.nom=?5 "
            + "         AND a.prenom=?6")
    public long req11(String nomReal1, String prenomReal1, String nomReal2, String prenomReal2, String nomActeur, String prenomAct);
    
    @Query("SELECT COUNT(f) FROM Film f JOIN f.realisateurs r JOIN f.realisateurs r2 WHERE r.nom=?1 AND r.prenom=?2 AND r2.nom=?3 AND r2.prenom=?4")
    public long compterFilmsRealisesPar2RealSimulatnement(String nom1, String prenom1, String nom2, String prenom2);
    
    public long countByRealisateursNomAndRealisateursPrenom(String nom, String prenom);
    
    public Film findOneByGenreNomAndPaysNomAndRealisateursNomAndRealisateursPrenom(String genre, String pays, String nomReal, String prenomReal);
    
    public long countByRealisateursNomAndActeursNom(String nomReal, String nomAct);
    
    @Query("SELECT COUNT(f) FROM Film f JOIN f.acteurs a WHERE a.nom=?1")
    public long compteFilmsParNomActeur(String n);
    
    public long countByActeursNom(String n);
}
