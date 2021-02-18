/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walletdbapplication;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Nrg_ColdColean
 */
public class RetrievesData extends Variables {
    //method call for the data of all users in the database
    public void getAllUser(){
         String query = "Select * from USERDETAILSTABLE";
          try{
            myConnect = DriverManager.getConnection(url, username, password);
            myStatement = myConnect.createStatement();
            myResult = myStatement.executeQuery(query);
            myMetadata = myResult.getMetaData();
           System.out.print(myMetadata.getColumnName(1) +"\t     "+myMetadata.getColumnName(2) +"\t             "+myMetadata.getColumnName(3) +"\t    ");
        
            System.out.println();
            while(myResult.next()){
                int ID = myResult.getInt("UserID");
                String FullName = myResult.getString("FullName");
                String Address = myResult.getString("Address");
                System.out.println(ID +"\t     " + FullName +"\t     "+ Address);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //retrieves a user details and his list of wallets plus all transaction history.
    public void getAUserDetail(){
        String query = "Select userdetailstable.UserID,walletdetails.WalletID, walletdetails.Type, transactiontable.TransactID,transactiontable.Amount, transactiontable.DateOfTransaction,"
                + "transactiontable.Time,transactiontable.SenderName,transactiontable.RecieverName,transactiontable.TransactionStatus "
                + "from userdetailstable Join walletdetails ON userdetailstable.UserID = walletdetails.UserID Join transactiontable "
                + " ON userdetailstable.UserID  = transactiontable.UserID "
                + "where userdetailstable.UserID =101 ";
        try{
            myConnect = DriverManager.getConnection(url, username, password);
            myStatement = myConnect.createStatement();
            myResult = myStatement.executeQuery(query);
            myMetadata = myResult.getMetaData();
            int columns = myMetadata.getColumnCount();
            for(int i =1;i <=columns;i++){
           System.out.print(myMetadata.getColumnName(i)+"\t     ");
            }
           System.out.println();
           
           while(myResult.next()){
                      for(int i = 1;i<=columns;i++){
                      System.out.print(myResult.getObject(i)+"\t   " );
                                 }
                      System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //returns details of all wallets in the wallet table
    public void getAllWallets(){
        String query = "Select * from WALLETDETAILS";
          try{
            myConnect = DriverManager.getConnection(url, username, password);
            myStatement = myConnect.createStatement();
            myResult = myStatement.executeQuery(query);
            myMetadata = myResult.getMetaData();
           int columns = myMetadata.getColumnCount();
            for(int i =1;i <=columns;i++){
           System.out.print(myMetadata.getColumnName(i)+"\t  ");
            }
           System.out.println();
 
            while(myResult.next()){
                   for(int i = 1;i<=columns;i++){       
                System.out.print(myResult.getObject(i)+"\t     " );
                      }
                      System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //retrieves a wallet detail that include owner,type of wallet and transaction history
    public void getAWalletDetail(){
            String query = "Select walletdetails.WalletID, userdetailstable.fullname,walletdetails.Type, transactiontable.TransactID,transactiontable.Amount, transactiontable.DateOfTransaction,"
                + "transactiontable.Time,transactiontable.SenderName,transactiontable.RecieverName,transactiontable.TransactionStatus "
                + "from userdetailstable Join walletdetails ON userdetailstable.UserID = walletdetails.UserID Join transactiontable "
                + " ON userdetailstable.UserID  = transactiontable.UserID "
                + "where WalletID =122003";
          try{
            myConnect = DriverManager.getConnection(url, username, password);
            myStatement = myConnect.createStatement();
            myResult = myStatement.executeQuery(query);
            myMetadata = myResult.getMetaData();
            int columns = myMetadata.getColumnCount();
            for(int i =1;i <=columns;i++){
           System.out.print(myMetadata.getColumnName(i)+"\t  ");
            }
           System.out.println();
 
            while(myResult.next()){
                   for(int i = 1;i<=columns;i++){       
                System.out.print(myResult.getObject(i)+"\t     " );
                      }
                      System.out.println();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void getCounts(){
        //retrieves the count of all user for the user table
         try{ 
            String query ="Select count(*) from userdetailstable";
            myConnect = DriverManager.getConnection(url, username, password);
            myStatement = myConnect.createStatement();
            myResult = myStatement.executeQuery(query);
            myMetadata = myResult.getMetaData();
                    while(myResult.next()){
                       int countOfusers = myResult.getInt(1);
                                 System.out.println("Count of Users:  " + countOfusers);
                    }
    }catch(SQLException e){
        e.printStackTrace();
    }
         //retrieves count of all wallet in the wallet details table
         try{
             String query ="Select count(*) from walletdetails";
             myConnect = DriverManager.getConnection(url, username, password);
             myStatement = myConnect.createStatement();
             myResult = myStatement.executeQuery(query);
             myMetadata = myResult.getMetaData();
                     while(myResult.next()){
                                 int countOfwallets = myResult.getInt(1);
                                 System.out.println("Count of Wallets:  " + countOfwallets);
                    }
         }catch(SQLException e){
             e.printStackTrace();
         }
 
         // retrieves sum of all wallet balance in the wallet table
           try{
             String query ="Select sum(walletbalance) from walletdetails";
             myConnect = DriverManager.getConnection(url, username, password);
             myStatement = myConnect.createStatement();
             myResult = myStatement.executeQuery(query);
             myMetadata = myResult.getMetaData();
                     while(myResult.next()){
                                 int totalwalletbalance = myResult.getInt(1);
                                 System.out.println("Total wallet balance:  " + totalwalletbalance);
                    }
         }catch(SQLException e){
             e.printStackTrace();
         }
 }
    
    //sends money from one wallet to amother
    public void sendMoney(){
        try{
             String query = "update walletdetails set walletbalance = walletbalance - 4000 where walletid =122003";
             myConnect = DriverManager.getConnection(url, username, password);
             myStatement = myConnect.createStatement();
             myStatement.executeUpdate(query);
            System.out.println("Amount sent has been deducted from wallet");             
         }catch(SQLException e){
             e.printStackTrace();
         }
        try{
             String query = "update walletdetails set walletbalance = walletbalance + 4000 where walletid =122004";
             myConnect = DriverManager.getConnection(url, username, password);
             myStatement = myConnect.createStatement();
             myStatement.executeUpdate(query);
            System.out.println("Amount sent has been added to wallet");             
         }catch(SQLException e){
             e.printStackTrace();
         }
    }
}


        
