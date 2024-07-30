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
 * Servlet implementation class Validador
 */
@WebServlet("/Validador")
public class Validador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Agregar nuevo proveedor
		
		ProveedorDao proveedorDao = new ProveedorDao();
		if (request.getParameter("txtId").equals("")) {
			List<Proveedor> proveedores = proveedorDao.findAll();
			request.setAttribute("proveedores", proveedores);
			request.getRequestDispatcher("proveedoresInicio.jsp").forward(request, response);
		} else {
			Integer id = Integer.parseInt(request.getParameter("txtId"));
			List<Proveedor> proveedores = proveedorDao.findAll();
			boolean proveedorExiste = false;
			
			for(Proveedor proveedor : proveedores) {
				if(proveedor.getId().equals(id)) {
					proveedorExiste = true;
					break;
				}
			}
			
			if (proveedorExiste) {
				request.setAttribute("proveedores", proveedores);
				request.getRequestDispatcher("proveedoresInicio.jsp").forward(request, response);
			} else {
				id = Integer.parseInt(request.getParameter("txtId"));
				String nombre = request.getParameter("txtNombre");
				String rut = request.getParameter("txtRut");
				String direccion = request.getParameter("txtDireccion");
				String telefono = request.getParameter("txtTelefono");
				String correo = request.getParameter("txtCorreo");
				String telefonoContacto = request.getParameter("txtTelefonoContacto");
				String contacto = request.getParameter("txtContacto");
				
				Proveedor nuevoProveedor = new Proveedor(id, nombre, rut, direccion, correo, telefono, contacto, telefonoContacto);
				proveedores.add(nuevoProveedor);
				
				request.setAttribute("proveedores", proveedores);
				request.getRequestDispatcher("proveedoresInicio.jsp").forward(request, response);
				
			}
			
			
			
			
			
		}
		
		
	}

}
