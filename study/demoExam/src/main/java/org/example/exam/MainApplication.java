package org.example.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(MainApplication.class, args);

       A a = context.getBean(A.class); // container에서 객체를 가져오는 부분
       System.out.println(a);
       a.getA(); // 실질적으로 메소드가 들어간지 확인해주는 부분
    }
}
