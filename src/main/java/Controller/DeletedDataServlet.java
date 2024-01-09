package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import DataBase.DeletedDataBase;

public class DeletedDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		DeletedDataBase deleteData=new DeletedDataBase();
		try {
			Boolean result= deleteData.deletedUser(id);
			
			if(result.equals(false)) {
				RequestDispatcher rqd=request.getRequestDispatcher("DeletedSuccessFully.jsp");
				rqd.forward(request, response);
			}else {
				response.sendRedirect("AddFailure.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
