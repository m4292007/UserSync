package com.admaru.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
@WebServlet("/udb")
public class udb extends HttpServlet {

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String cookie_value = "";
    	
		System.out.println("check cookie");
		Cookie[] cookies=request.getCookies(); 
	    if(cookies!=null){
	        for (Cookie c : cookies) {
	            String name = c.getName(); 
	            String value = c.getValue();
	            
	            System.out.println(name+":"+value);
	             
	            if (name.equals("toast_user_id")) {
	            	System.out.println("cookie found");
	            	cookie_value = value;
	            }
	        }
	    }
		
		if ("".equals(cookie_value)) {
			UUID one = UUID.randomUUID();
			response.setHeader("Set-Cookie", "toast_user_id="+one.toString()+"; Secure; SameSite=None;Max-Age="+60*60*24*365);
		} else {
			//response.setHeader("Set-Cookie", "toast_user_id="+cookie_value+"; Secure; SameSite=None;Max-Age="+60*60*24*365);
		}
		response.getWriter().append(cookie_value);
	}
	

    public udb() {
        super();
    }
	
}