package com.admaru.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class setBID
 */
@WebServlet("/setBID")
public class setBID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setBID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		URL url = new URL("https://cm-exchange.toast.com/bi/pixel?cm_mid=1330086872&toast_push");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		//conn.setRequestProperty("Content-Type","application/json");
				
		OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
		osw.write("");
		osw.flush();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		
		String line =null;
		StringBuffer outResult = new StringBuffer();
		
		while( (line = br.readLine()) != null) 
		{
			// read시 exception이 발생할 경우?? 
			outResult.append(line);
		}
	
		String dspResult = outResult.toString();		
		response.getWriter().append(dspResult);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
