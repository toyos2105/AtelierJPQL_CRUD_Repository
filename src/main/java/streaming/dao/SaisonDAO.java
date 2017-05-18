/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Saison;

/**
 *
 * @author formation
 */
public interface SaisonDAO extends CrudRepository<Saison, Long>{
    
    @Query("   SELECT   se.titre, COUNT(sa) total "
            + "FROM     Saison sa "
            + "         JOIN sa.serie se "
            + "GROUP BY se "
            + "ORDER BY total, se.titre")
    public Object[][] req24();
    
    public long countBySerieTitre(String t);
}
