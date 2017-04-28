package com.ib.BDD;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import com.ib.client.ListeCompte;

@WebServlet("/ListeDesComptes")
public class ListeDesComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListeDesComptes() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Client/ListesDesComptes.jsp" ).forward( request, response );
		
		/*
		 Ici on appelle la fonction qui va recuperer la liste des comptes en parcourant la table et en recuperant tout les comptes lié à l'ID mis en paramètre qui va être lié à l'ID entré par l'utilisateur
		  
		 */
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
