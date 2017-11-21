/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import streaming.service.JournalService;

/**
 *
 * @author formation
 */
@Component
@Aspect
public class JournalisationAspect {
    
    @Autowired
    private JournalService service;
    
    @Before("execution( * streaming.service.*.ajouter(..) )")
    // Avant l'exécution ce ce qui est entre parenthèses
    // le 1er * dit que je traite tout ce qui est retourné.
    // et on l'applique au reste de la parenthèse
    // On réalise la fonction en dessous
    public void avant(JoinPoint jp){
        
        throw new RuntimeException("Operation interdite");
    }
}
