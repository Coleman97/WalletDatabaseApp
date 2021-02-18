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
public class Variables {
    String url = "jdbc:derby://localhost:1527/WallectConrolDB";
        String username  = "Tobicolez";
        String password = "messi10barca";
        
        
        Connection myConnect  = null; //For connection to the database
        Statement myStatement = null; //to execute queries affecting the database
        ResultSet myResult = null; // holds derived data gotten aftera query is done or info is fetched.
        ResultSetMetaData myMetadata = null;
     
        
    
}
