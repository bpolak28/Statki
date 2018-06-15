package pl.mojeprojekty.statki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
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
            Game newGame = new Game(playerByName);
            newGame.setGameHostName(name);
            addGame(newGame);
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

    public Game getGameByHostName(String name){
        return games.stream().filter( g -> g.getGameHostName().equals(name)).findFirst().orElseGet(null);
    }

    public boolean checkShipsLocations(String[] positions) {
        int numberOfOneFieldShip;
        int numberOfTwoFieldShip;
        int numberOfThreeFieldShip;
        int numberOfFourFieldShip;
        char[] columns = new char[20];
        int[] rows = new int[20];
        int iter=0;
        for (String position:positions){
            char column = position.charAt(0);
            String substring = position.substring(1);
            int row = Integer.valueOf(substring);
            System.out.println(column+","+row);
            columns[iter]=column;
            rows[iter]=row;
            iter++;
        }
        boolean result = checkOneFieldShips(columns, rows);

        return true;
    }

    public boolean checkOneFieldShips(char[] colomns,int[] rows){

        int numberOfOneFieldShips=0;

        for(int i=0;i<20;i++){
            char checkCol = colomns[i];
            int checkRow = rows[i];
            boolean result=false;
            for(int j=0;j<20;j++){
                if(i==j){
                    continue;
                }
                if((checkCol==colomns[j]||checkCol==colomns[j]-1||checkCol==colomns[j]+1)
                    &&(checkRow==rows[j]||checkRow==rows[j]-1||checkRow==rows[j]+1)){
                    result=false;
                    break;
                } else {
                    result=true;
                }
            }
            if(result) {
                numberOfOneFieldShips++;
            }
        }
        if(numberOfOneFieldShips==4){
            return true;
        } else {
            return false;
        }
    }
}
