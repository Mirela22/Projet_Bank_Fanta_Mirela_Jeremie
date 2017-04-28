package com.ib.beans;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.javafx.collections.MappingChange.Map;

public class Utilitairefct {

	
	// fonction qui renvoie un boolean et qui test si le ID et le mot de passe de l'utilisateur correspond � celui de la base de donn�e
	public static boolean passcheck (HashMap<String,String> ClientIDPassword,String clientIdLogin , String passwordLogin ){ //on prend en param�tre la MAP qui recupere le ID et le MDP de la base de donn�es, et les ID et MDP entr�s par l'utilisateur
		for (String key : ClientIDPassword.keySet() ){ //on parcourt tout les ID de la base de donn�e
				
			if(key.equals(clientIdLogin)){ //lorsque les ID correspondent
				if( passwordLogin.equals(ClientIDPassword.get(key)) ){
					return true; // on renvoie true si les mots de passes correspondent
				
				}else {
					return false; //false si les mots de passe correspondent pas
					
				}
			}else{return false; // on retourne false si les ID ne correspondent pas
			
			}
		}
		return true;	
	}
	

	
	
//fonction qui teste si l'utilisateur est un client ou un conseiller : 
	
	public static boolean isAdvisor (HashMap<String,Integer> ID_Person_is_advisor,String ID_Person){ 
		for (String key : ID_Person_is_advisor.keySet() ){ 
		
			if(key.equals(ID_Person)){
				int a  = ID_Person_is_advisor.get(key);
				
				if( a ==0 ){
					return true; 
				}else {
					return false; 
				}
			}
		}
		return true;	
	}
} 
	
	

