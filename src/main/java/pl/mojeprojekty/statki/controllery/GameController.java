package pl.mojeprojekty.statki.controllery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.mojeprojekty.statki.dto.Field;
import pl.mojeprojekty.statki.dto.Game;
import pl.mojeprojekty.statki.form.FieldsForm;
import pl.mojeprojekty.statki.service.GameService;
import pl.mojeprojekty.statki.service.PlayerService;

import java.util.ArrayList;
import java.util.Map;

@RestController
@SessionAttributes({"name","gameName"})
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @ModelAttribute("fieldsForm")
    public FieldsForm construct(){
        return new FieldsForm();
    }

    @RequestMapping(value = "game/{gameName}")
    public String enterGame(ModelMap modelMap,@PathVariable("gameName") String gameName,@ModelAttribute("name") String name){
        modelMap.addAttribute("gameName",gameName);
        Game game = gameService.getGameByHostName(gameName);
        if(!game.getGameHostName().equals(name)){
            if(game.getGuest()==null){
                game.setGuest(playerService.getPlayerByName(name));
            }
        }
        return "game";
    }

    @RequestMapping(value = "game/{pathGameName}",method = RequestMethod.POST)
    public String sendForm(ModelMap modelMap,@ModelAttribute("fieldsForm") FieldsForm fieldsForm){
        String[] positions = fieldsForm.getPositions();
        if(positions.length>20){
            modelMap.addAttribute("wrongNumberOfChecks","Zaznaczono zbyt wiele pól");
            return "game";
        } else if (positions.length<20){
            modelMap.addAttribute("wrongNumberOfChecks","Zaznaczono zbyt mało pól");
            return "game";
        }
        for (String pos:positions){
            System.out.println(pos);
        }
        return "game";
    }
}
