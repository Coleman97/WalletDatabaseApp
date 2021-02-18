/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walletdbapplication;

import java.sql.*;

/**
 *
 * @author Nrg_ColdColean
 */
public class WalletDBApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //uncomment methods to run them individually
        RetrievesData rd = new RetrievesData();
        //rd.getAllUser();
        //rd.getAUserDetail();
       // rd.getAllWallets();
        //rd.getAWalletDetail();
        //rd.getCounts();
        rd.sendMoney();
        
        
      
    }
    
}
