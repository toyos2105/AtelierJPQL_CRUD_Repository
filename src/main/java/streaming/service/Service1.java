/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author formation
 */
@Service
public class Service1 {
    @Autowired
    private JournalService journalService;
    
    public void ajouter(){
        journalService.journaliser("Ajouter");
    }
    
    public void modifier(){
        journalService.journaliser("Modifier");
    }
    
    public void supprimer(){
        
    }
    
    public List lister(){
        
        return new ArrayList();
    }
    
    public Object rechercher(long id){
     
        return null;
    }
}
