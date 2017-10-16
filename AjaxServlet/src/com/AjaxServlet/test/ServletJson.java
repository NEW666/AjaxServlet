package com.AjaxServlet.test;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//˵�����Servlet中文
@SuppressWarnings("serial")  
//˵�����Servlet��������jsonRequest�����ַ��/jsonRequest������web.xml��������һ����  
@WebServlet(name = "jsonRequest", urlPatterns = { "/jsonRequest" })  

public class ServletJson extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ServletJson() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = new PrintWriter(response.getOutputStream());
		
		response.setContentType("text/html;charset = utf-8");
		
		out.print("��������");
		
		
		
		

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		
		StringBuffer json = new StringBuffer();
		
		json.append("[");
		try{
			dbDAO db = new dbDAO();
			ResultSet rs = db.query("select * from testtable");
			
			
			while(rs.next())
			{
				json.append("{");
				json.append("'id':").append("'").append(rs.getInt("ID")).append("'").append(",");
				json.append("'username':").append("'").append(rs.getString("username").trim()).append("'").append(",");
				json.append("'number':").append("'").append(rs.getString("number").trim()).append("'");
				json.append("},");
				
			}
			System.out.println(rs.getString("username"));
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		json.deleteCharAt(json.length()-1);
		json.append("]");
		PrintStream out = new PrintStream(response.getOutputStream());
		out.println(json.toString());
		out.close();
		

		
	}

}
