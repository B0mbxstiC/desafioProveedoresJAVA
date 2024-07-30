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
 * Servlet implementation class Actualizar
 */
@WebServlet("/Actualizar")
public class Actualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//Este es el ID que actualizará todo
		ProveedorDao proveedorDao = new ProveedorDao();			
		Integer id = Integer.parseInt(request.getParameter("txtId"));
		String nombre = request.getParameter("txtNombre");
        String rut = request.getParameter("txtRut");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        String correo = request.getParameter("txtCorreo");
        String telefonoContacto = request.getParameter("txtTelefonoContacto");
        String contacto = request.getParameter("txtContacto"); 
        Proveedor proveedorActualizar = new Proveedor(id, nombre, rut, direccion, correo, telefono, contacto, telefonoContacto);
        proveedorDao.update(proveedorActualizar);
        List<Proveedor> proveedores = proveedorDao.findAll();
		request.setAttribute("proveedores", proveedores);
		request.getRequestDispatcher("proveedoresInicio.jsp").forward(request, response);		
		
	}

}
