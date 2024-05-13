package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            // 3. 접속
            // 4. 쿼리작성
            // 5. 쿼리작성
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/lion";
            String user = "root";
            String password = "1234";
            conn = DriverManager.getConnection(dbUrl, user, password);
            String sql = "update dept set dname='인사부' where deptno=50";
            ps = conn.prepareCall(sql);
            int count = ps.executeUpdate();
            System.out.println(count+ "건 변경했습니다.");
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(ps != null) {
                try{
                    ps.close();
                } catch(SQLException e){
                    e.printStackTrace();
                } finally {
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
    }
}
