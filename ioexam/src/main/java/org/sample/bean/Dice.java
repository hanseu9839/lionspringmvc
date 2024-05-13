package org.example.sample.bean;

import org.springframework.stereotype.Component;

@Component
public class Dice {
    private int face;

    public Dice() {
    }

    public Dice(int face) {
        this.face = face;
        System.out.println("Dice(int) 실행");
    }
    public int getNumber() {
        return (int)(Math.random() * face) + 1;
    }
}
