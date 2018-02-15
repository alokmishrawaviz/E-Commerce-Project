package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.loginDao;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
        String password= request.getParameter("password");
		
        /*
        
        PrintWriter printWriter=response.getWriter();
        
        if(username.equals(password)){
        	//printWriter.print("Loggin Sucess");
        	
        	 System.out.println("Loggin Sucess");
        	response.sendRedirect("index.jsp");
        	
        }else{
        	//printWriter.print("Pls Email and Password  fill Same");
        	response.sendRedirect("login.jsp");

        	 System.out.println("Pls Enetr Email and Password Same..");
        }
        
        */
        
        
        loginDao ld=new loginDao();
    	int login=ld.connectionCode(username,password);
    	if(login==1){
    		response.sendRedirect("index.jsp");
    		
    	}
    	else{
    			response.sendRedirect("login.jsp");

    		}

        
        
        
        
        
	}

}
