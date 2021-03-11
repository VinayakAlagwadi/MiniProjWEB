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
 * Servlet implementation class loginServlet
 */

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String uname=request.getParameter("name");
		
		String upass=request.getParameter("pass");
		
		User v = new User(uname,upass);
		
		
		System.out.println("Inside Servlet: "+v);
		
		UserDAO ud = new UserDAO();
	
		try {
		
			boolean b =	ud.checkUser(v);
			
		if(b==true) {
			System.out.println("login passed");
			
			
		}
		if(b==false) {
			System.out.println("login failed");
			
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Control TRanfers to Dao file
			//System.out.println("Successfully Inserted...");
	
		
	}

}
