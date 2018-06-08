package pl.mojeprojekty.statki.dto;

import java.util.List;

public class Game {

    private Player host;

    private List<Field> hostShips;

    private Player guest;

    private List<Field> guestShips;

    public Game(){

    }

    public Game(Player host, List<Field> hostShips, Player guest, List<Field> guestShips) {
        this.host = host;
        this.hostShips = hostShips;
        this.guest = guest;
        this.guestShips = guestShips;
    }

    public List<Field> getHostShips() {
        return hostShips;
    }

    public void setHostShips(List<Field> hostShips) {

        this.hostShips = createShips(hostShips);
    }

    public List<Field> getGuestShips() {
        return guestShips;
    }

    public void setGuestShips(List<Field> guestShips) {
        this.guestShips = createShips(guestShips);
    }

    public Game(Player host) {
        this.host = host;
    }

    public Player getHost() {
        return host;
    }

    public void setHost(Player host) {
        this.host = host;
    }

    public Player getGuest() {
        return guest;
    }

    public void setGuest(Player guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "Game{" +
                "host=" + host +
                ", guest=" + guest +
                '}';
    }

    private List<Field> createShips(List<Field> ships){
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
        return ships;
    }
}
