package pl.mojeprojekty.statki.dto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private boolean createdGame = false;

    private List<Field> ships = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        createShips();
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


    private void createShips(){
        ships.add(new Field("oneFieldShip"));
        ships.add(new Field("oneFieldShip"));
        ships.add(new Field("oneFieldShip"));
        ships.add(new Field("oneFieldShip"));
        ships.add(new Field("twoFieldShip"));
        ships.add(new Field("twoFieldShip"));
        ships.add(new Field("twoFieldShip"));
        ships.add(new Field("twoFieldShip"));
        ships.add(new Field("twoFieldShip"));
        ships.add(new Field("twoFieldShip"));
        ships.add(new Field("threeFieldShip"));
        ships.add(new Field("threeFieldShip"));
        ships.add(new Field("threeFieldShip"));
        ships.add(new Field("threeFieldShip"));
        ships.add(new Field("threeFieldShip"));
        ships.add(new Field("threeFieldShip"));
        ships.add(new Field("fourFieldShip"));
        ships.add(new Field("fourFieldShip"));
        ships.add(new Field("fourFieldShip"));
        ships.add(new Field("fourFieldShip"));
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
