package com.ib.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PageClient")
public class PageClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PRIVATE_PATH = "/WEB-INF/connect.jsp";
       

    public PageClient() {
        super();
        
    }

	// redirection vers la page client
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( PRIVATE_PATH ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
