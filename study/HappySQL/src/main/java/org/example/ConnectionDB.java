package org.example;

import java.sql.*;

public class ConnectionDB {

    private static final String dbUrl = "jdbc:mysql://localhost/lion";
    private static final String user = "root";
    private static final String password = "1234";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch(SQLException e){
            throw new RuntimeException();
        }

        return conn;
    }

    // DB close
    public static void close(Connection conn) {
        if(conn != null){
            try{
                conn.close();
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps) {
        if(ps != null) {
            try{
                ps.close();
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if(rs != null) {
            try{
                rs.close();
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        close(conn, ps);
    }
}
