package com.ib.bank;

import java.awt.Component;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.ib.beans.User;

import com.ib.beans.Utilitairefct;

@WebServlet("/BankLogin")
public class BankLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// D�claration des variables qui vont nous permettre d'utiliser nos methodes
	private static final String PUBLIC_PATH ="/noConnect.jsp" ;
	
   
    public BankLogin() {
        super();
        
    }

	// cette servlet permet de se connecter sur les espaces clients et conseiller en fonction de l'ID. Les fonctions qui permettent cette redirection se trouve dans User et Utilitairesfct
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( PUBLIC_PATH ).forward( request, response );		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//cr�ation d'une map  myCliendIDPass qui va recup�rer les id et les mots de passe des utiliseurs pr�sents dans la table sac_person gr�ce � la fonction getClientIDPassword pr�sente dans la classe User
		HashMap<String, String> myClientIDPass = new HashMap<String,String>();
		myClientIDPass = User.getClientIDPassword();
		
		//Test de la correspondance entre l'ID et le mot de passe entr�s par le client avec ceux de la MAP myCliendIDPass qui correspondent � ceux de la base de donn�e dans la table sac_person
		if (Utilitairefct.passcheck(myClientIDPass, request.getParameter("clientIdLogin"),request.getParameter("passwordLogin"))==true){
			
			//g�n�ration d'un acces_token que l'on ajoute � la base de donn�e gr�ce � la fonction Ajout_Access � l'id correspondant
			SecureRandom rnd = new SecureRandom();
			String Acces_token1 = new BigInteger(130, rnd).toString(32);
            User.Ajout_Access(Acces_token1, request.getParameter("clientIdLogin"));
            
            //cr�ation d'un Cookie qui va stocker l'acces Token pendant 24H et ajout de ce cookie � la HttpServletRespone 
	        Cookie myCookie2 = new Cookie("key", Acces_token1);
	        myCookie2.setMaxAge(24*60*60);
	        response.addCookie(myCookie2);
			

	        //une fois que le passcheck est valid�, on va regard� si l'utilisateur est un client ou un conseiller gr�ce � la fonction isAdvisor et on va redirig� l'utilisateur en fonction de son statut
			HashMap<String, Integer> whoIsPersonnMap = new HashMap<String,Integer>();
			whoIsPersonnMap = User.getPerson_is_advisor();
			boolean whoIsPersonn = Utilitairefct.isAdvisor (whoIsPersonnMap,request.getParameter("clientIdLogin")); 
			 	if (whoIsPersonn == true ){
			 		
			 		response.sendRedirect("http://localhost:8080/Bank/BankConnect");//redirection vers la page Connect� pour les clients
			 	} else {
			 		System.out.println("conseiller");
			 		response.sendRedirect("http://localhost:8080/Bank/EspaceConseiller");//redirection vers la page Connect� pour les conseillers
			 	}
	        
		}else{
			this.getServletContext().getRequestDispatcher( PUBLIC_PATH ).forward( request, response );
			//System.out.println("Encore dans mapage");
			//request.setAttribute("ton_message",tonChampMessage);
			//afficher un message d'erreur
			
		}
		
		
	}

}
