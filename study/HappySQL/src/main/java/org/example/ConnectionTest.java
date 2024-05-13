package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost/lion";
        String user = "root";
        String password = "1234";

        Connection conn = DriverManager.getConnection(dbUrl, user, password);

        if(conn != null) {
            System.out.println("^^");
        } else {
            System.out.println("-__-;;");
        }
        String sql = "insert into dept(depno, dname) values(3, '개발부')";

        // DBMS는 쿼리가 들어오면 변역한다. 이때 같은 쿼리가 들어오면 이미 변역된 것을 이용한다.
        // 값이 바뀌어도 다른 쿼리로 인식한다. 매번 번역한다.
        String sql2 = "insert into dept(deptno, dname) values(3, ?)";
        //여기까지를 번역.
        // 값이 나중에 바뀌므로 매번 번역하지 않는다.
    }
}
