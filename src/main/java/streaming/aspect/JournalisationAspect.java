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
//@Aspect
public class JournalisationAspect {
    
    @Autowired
    private JournalService service;
    
    @Before("execution(* streaming.service.*.ajouter(..)) "
            + "or execution(* streaming.service.*.modifier(..)) "
            + "or execution(* streaming.service.*.supprimer(..))")
    public void avant(JoinPoint jp){
        
        service.journaliser( jp.toString() );
    }
}
