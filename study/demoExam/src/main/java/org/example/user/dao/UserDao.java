package org.example.user.dao;

import org.example.user.domain.User;

public interface UserDao {
    // 인터페이스 만드는 이유, 데이터베이스를 머를 쓸지에 따라서 코드가 변경가 변경됨 그러면 주입도 다시해야되서 로직을 게속 별개로 타서 생성해야되는데 이걸 막아줘요.
    // 다형성을 지켜주려고 인터페이스로 Dao를 만드는거에요
    void userAdd(User user);


}
