package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com-mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,"root","admin");
            Statement statement = connection.createStatement();
            var sql = "SELECT * FROM persona";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.print("Id Persona: " + resultSet.getInt("id_persona"));
                System.out.print(" Nombre: " + resultSet.getString("nombre"));
                System.out.print(" Apellido: " + resultSet.getString("apellido"));
                System.out.print(" Email: " + resultSet.getString("email"));
                System.out.print(" Telefono: " + resultSet.getString("telefono"));
                System.out.println("");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            throw new RuntimeException(e);
        }


    }
}
