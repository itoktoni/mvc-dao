package com.controller.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.demo.AbstactSinglePatternConnection;
import com.connection.demo.FactoryPatternConnection;
import com.dao.demo.UserDao;
import com.entity.demo.UserModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	List<UserModel> data = new ArrayList<UserModel>();
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		AbstactSinglePatternConnection Sqlite = FactoryPatternConnection.Driver("sqlite");
//		ResultSet rs = Sqlite.query("select * from users");
//		
//		try {
//			while(rs.next()) {
//				try {
//					data.add(new UserModel(rs.getString("username"), rs.getString("password"), rs.getString("email")));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		UserDao user = new UserDao();
		data = user.read();
		
		
		System.out.print(System.getProperty("user.dir"));
		
		request.setAttribute("data", data);
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserDao user = new UserDao();
		user.create(new UserModel(username, password, email));
		
		doGet(request, response);
	}

}
