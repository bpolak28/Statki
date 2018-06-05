package pl.mojeprojekty.statki.controllery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.mojeprojekty.statki.dto.Game;
import pl.mojeprojekty.statki.service.GameService;
import pl.mojeprojekty.statki.service.MyPlayer;
import pl.mojeprojekty.statki.service.PlayerService;

@RestController
@Scope(value = "session")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MyPlayer myPlayer;

    private Game game;

    @RequestMapping(value = "game/{name}")
    public String enterGame(ModelMap modelMap,@PathVariable("name") String name){
        this.game = gameService.getGameByHost(playerService.getPlayerByName(name));
        if(myPlayer.getMe().getName().equals(name)){
            modelMap.addAttribute("player", "gospodarz");
        } else {
            gameService.getGameByHost(playerService.getPlayerByName(name)).setGuest(myPlayer.getMe());
            modelMap.addAttribute("player","gość");
        }
        return "game";
    }

    @RequestMapping(value = "game/{name}",method = RequestMethod.POST)
    public String sendForm(ModelMap modelMap,@RequestBody String a1){
        System.out.println(a1);
        System.out.println("dupa");
        return "game";
    }
}
