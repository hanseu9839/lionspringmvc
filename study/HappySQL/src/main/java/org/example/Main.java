package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DeptDAO deptDAO = new DeptDAO();

        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setDeptno(150);
        deptDTO.setDname("검찰");
        deptDTO.setLoc("서울중앙지검");

        if(deptDAO.addDept(deptDTO)){
            System.out.println("insert 성공 ");
        } else {
            System.out.println("insert 실패");
        }

        DeptDTO updateDept = new DeptDTO();
        updateDept.setDeptno(150);
        updateDept.setDname("경찰특수부");
        updateDept.setLoc("강남");

        if(deptDAO.updateDept(updateDept)) {
            System.out.println("update 성공");
        } else {
            System.out.println("업데이트 실패");
        }

        DeptDTO deptnoOne = deptDAO.deptOne(150);
        System.out.println(deptnoOne);

        if(deptDAO.deleteDept(150)){
            System.out.println("delete 성공");
        } else {
            System.out.println("delete 실패");
        }

        List<DeptDTO> list= deptDAO.deptAll();
        list.forEach(System.out::println);
    }
}
