package com.xadmin.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.xadmin.usermanagement.dao.EmployeeDao;
import com.xadmin.usermanagement.bean.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private EmployeeDao EmployeeDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init()  {
			EmployeeDao = new EmployeeDao();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
		switch(action)
		{
			case "/new":
				showNewForm(request, response);
				break;
		
		
			case "/insert":
				insertEmployee(request, response);
				break;
		
		
			case "/delete":
				deleteEmployee(request, response);
				break;
				
				
			case "/edit":
				showEditForm(request, response);
				break;
					
			case "/update":
				updateEmployee(request, response);
				break;
		
		default:
			listEmployee(request, response);
			break;
		}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		
		}	
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
	
	}
	
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException
	{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String Designation = request.getParameter("Designation");
		String Department = request.getParameter("Designation");
		Employee newEmployee = new Employee(name, email, Designation, Department);
		EmployeeDao.insertEmployee(newEmployee);
		response.sendRedirect("list");	
	}
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
			EmployeeDao.deleteEmployee(id);
		
		response.sendRedirect("list");
	}
private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException
	
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = EmployeeDao.selectEmployee(id);
		RequestDispatcher dispatcher  = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);
		}


private void updateEmployee(HttpServletRequest request, HttpServletResponse response)throws SQLException,IOException
	
	{
	 int id = Integer.parseInt(request.getParameter("id"));	
	 String name = request.getParameter("name");
	 String email = request.getParameter("email");
	 String designation = request.getParameter("designation");
	 String department = request.getParameter("department");
	 Employee employee = new Employee(id, name, email, designation, department);
	 EmployeeDao.updateEmployee(employee);
	 response.sendRedirect("list");
	 
	}

private void listEmployee(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
	List<Employee> listEmployee = EmployeeDao.selectAllEmployee();
	request.setAttribute("listEmployee", listEmployee);
	RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
	dispatcher.forward(request, response);
}
	
	
	
	
	
	
		
}
			
	
			
		
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	

