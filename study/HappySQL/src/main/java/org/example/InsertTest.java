package org.example;

import java.sql.*;

public class InsertTest {
    public static void main(String[] args) {
        // 1. 필요한 객체를 선언한다.
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            // 3. 접속
            // 4. 쿼리작성
            // 5. 쿼리작성
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/lion";
            String user = "root";
            String password = "1234";
            conn = DriverManager.getConnection(dbUrl, user, password);
            conn.setAutoCommit(false);
            String sql = "insert into dept(deptno, dname, loc) values(70,?,?)";
            ps = conn.prepareCall(sql);

            ps.setString(1,"교육부");
            ps.setString(2,"인천");

            int count = ps.executeUpdate();
            System.out.println(count+"건 입력했습니다!!");

            conn.commit();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(ps != null) {
                try{
                    ps.close();
                } catch(SQLException e){
                    e.printStackTrace();
                } finally {

                }
            }
        }

    }
}
