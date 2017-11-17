/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.component;

import org.springframework.stereotype.Component;

/**
 *
 * @author Formation
 */
@Component
public class ATMBidon  implements Parent{

    @Override
    public void Transfert(int idCompte1, int idCompte2, int montant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    public void affiche()
//    {
//        System.err.println("Composant2");
//    }
}
