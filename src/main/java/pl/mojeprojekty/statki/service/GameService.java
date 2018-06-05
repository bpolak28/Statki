package pl.mojeprojekty.statki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mojeprojekty.statki.dto.Game;
import pl.mojeprojekty.statki.dto.Player;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameService {

    @Autowired
    private PlayerService playerService;

    private List<Game> games;

    public GameService() {
        games = new ArrayList<>();
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGame(Game game){
        games.add(game);
    }

    public void addGameByPlayerName(String name){
        Player playerByName = playerService.getPlayerByName(name);
        if(!playerByName.isCreatedGame()){
            addGame(new Game(playerByName));
            playerByName.setCreatedGame(true);
        }
    }

    public void checkHost(String name) {
        games.stream().filter(g -> g.getHost().getName().equals(name)).findFirst().orElseGet(null);
    }

    public Game getGameByHost(Player player){
        Game game = games.stream().filter(g -> g.getHost() == player).findFirst().orElseGet(null);
        if(game!=null){
            return game;
        } else {
            return null;
        }
    }
}
