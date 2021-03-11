package com.ltts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.dao.PlayerDAO;
import com.ltts.model.Player;


/**
 * Servlet implementation class UpdatePlayerServlet
 */
@WebServlet("UpdatePlayerServlet")
public class UpdatePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
PrintWriter out = response.getWriter();  
		
		int no=Integer.parseInt(request.getParameter("pno"));
		
		int matches = Integer.parseInt(request.getParameter("pmatches"));
		int runs = Integer.parseInt(request.getParameter("pruns"));
		int wicket = Integer.parseInt(request.getParameter("pwickets"));
		
		// Player p1 = new Player();
		Player p=new Player(no,null,null,null,matches,runs,wicket,null,0,0);
		System.out.println("Inside Servlet: "+p);
		PlayerDAO pd=new PlayerDAO();
		boolean b=false;
		
		RequestDispatcher rd=null;
		try {
			b= pd.updatePlayerRunsandWik(p); // Control TRanfers to Dao file
			rd=request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
			System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("addplayer.html");
			rd.include(request, response);
			e.printStackTrace();
		}
		
	}

	}


