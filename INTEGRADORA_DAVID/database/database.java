import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

    // Cambia estas variables con tus propios detalles de conexión
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Paso 1: Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 2: Establecer la conexión con la base de datos
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Paso 3: Crear una declaración
            Statement statement = conn.createStatement();

            // Paso 4: Crear una tabla (ejemplo)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS usuarios (id INT PRIMARY KEY, nombre VARCHAR(50))";
            statement.executeUpdate(createTableSQL);

            // Paso 5: Insertar datos
            String insertDataSQL = "INSERT INTO usuarios (id, nombre) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertDataSQL);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "EjemploUsuario");
            preparedStatement.executeUpdate();

            // Paso 6: Consultar datos
            String selectDataSQL = "SELECT * FROM usuarios";
            ResultSet resultSet = statement.executeQuery(selectDataSQL);

            // Paso 7: Mostrar resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión en el bloque finally para asegurar que se cierre incluso si hay excepciones
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
