package org.example.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BookConfig {
    //싱글톤은 객체가 인스턴스화를 하나밖에못해요.
    @Bean
    @Scope("singleton")
    public Book singletonBook(){
        return new Book("Singleton Book", 10000);
    }

    @Bean
    @Scope("prototype") // 저희가 알고 있는 기존의 객체에요
    public Book prototypeBook() {
        return new Book("Prototype Book", 20000);
    }
}
