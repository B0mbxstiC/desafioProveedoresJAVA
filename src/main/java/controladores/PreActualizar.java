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
 * Servlet implementation class PreActualizar
 */
@WebServlet("/PreActualizar")
public class PreActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreActualizar() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//FindById para crear nueva lista con Proveedor a actualizar
		Integer idActualizacion = Integer.parseInt(request.getParameter("idActualizar"));
		ProveedorDao proveedorDao = new ProveedorDao();
		Proveedor proveedorId = proveedorDao.findById(idActualizacion);
		List<Proveedor> proveedores = (List<Proveedor>) proveedorDao.findAll();
		boolean proveedorExiste = proveedorId != null;		
		
		if (!proveedorExiste) {
			request.setAttribute("proveedores", proveedores);
			request.getRequestDispatcher("proveedoresInicio.jsp").forward(request, response);
		} else {
			request.setAttribute("proveedorId", proveedorId);
			request.getRequestDispatcher("actualizarProveedores.jsp").forward(request, response);
			}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
