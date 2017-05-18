/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import org.springframework.data.repository.CrudRepository;
import streaming.entity.Lien;

/**
 *
 * @author formation
 */
public interface LienDAO extends CrudRepository<Lien, Long>{
    
    public long countByFilmGenreNomAndFilmActeursNom(String nomgGenre, String acteurNom);
    
    public long countByFilmGenreNomAndFilmPaysNom(String nomGenre, String nomPays);
    
    long countByFilmTitre(String t);
}
