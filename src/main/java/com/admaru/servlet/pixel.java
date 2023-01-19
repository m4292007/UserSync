package com.admaru.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pixel
 */
@WebServlet("/pixel")
public class pixel extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static void main(String...args) {
		pixel x = new pixel();
		x.givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect();
	}
       
    public String givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
    
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 25;
	    Random random = new Random();
	
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	
	    System.out.println(generatedString);
	    return generatedString;
	}

    public pixel() {
        super();
        // TODO Auto-generated constructor stub
    }

	// to mock dsp cookie url 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("https://p2.admaru.net/UserSync/uid?p_id=1000&u_id="+givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
