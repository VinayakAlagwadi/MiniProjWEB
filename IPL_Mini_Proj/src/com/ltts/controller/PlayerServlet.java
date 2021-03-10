package com.ltts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.Dao.PlayerDAO;
import com.ltts.model.Player;
import com.ltts.*;



/**
 * Servlet implementation class PlayerServlet
 */
@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PlayerServlet() {
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
int pid=Integer.parseInt(request.getParameter("Player_id"));
		
		String pname=request.getParameter("Player_name");
		
		String pdob=request.getParameter("Player_DOB");
		
		String pskill=request.getParameter("skill");
		
		
		int pruns=Integer.parseInt(request.getParameter("runs"));
		
		int pwkts=Integer.parseInt(request.getParameter("wickets"));
		
		int pnom=Integer.parseInt(request.getParameter("matches"));
		
		String pnat=request.getParameter("nation");
		
		double pr=Double.parseDouble(request.getParameter("power"));
		
		int ptid=Integer.parseInt(request.getParameter("Player_id"));
		
		
		
		
		
		
		
		
		
		
		
		
		Player p=new Player(pid,pname,pdob,pskill,pruns,pwkts,pnom,pnat,pr,ptid);
		
		System.out.println(p);
		
		System.out.println("Inside Servlet: "+p);
		
		PlayerDAO pd=new PlayerDAO();
	
		try {
			pd.insertPlayer(p);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Control TRanfers to Dao file
			System.out.println("Successfully Inserted...");
	
	
		
		
	}

}
