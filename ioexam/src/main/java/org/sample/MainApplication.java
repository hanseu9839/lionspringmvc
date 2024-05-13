package org.sample;

import org.sample.book.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainApplication.class, args);

        // Sigleton bean
        Book sigletonBook1 =  context.getBean("singletonBook", Book.class);
        Book sigletonBook2 =  context.getBean("singletonBook", Book.class);

        Book prototypeBook1 = context.getBean("prototypeBook", Book.class);
        Book prototypeBook2 = context.getBean("prototypeBook", Book.class);

        System.out.println("Singleton Book instances are the same : " + (sigletonBook1 == sigletonBook2));
        System.out.println("Prototype Book instances are the same : " + (prototypeBook1 == prototypeBook2));
    }
}

