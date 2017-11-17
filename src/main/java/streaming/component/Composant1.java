/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Formation
 */
@Component
//@Scope(value="prototype")    Passe du mode singleton au mode tous différents
public class Composant1 {
    @Autowired
    private Composant2 composant2;
    
    public void affiche(){
        composant2.affiche();
    }
    
}
