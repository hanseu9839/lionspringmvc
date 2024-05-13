package org.example.sample.config;

import org.example.sample.book.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class BookConfig {
    @Bean
    @Scope("singleton")
    public Book singletonBook() {
        return new Book("Singleton Book", 10000);
    }

    @Bean
    @Scope("prototype")
    public Book prototypeBook(){
        return new Book("Prototype Book", 20000);
    }
}
