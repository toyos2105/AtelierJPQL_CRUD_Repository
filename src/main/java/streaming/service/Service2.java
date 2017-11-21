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
public class Service2 {
 
    public void ajouter(){
     
        System.out.println("***ajouter");
    }
    
    public void modifier(){
        
    }
    
    public void supprimer(){
        
    }
    
    public List lister(){
        System.out.println("***lister");
        return new ArrayList();
        
    }
    
    public Object rechercher(long id){
     
        return null;
    }
}
