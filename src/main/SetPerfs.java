package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetURL
 */
@WebServlet("/board-admin/SetPerfs")
public class SetPerfs extends HttpServlet {
	private String url;
	private String prefix;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPerfs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter p = null;
		try {
			p = new PrintWriter(new File(getServletContext().getRealPath("")+"/board-admin/url.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url = request.getParameter("url");
		prefix = request.getParameter("prefix");
		p.println(url);
		p.println(prefix);
		p.close();
		writer.println("<html>"
				+ "<body>"
				+ "<script>"
				+ "alert('Server preferences have been set successfully');\n" + 
				"window.location = '../';"
				+ "</script>"
				+ "</body>"
				+ "</html>");
	}

}
