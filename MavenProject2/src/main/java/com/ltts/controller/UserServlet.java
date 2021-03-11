package com.ltts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ltts.dao.UserDAO;
import com.ltts.model.User;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//int pid=Integer.parseInt(request.getParameter("Player_id"));
		
		String uname=request.getParameter("name");
		
		String upass=request.getParameter("pass");
		
		User u = new User(uname,upass);
		
		
		System.out.println("Inside Servlet: "+u);
		
		UserDAO ud = new UserDAO();
	
		try {
			ud.insertUser(u);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Control TRanfers to Dao file
			//System.out.println("Successfully Inserted...");
	
	
		
		
	}
		
		
		
		
		
	}

