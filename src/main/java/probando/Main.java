package probando;

import dao.ProveedorDao;
import dto.Proveedor;
import utilidades.Conexion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion con = new Conexion();
		con.getConexion();
		
		ProveedorDao pro = new ProveedorDao();
		Proveedor proveedorActualizar = new Proveedor(2, "Joel", "111", "Torreones", "jota@gamil.com", "9722", "sonia", "9827");
		pro.update(proveedorActualizar);
		pro.findById(2);
	}

}
