package routeTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import routeTest.model.Tea;
import routeTest.util.DButil;

@WebServlet("/connectOrder")
public class OrederList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		List<Tea> teas = new ArrayList<>();

		try {
			Class.forName(DButil.getDriverName());
			Connection connection = DButil.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_list");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				final int id = rs.getInt("id");
				final String name = rs.getString("name");
				final String size = rs.getString("size");
				final String price = rs.getString("price");

				teas.add(new Tea(id, name, size, price));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		final String url = "/WEB-INF/orderList.jsp";

		RequestDispatcher dispatcher = req.getRequestDispatcher(url);

		req.setAttribute("list", teas);
		dispatcher.forward(req, resp);

	}

}
