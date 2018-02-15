package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dao.tshirtDao;
import com.dto.tshirtDTO;



@WebServlet("/tshirt")
public class tshirtServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws
	ServletException, IOException {

		HttpSession session =request.getSession();
		
		System.out.println(request.getParameter("type"));
	
	
	   
	

		ArrayList<tshirtDTO> tshirtList = null;
	
		tshirtDao tshirtDao=new tshirtDao();
		
		try {
			tshirtList	 = tshirtDao.getTshirts();
			
		
		String tshirtHTML = "";
		
		if(tshirtList!=null && tshirtList.size()>0){
			String li = "";
			
			for(tshirtDTO tshirt : tshirtList){
				String liHTML = "<li>"+tshirt.getId()
				+" "+tshirt.getName()+" "+
				"<BR> <img src='"+tshirt.getImg()+"'>"
				+"<BR> "+tshirt.getPrice()+"</li>"+
				"<BR> "+tshirt.getType()+"</li>";
				li = li + liHTML;
			}
			tshirtHTML = "<ul>"+li+"</ul>";
			String logout =  "<form action=''>"
			//+ "<form action='logout'>"
			+ ""
			+ tshirtHTML+ "</form>";
	
//	session.setMaxInactiveInterval(10*60);
	
			session.setAttribute("tshirtList", tshirtList);
			response.sendRedirect("index.jsp");
response.setContentType("text/html");	
PrintWriter out=response.getWriter();
//out.println(logout);
//out.println	(tshirtHTML);

		}
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

