package org.example.sample.bean;

import org.example.sample.bean.Dice;
import org.springframework.stereotype.Component;

@Component
public class Player {
    private String name;

    private Dice dice; // 실행될 떄 주사위를 인젝션 받아야한다.

    // DI 할 수 있는 방법은? 생성자, setter, 필드


    public Player() {
        System.out.println("Player() 생성자 실행");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void play() {
        System.out.println(name + "가 주사위를 굴려서 " + dice.getNumber() + "를 얻어 왔습니다.");
    }
}
