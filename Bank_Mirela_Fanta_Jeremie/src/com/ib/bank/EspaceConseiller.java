package com.ib.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EspaceConseiller
 */
@WebServlet("/EspaceConseiller")
public class EspaceConseiller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PRIVATECONS_PATH = "/WEB-INF/Conseiller/connectconseiller.jsp";	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspaceConseiller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// redirection vers le page conseiller connect�
		this.getServletContext().getRequestDispatcher( PRIVATECONS_PATH ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
