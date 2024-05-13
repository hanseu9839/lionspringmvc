package org.example.sample.config;

import org.example.sample.bean.Dice;
import org.example.sample.bean.Game;
import org.example.sample.bean.Player;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@ComponentScan(basePackages = "sample")
@PropertySource({"classpath:game.properties"})
public class GameConfig {

    @Bean
    public Dice dice(@Value("${face}") int face) {
        return  new Dice(face);
    }

    @Bean
    public Player player1(Dice dice){
        Player player = new Player();
        player.setDice(dice); // 설정 방식으로 주임
        player.setName("한승균");
        return player;
    }


    @Bean
    public Player player2(Dice dice){
        Player player = new Player();
        player.setDice(dice); // 설정 방식으로 주임
        player.setName("뽀짝이");
        return player;
    }

    @Bean
    public Player player3(Dice dice){
        Player player = new Player();
        player.setDice(dice); // 설정 방식으로 주임
        player.setName("둥둥이");
        return player;
    }

    @Bean
    public Game game(List<Player> players){
        return new Game(players);
    }
}
