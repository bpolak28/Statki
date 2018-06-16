package pl.mojeprojekty.statki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mojeprojekty.statki.model.Game;
import pl.mojeprojekty.statki.model.Player;

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
        boolean result2 = checkTwoFieldsShips(columns,rows);
        boolean result3 = checkThreeFieldsShips(columns,rows);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);

        return true;
    }

    private boolean checkOneFieldShips(char[] columns,int[] rows){

        int numberOfOneFieldShips=0;

        for(int i=0;i<20;i++){
            char checkCol = columns[i];
            int checkRow = rows[i];
            boolean result=false;
            for(int j=0;j<20;j++){
                if(i==j){
                    continue;
                }
                if((checkCol==columns[j]||checkCol==columns[j]-1||checkCol==columns[j]+1)
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
        System.out.println(numberOfOneFieldShips);
        if(numberOfOneFieldShips==4){
            return true;
        } else {
            return false;
        }
    }

    private boolean checkTwoFieldsShips(char[] columns, int[] rows){

        int numberOfTwoFieldShips=0;

        List<Integer> pairs = new ArrayList<>();

        for(int i=0;i<20;i++){
            boolean fieldAlreadyChecked = false;
            for(int s:pairs){
                if(i==s){
                    fieldAlreadyChecked = true;
                }
            }
            if(fieldAlreadyChecked){
                continue;
            }
            char checkCol = columns[i];
            int checkRow = rows[i];
            boolean result=false;
            for(int j=0;j<20;j++){
                if(i==j){
                    continue;
                }
                if(((checkCol==columns[j]-1||checkCol==columns[j]+1)&&checkRow==rows[j])||
                        ((checkRow==rows[j]-1||checkRow==rows[j]+1)&&checkCol==columns[j])){
                    char newCheckCol = columns[j];
                    int newCheckRow = rows[j];

                    for(int k=0;k<20;k++){
                        if(k==i||k==j){
                            continue;
                        }
                        if((checkCol==columns[k]||checkCol==columns[k]-1||checkCol==columns[k]+1)
                                &&(checkRow==rows[k]||checkRow==rows[k]-1||checkRow==rows[k]+1)){
                            result = false;
                            break;
                        } else if((newCheckCol==columns[k]||newCheckCol==columns[k]-1||newCheckCol==columns[k]+1)
                                &&(newCheckRow==rows[k]||newCheckRow==rows[k]-1||newCheckRow==rows[k]+1)){
                            result = false;
                            break;
                        } else {
                            result = true;
                        }
                    }
                    if(result){
                        pairs.add(j);
                        numberOfTwoFieldShips++;
                    }

                }

            }
        }
        System.out.println(numberOfTwoFieldShips);
        if(numberOfTwoFieldShips==3){
            return true;
        } else {
            return false;
        }
    }

    private boolean checkThreeFieldsShips(char[] columns,int[] rows){
        int numberOfThreeFieldsShips=0;
        for(int i=0;i<20;i++){
            char baseCol = columns[i];
            int baseRow = rows[i];
            int indexOfFirstFoundField=100;
            int indexOfSecondFoundField=100;
            boolean result = false;
            for(int j=0;j<20;j++){
                if(j==i){
                    continue;
                }
                if(((baseCol==columns[j]-1||baseCol==columns[j]+1)&&baseRow==rows[j])||
                        ((baseRow==rows[j]-1||baseRow==rows[j]+1)&&baseCol==columns[j])){
                    if(indexOfFirstFoundField==100){
                        indexOfFirstFoundField=j;
                    } else if(indexOfSecondFoundField==100) {
                        indexOfSecondFoundField=j;
                    } else {
                        indexOfFirstFoundField=100;
                        indexOfSecondFoundField=100;
                        break;
                    }
                }
            }
            if(indexOfFirstFoundField!=100&&indexOfSecondFoundField!=100){
                for(int k=0;k<20;k++){
                    if(k==i||k==indexOfFirstFoundField||k==indexOfSecondFoundField){
                        continue;
                    }
                    if((baseCol==columns[k]||baseCol==columns[k]-1||baseCol==columns[k]+1)
                            &&(baseRow==rows[k]||baseRow==rows[k]-1||baseRow==rows[k]+1)){
                        result = false;
                        break;
                    } else if((columns[indexOfFirstFoundField]==columns[k]||columns[indexOfFirstFoundField]==columns[k]-1||columns[indexOfFirstFoundField]==columns[k]+1)
                            &&(rows[indexOfFirstFoundField]==rows[k]||rows[indexOfFirstFoundField]==rows[k]-1||rows[indexOfFirstFoundField]==rows[k]+1)){
                        result = false;
                        break;
                    } else if((columns[indexOfSecondFoundField]==columns[k]||columns[indexOfSecondFoundField]==columns[k]-1||columns[indexOfSecondFoundField]==columns[k]+1)
                            &&(rows[indexOfSecondFoundField]==rows[k]||rows[indexOfSecondFoundField]==rows[k]-1||rows[indexOfSecondFoundField]==rows[k]+1)){
                        result = false;
                        break;
                    } else {
                        result = true;
                    }
                }
            }
            if(result){
                numberOfThreeFieldsShips++;
            }
        }
        System.out.println(numberOfThreeFieldsShips);
        if(numberOfThreeFieldsShips==2){
            return true;
        } else {
            return false;
        }
    }


}
