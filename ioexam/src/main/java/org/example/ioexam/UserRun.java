package org.example.ioexam;

import org.example.ioexam.config.UserConfig;
import org.example.ioexam.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserRun {

    public static void main(String[] args) {
        // 빈관리 -> 컨테이너안에서 있는 동작하는 하나의 클ㄹ새ㅡ
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

       UserController controller = (UserController) context.getBean("userController");
        controller.joinUser();
        controller.getUser();
    }
}
