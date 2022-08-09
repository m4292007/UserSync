package com.admaru.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

 
@WebServlet("/getUID")
public class getUID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getUID() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = getCookie(request);
		response.getWriter().append(uid);
	}
	
	public String getCookie(HttpServletRequest req){
	    Cookie[] cookies=req.getCookies(); 
	    
	    if(cookies!=null){
	    	
	        for (Cookie c : cookies) {
	            String name = c.getName(); 
	            String value = c.getValue();
	            
	            System.out.println(name+":"+value);
	             
	            if (name.equals("toast_user_id")) {
	                return value;
	            }
	        }
	    }
	    return null;
	}

}