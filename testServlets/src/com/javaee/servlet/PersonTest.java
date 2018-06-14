package com.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaee.ejb.service.*;
import com.javaee.ejb.entity.*;

import java.util.List;

/**
 * Servlet implementation class StudentTest
 */
@WebServlet("/StudentTest")
public class PersonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PersonBean sBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    try {
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>ѧ��EJB����</title>");
	    	out.println("</head>");
	    	out.println("<body>");
	    	
	    	out.println("<h1>����ѧ��</h1>");
	    	sBean.createStudent(new Person("����"));
	    	sBean.createStudent(new Person("С��"));
	    	sBean.createStudent(new Person("����"));
	    	
	    	out.println("<h1>��ѯѧ��</h1>");
	    	List<Person> students = sBean.findAllPerson();
	    	if(students.size()>0) {
	    		out.println("<div>");
	    		out.println("<ul>");
	    		for(Person st : students) {
	    			out.println("<p/>");
	    			out.println("<li>"+st.getSno()+"</li>");
	    			out.println("<li>"+st.getSname()+"</li>");
	    		}
	    		out.println("</ul>");
	    		out.println("</div>");
	    	}
	    	
	    	out.println("<h1>�޸�ѧ��</h1>");
	    	students = sBean.findAllPerson();
	    	if(students.size()>0) {
	    		out.println("<div>");
	    		out.println("<ul>");
	    		for(Person st : students) {
	    			if(st.getSname().equals("����")) {
	    				st.setSname("С��");
	    				sBean.updateStudent(st);
	    			}
	    			out.println("<p/>");
	    			out.println("<li>"+st.getSno()+"</li>");
	    			out.println("<li>"+st.getSname()+"</li>");
	    		}
	    		out.println("</ul>");
	    		out.println("</div>");
	    	}
    		out.println("<h1>ɾ��ѧ��</h1>");
	    	students = sBean.findAllPerson();
	        for (Person st : students) {
	        	sBean.deleteStudent(st);
	        }
	        
	        out.println("</body>");
	        out.println("</html>");
    	
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	out.close();
	    }
	}
}
