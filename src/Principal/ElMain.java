package Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ElMain {

	public static void main(String[] args) throws SQLException {


		        /*String url = "jdbc:mysql://localhost:3306/dbname";
		        String user = "root";
		        String password = "mypassword";
		        Connection connection = null;

		        try {
		            connection = DriverManager.getConnection(url, user, password);
		            System.out.println("Conexión establecida correctamente.");
		        } catch (SQLException e) {
		            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
		        } finally {
		            if (connection != null) {
		                try {
		                    connection.close();
		                    System.out.println("Conexión cerrada correctamente.");
		                } catch (SQLException e) {
		                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
		                }
		            }
		        }*/
		        
		        
		        String url = "jdbc:mysql://localhost:3306/dbname";
		        String user = "root";
		        String password = "mypassword";
		        Connection connection = null;

		        try {
		            connection = DriverManager.getConnection(url, user, password);
		            System.out.println("Conexión establecida correctamente.");

		            // Consulta 3.a: Insertar un empleado nuevo en la nómina de trabajo
		            Statement statement = connection.createStatement();
		            String query = "INSERT INTO empleados (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('12345678A', 'Juan', 'Pérez', 'Español', 'Sistemas')";
		            int filasInsertadas = statement.executeUpdate(query);
		            System.out.println("Se han insertado " + filasInsertadas + " filas.");

		            // Consulta 3.b: Modificar la nacionalidad de algún empleado
		            String updateQuery = "UPDATE empleados SET nacionalidad = 'Argentino' WHERE DNI = '12345678A'";
		            int filasModificadas = statement.executeUpdate(updateQuery);
		            System.out.println("Se han modificado " + filasModificadas + " filas.");

		            // Consulta 3.c: Eliminar un departamento
		            String deleteQuery = "DELETE FROM departamentos WHERE nombre = 'Compras'";
		            int filasEliminadas = statement.executeUpdate(deleteQuery);
		            System.out.println("Se han eliminado " + filasEliminadas + " filas.");
		            
		            statement.close();
		        } catch (SQLException e) {
		            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
		        } finally {
		            if (connection != null) {
		                try {
		                    connection.close();
		                    System.out.println("Conexión cerrada correctamente.");
		                } catch (SQLException e) {
		                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
		                }
		            }
		        }        
		        
		        Statement stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM empleados WHERE departamento = 'logística'");

		        while (rs.next()) {
		            String dni = rs.getString("dni");
		            String nombre = rs.getString("nombre");
		            String apellido = rs.getString("apellido");
		            String nacionalidad = rs.getString("nacionalidad");
		            String departamento = rs.getString("departamento");
		            System.out.println(dni + " - " + nombre + " " + apellido + " - " + nacionalidad + " - " + departamento);
		        }

		        rs.close();
		        stmt.close();     
		        
	}
}

	


