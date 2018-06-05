package pl.mojeprojekty.statki.dto;

public class Game {

    private Player host;

    private Player guest;

    public Game(){

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
}
