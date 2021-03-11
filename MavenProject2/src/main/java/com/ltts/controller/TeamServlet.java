package com.ltts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.dao.TeamDAO;
import com.ltts.model.Team;


/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
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
		int tid=Integer.parseInt(request.getParameter("tid"));
		String name=request.getParameter("tname");
		String oname=request.getParameter("oname");
		String cname=request.getParameter("cname");
		int cid =Integer.parseInt(request.getParameter("cid"));
		
		
		
		
		Team t=new Team(tid,name,oname,cname,cid);
		System.out.println("Inside Servlet: "+t);
		TeamDAO pd=new TeamDAO();
		boolean b=false;
		
		RequestDispatcher rd=null;
		try {
			b=pd.insertTeams(t); // Control TRanfers to Dao file
			rd=request.getRequestDispatcher("Success1.html");
			rd.forward(request, response);
			System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("team.html");
			rd.include(request, response);
			e.printStackTrace();
		}
		
	}

	}


