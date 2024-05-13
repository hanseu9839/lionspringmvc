package org.sample.run;

import org.sample.bean.Game;
import org.sample.config.GameConfig;
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
