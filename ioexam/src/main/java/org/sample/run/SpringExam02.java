package org.example.sample.run;

import org.example.sample.bean.Game;
import org.example.sample.config.GameConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam02 {
    public static void main(String[] args) {
        System.out.println("공장 생성전");
        ApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
        System.out.println("공장 생성후");

       Game game = context.getBean(Game.class);
       game.play();
    }
}
