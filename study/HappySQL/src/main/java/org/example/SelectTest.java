package org.example;

import java.sql.*;

public class SelectTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost/lion";
        String user = "root";
        String password = "1234";

        try{
            conn = DriverManager.getConnection(dbUrl, user, password);
            ps = conn.prepareStatement("select deptno, dname, loc from dept");
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt("deptno") + " ");
                System.out.print(rs.getString(2)+"  ");
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(rs != null) {
                try{
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(ps != null){
                try{
                    ps.close();
                } catch(SQLException e){
                    throw new RuntimeException();
                }
            }

            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
