package org.example.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(MainApplication.class, args);

       Book singletonBook1 = context.getBean("singletonBook", Book.class);
       Book singletonBook2 = context.getBean("singletonBook", Book.class);

        System.out.println(singletonBook1 == singletonBook2); // ?? 어떤 값이 나올까요?

//        Book prototypeBook1 = context.getBean("prototypeBook", Book.class);
//        Book prototypeBook2 = context.getBean("prototypeBook", Book.class);
//        System.out.println(prototypeBook2 == prototypeBook1);
    }
}
