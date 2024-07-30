package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProveedorDao;
import dto.Proveedor;

/**
 * Servlet implementation class EliminarPorId
 */
@WebServlet("/EliminarPorId")
public class EliminarPorId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarPorId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		ProveedorDao proveedorDao = new ProveedorDao();
		if (request.getParameter("id") == null) {
			proveedorDao.deleteById(null);
			List<Proveedor> proveedores = proveedorDao.findAll();
			request.setAttribute("proveedores", proveedores);
			request.getRequestDispatcher("proveedoresInicio.jsp").forward(request, response);
		} else {
			proveedorDao.deleteById(id);
			List<Proveedor> proveedores = proveedorDao.findAll();
			request.setAttribute("proveedores", proveedores);
			request.getRequestDispatcher("proveedoresInicio.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
