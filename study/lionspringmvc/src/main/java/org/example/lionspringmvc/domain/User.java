package org.example.lionspringmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
