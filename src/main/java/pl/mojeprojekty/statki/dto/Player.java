package pl.mojeprojekty.statki.dto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private boolean createdGame = false;

    public Player(String name) {
        this.name = name;
    }

    public Player(){

    }

    public String getName() {
        return name;
    }

    public boolean isCreatedGame() {
        return createdGame;
    }

    public void setCreatedGame(boolean createdGame) {
        this.createdGame = createdGame;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
