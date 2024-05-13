package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.ConnectionDB.close;
import static org.example.ConnectionDB.getConnection;

public class DeptDAO {

    public boolean addDept(DeptDTO deptDTO) throws SQLException, ClassNotFoundException {
        // 매개변수로 받아올 값이 너무 많다.
        Connection conn = getConnection();
        String sql  = "insert into dept(deptno, dname, loc) values(?,?,?)";
        int result = 0;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptDTO.getDeptno());
            ps.setString(2, deptDTO.getDname());
            ps.setString(3, deptDTO.getLoc());
            result = ps.executeUpdate();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(conn,ps);
        }

        if(result>0) {
            return true;
        }

        return false;
    }

    // 수정
    public boolean updateDept(DeptDTO deptDTO) throws SQLException, ClassNotFoundException {
        String sql = "update dept set dname=?, loc=? where deptno = ?";
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();

            ps= conn.prepareStatement(sql);

            ps.setString(1, deptDTO.getDname());
            ps.setString(2, deptDTO.getLoc());
            ps.setInt(3, deptDTO.getDeptno());

            result = ps.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            close(conn,ps);
        }

        if(result>0) {
            return true;
        }

        return false;
    }
    // 삭제
    public boolean deleteDept(int deptNo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("delete from dept where deptno = ?");

            ps.setInt(1, deptNo);
            result = ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        if(result>0) return true;

        return false;
    }
    // 모두 조회
    public List<DeptDTO> deptAll(){

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        List<DeptDTO> list = new ArrayList<>();
        try{
            conn = getConnection();
            String sql = "select deptno, dname, loc from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int deptno= rs.getInt(1);
                String dname = rs.getString(2);
                String loc = rs.getString(3);

                DeptDTO deptDTO = new DeptDTO();
                deptDTO.setDeptno(deptno);
                deptDTO.setDname(dname);
                deptDTO.setLoc(loc);
                list.add(deptDTO);
            }
        } catch(SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close(conn, ps, rs);
        }


        return list;
    }

    // 한 건 조회
    public DeptDTO deptOne(int deptno){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        DeptDTO deptDTO = new DeptDTO();
        try{
            conn = getConnection();
            String sql = "select deptno, dname, loc from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptno);
            rs = ps.executeQuery();

            if(rs.next()){
                deptDTO.setDeptno(rs.getInt(1));
                deptDTO.setDname(rs.getString(2));
                deptDTO.setLoc(rs.getString(3));
            }


        } catch(Exception e){
            throw new RuntimeException(e);
        } finally {
            close(conn ,ps ,rs);
        }


        return deptDTO;
    }


    // 조건에 맞는 조회...
    public List<DeptDTO> deptWhere(DeptDTO deptDTO){

        return null;
    }
}
