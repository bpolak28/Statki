package pl.mojeprojekty.statki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mojeprojekty.statki.model.Game;
import pl.mojeprojekty.statki.model.Player;

import javax.swing.text.html.HTMLDocument;
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
        boolean result4 = checkFourFieldsShip(columns,rows);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

//        if(result&&result2&&result3&&result4){
//            return true;
//        } else {
//            return false;
//        }
        return result&&result2&&result3&&result4;
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
//        if(numberOfOneFieldShips==4){
//            return true;
//        } else {
//            return false;
//        }
        return numberOfOneFieldShips==4;
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
//        if(numberOfTwoFieldShips==3){
//            return true;
//        } else {
//            return false;
//        }
        return numberOfTwoFieldShips==3;
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
//        if(numberOfThreeFieldsShips==2){
//            return true;
//        } else {
//            return false;
//        }
        return numberOfThreeFieldsShips==2;
    }

    private boolean checkFourFieldsShip(char[] columns,int[] rows){
        boolean result = false;
        for (int i=0;i<20;i++){
            List<Integer> indexesOfFourFieldShip = new ArrayList<>();
            int indexOfFirstFoundField=i;
            int indexOfSecondFoundField=100;
            int indexOfThirdFoundField=100;
            int indexOfFourthFoundField=100;
            char baseCol = columns[i];
            int baseRow = rows[i];
            for(int j=0;j<20;j++){
                if(i==j){
                    continue;
                }
                if(((baseCol==columns[j]-1||baseCol==columns[j]+1)&&baseRow==rows[j])||
                        ((baseRow==rows[j]-1||baseRow==rows[j]+1)&&baseCol==columns[j])){
                    baseCol=columns[j];
                    baseRow=rows[j];
                    for(int k=0;k<20;k++){
                        if(k==j||k==i){
                            continue;
                        }
                        if(((baseCol==columns[k]-1||baseCol==columns[k]+1)&&baseRow==rows[k])||
                                ((baseRow==rows[k]-1||baseRow==rows[k]+1)&&baseCol==columns[k])){
                            baseCol=columns[k];
                            baseRow=rows[k];
                            for(int l=0;l<20;l++){
                                if(l==i||l==j||l==k){
                                    continue;
                                }
                                if(((baseCol==columns[l]-1||baseCol==columns[l]+1)&&baseRow==rows[l])||
                                        ((baseRow==rows[l]-1||baseRow==rows[l]+1)&&baseCol==columns[l])){
                                    indexOfSecondFoundField=j;
                                    indexOfThirdFoundField=k;
                                    indexOfFourthFoundField=l;
                                    indexesOfFourFieldShip.add(i);
                                    indexesOfFourFieldShip.add(j);
                                    indexesOfFourFieldShip.add(k);
                                    indexesOfFourFieldShip.add(l);
                                    result=true;
                                }
                            }
                        }
                    }
                }
            }
            for(int j=0;j<20;j++){
                if(j==indexOfFirstFoundField||j==indexOfSecondFoundField||j==indexOfThirdFoundField||j==indexOfFourthFoundField){
                    continue;
                }
                for(int index:indexesOfFourFieldShip){
                    if((columns[index]==columns[j]||columns[index]==columns[j]-1||columns[index]==columns[j]+1)
                            &&(rows[index]==rows[j]||rows[index]==rows[j]-1||rows[index]==rows[j]+1)){
                        result=false;
                    }
                }
            }

        }
//        if(result){
//            return true;
//        } else {
//            return false;
//        }
        return result;
    }

}
