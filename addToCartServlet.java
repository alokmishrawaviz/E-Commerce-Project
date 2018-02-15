package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dto.tshirtDTO;



@WebServlet("/addToCart")
public class addToCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		 int storeId=0;
		 String storeName="";
		 int storePrice=0;
		 PrintWriter pw = response.getWriter();
		 String addToCartProductDetail="";
		 ArrayList<AddToCartFinal> addToCartList = new ArrayList<>();
	HttpSession session=request.getSession();
	 int id =Integer.parseInt(request.getParameter("type"));
	  ArrayList<tshirtDTO> aa=(ArrayList<tshirtDTO>)session.getAttribute("tshirtList");
	  if(aa!=null){
		  System.out.print(aa.size());
		 for(tshirtDTO  l :aa){
		if(l.getId()==id){	 
		 
			  storeId=l.getId();
			   storeName=l.getName();
			    storePrice=l.getPrice();
			    
		}
			   System.out.println(storeId);
			   System.out.println("hello baby..");
			  
		  }
		  
		 
		 //For Printing All product in Servlet
		 String li="";
	    	String productHTML="";
	    	
	    	
	    	/*for(tshirtDTO  l :aa){
			String liHTML = "<li>"+l.getId()
				+" "+l.getName()+" "+l.getPrice()+
			"<BR> <img src='"+l.getImg()+"'>";
				li = li + liHTML;
		
				
	    	}
	    	
	    	
			productHTML = "<ul>"+li+"</ul></br><p>****</p>";
		*/
		//String addToCartProductDetail = "<html><body>"+ productHTML+ "</body></html>";
		//String addToCartProductDetail =  "<form action=''>"+ productHTML+ "</form>";
		
		 
		 
		 
		 try {
			
				Class.forName("com.mysql.jdbc.Driver");	
				
				Connection connection=DriverManager.getConnection( "jdbc:mysql://localhost:3306/project","root","alok");
				//PreparedStatement preparedStatement =connection.prepareStatement("select * from addtocartfinal where storeId=?");
				
				PreparedStatement preparedStatement =connection.prepareStatement
						("select storeId,storeName,storePrice from addtocartfinal"); 
				//preparedStatement.setInt(1, id);
				 ResultSet rs=preparedStatement.executeQuery();
				 
				 while(rs.next()){
					 System.out.println("enter in loop1...");
					 AddToCartFinal addtocartfinal = new AddToCartFinal();
					 addtocartfinal.setStoreId(rs.getInt("storeId"));
					 addtocartfinal.setStoreName(rs.getString("storeName"));
					 addtocartfinal.setStorePrice(rs.getInt("storePrice"));
					 System.out.println("RS Work....");
					 addToCartList.add(addtocartfinal);
				 }
				  for(AddToCartFinal addtocartfinal:addToCartList ){
					  System.out.println("enter in loop....2");
					  if(addtocartfinal.getStoreId()!=storeId){
						  AddToCartFinal addtocartfinal2=new AddToCartFinal();
						  addtocartfinal2.setStoreId(storeId);
						  addtocartfinal2.setStoreName(storeName);
						  addtocartfinal2.setStorePrice(storePrice);
						  addToCartList.add(addtocartfinal2);
						  
					 preparedStatement=(PreparedStatement)connection.prepareStatement("insert into  addtocartfinal values (?,?,?)");
					preparedStatement.setInt(1,storeId); 
					preparedStatement.setString(2,storeName); 
					preparedStatement.setInt(3,storePrice); 
				    int a=preparedStatement.executeUpdate();
				    if(a==1){
				    	System.out.println("succefull enter");
				    	//JOptionPane.showMessageDialog(null, "Your Product Add SucessFully..");
				    	//response.sendRedirect("index.jsp");
				    	for(AddToCartFinal cart:addToCartList){
							String liHTML = "<li>"+cart.getStoreId()
								+" "+cart.getStoreName()+" "+cart.getStorePrice();
							//"<BR> <img src='"+l.getImg()+"'>";
								li = li + liHTML;
						
								
					    	}
					    	
					    	
							productHTML = "<ul>"+li+"</ul></br><p>****</p>";
							addToCartProductDetail = "<html><body>"+ productHTML+ "</body></html>";
							//String addToCartProductDetail =  "<form action=''>"+ productHTML+ "</form>";

				    	pw.print(addToCartProductDetail);
				    }
				    else{
				    	System.out.println("Query missmatch");
				 }
				    }
				 
				    else{
				    	
					  //  System.out.println("Add Duplicate Product");
					    //JOptionPane.showMessageDialog(null, "Add Duplicate Product");
					   // response.sendRedirect("index.jsp");
					    pw.print("this is a duplicate product "+addToCartProductDetail);	
					    	
					    
				    }
			}
		 }catch (Exception e) {
				System.out.println(e);
			}
	  }
	
	

	

}
}