package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SignupDao;
import com.dao.checkoutDAO;


@WebServlet("/checkout")
public class checkoutServlet extends HttpServlet
{  
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	
		
		
		
		String displayName =request.getParameter("displayName");
		String userName =request.getParameter("userName");
		String password =request.getParameter("password");
		String conformPassword=request.getParameter("conformPassword");
		String companyName=request.getParameter("companyName");
		String email=request.getParameter("email");
		String title=request.getParameter("title");
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String address1=request.getParameter("address1");
		String address2=request.getParameter("address2");
		String postalCode=request.getParameter("postalCode");
		String phone=request.getParameter("phone");
		String mobilePhone=request.getParameter("mobilePhone");
		String fax=request.getParameter("fax");
		   
		   

	checkoutDAO checkoutDAO=new checkoutDAO();
	checkoutDAO.checkout(displayName, userName, password, conformPassword, companyName, email, title, firstName, middleName, lastName, address1, address2, postalCode, phone, mobilePhone, fax);
	 
	}

}
