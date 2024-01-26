package persistance.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.IDriver;

public class SqlDriver implements IDriver<ResultSet> {
    private String destination = null;
    String connectionUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    final String username = "username";
    final String password = "password";
    Connection conn;

    public SqlDriver(String destination) {
        this.destination = destination;
        try {
            conn = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public ResultSet findById(String id) {
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM " + getDestination() + " WHERE id=" + id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet[] findAll(String search) {

        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public String insert(ResultSet data) {

        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void delete(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(String id, ResultSet data) {

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
