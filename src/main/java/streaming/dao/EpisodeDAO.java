/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Episode;

/**
 *
 * @author formation
 */
public interface EpisodeDAO extends CrudRepository<Episode, Long>{
    
    @Query("   SELECT   s.titre, COUNT(ep) AS total "
            + "FROM     Episode ep "
            + "         JOIN ep.saison.serie s "
            + "GROUP BY s.id "
            + "HAVING   total>=5 "
            + "ORDER BY total")
    public Object[][] req25();
    
    public long countBySaisonNumSaisonAndSaisonSerieTitre(int numSaison, String titreSerie);
    
    public long countBySaisonSerieTitre(String titreSerie);
}
