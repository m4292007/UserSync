package com.admaru.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admaru.util.*;

@WebServlet("/uid")
public class uid extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public uid() {
        super();
    }
	 
	// TODO redis에 기록
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			String p_id = StrUtil.nvl(request.getParameter("p_id"),"");
			String u_id = StrUtil.nvl(request.getParameter("u_id"),"");
			System.out.println("p_id="+p_id+":u_id="+u_id);
			response.getWriter().append(u_id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}