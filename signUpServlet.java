package com.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SignupDao;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/signUp")
public class signUpServlet extends HttpServlet implements Servlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String user=request.getParameter("username");
			String mail=request.getParameter("email");
			String pass=request.getParameter("password");
			System.out.println(user);
			System.out.println(user);
			SignupDao dao=new SignupDao();
	 int returnofDao =dao.signup(user, mail, pass);
	   if(returnofDao>0){
		   response.sendRedirect("index.jsp");
	   }else{
		   response.sendRedirect("login.jsp");
	   }
		}

}
