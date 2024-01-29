package routeTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import routeTest.model.Tea;
import routeTest.util.DButil;

//http://192.168.:8080/routeTest/tea/order
@WebServlet("/insertOrder")
public class InsertOrder extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String query = "INSERT INTO orderlist (name,size,price) VALUES(?,?,?)";
		
		try {
			Class.forName(DButil.getDriverName());
			
			Connection connection = DButil.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			
			String selectedIndex = req.getParameter("selectedMenu");
			
			statement.setString(1, req.getParameter("teaName_" + selectedIndex));
			statement.setString(2, req.getParameter("teaSize_" + selectedIndex));
			statement.setInt(3, Integer.parseInt(req.getParameter("teaPrice_" + selectedIndex)));
			
			statement.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	 // redirect 필요
		
	}

	
	
	
}
