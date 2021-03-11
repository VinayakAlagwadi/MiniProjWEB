package com.ltts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.dao.AuctionDAO;
import com.ltts.model.Auction;
import com.ltts.model.Player;
import com.ltts.model.Team;


/**
 * Servlet implementation class AuctionServlet
 */
@WebServlet("AuctionServlet")
public class AuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionServlet() {
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
		
		int aid=Integer.parseInt(request.getParameter("aid"));
		int apid=Integer.parseInt(request.getParameter("apid"));
		int atid=Integer.parseInt(request.getParameter("atid"));
		String ayear=request.getParameter("ayear");
		double aprice =Double.parseDouble(request.getParameter("aprice"));
		
		
		Player p=new Player(apid, null, null, null, 0, 0, 0, null, 0, 0);
		Team t= new Team(atid,null,null,null,0);
		Auction a=new Auction(aid,apid,atid,ayear,aprice);
		
		System.out.println("Inside Servlet: "+a);
		AuctionDAO pd=new AuctionDAO();
		boolean b=false;
		
		RequestDispatcher rd=null;
		try {
			b=pd.insertAuction(a,p,t); // Control TRanfers to Dao file
			rd=request.getRequestDispatcher("Success2.html");
			rd.forward(request, response);
			System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("auction.html");
			rd.include(request, response);
			e.printStackTrace();
		}
		
	}
	}


