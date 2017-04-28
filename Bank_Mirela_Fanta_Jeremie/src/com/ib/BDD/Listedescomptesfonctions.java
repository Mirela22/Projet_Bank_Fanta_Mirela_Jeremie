package com.ib.BDD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Listedescomptesfonctions {

	public static HashMap<int,String> getListeDesComptes(int IdClient){
	        
	        //cette fonction parcoure la bdd et retourne tous les compte lié à l'ID mis en paramètres
	        
	        HashMap<String, String> ListeDesComptes = new HashMap<String,String>();
	        
	        try{
	            
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("Driver ok");
	            
	            Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
	            System.out.println("Connexion ok");
	            
	            Statement stat = (Statement)cnx.createStatement();
	            System.out.println("Statement ok");
	            System.out.println("------------------");
	          
	            stat.executeQuery("SELECT person_external_id,person_token From sac_accounts");
	            ResultSet resultat = stat.executeQuery("SELECT person_external_id,person_token From sac_accounts");
	            
	            String query = "SELECT * From sac_accounts where account_customer_id = "+ IdClient;
	          
	           while(resultat.next()){
	               
	               System.out.print(resultat.getObject(2)+" "); //account_customer_id
	              
	               int ClientID = (int)resultat.getObject(1);
	               String account_customer_id = (String)resultat.getObject(2);
	              
	               ListeDesComptes.put(IdClient, account_customer_id);
	               System.out.println();
	           }
	           resultat.close();
	           stat.close();
	           cnx.close();
	            
	        }catch(Exception e){
	            System.out.println("erreur");
	        }
	        return ListeDesComptes;
	        // A TERMINER
	    }
	
}
