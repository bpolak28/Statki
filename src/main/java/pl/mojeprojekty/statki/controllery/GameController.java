package pl.mojeprojekty.statki.controllery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.mojeprojekty.statki.form.FieldsForm;
import pl.mojeprojekty.statki.service.GameService;
import pl.mojeprojekty.statki.service.PlayerService;

@RestController
@SessionAttributes({"name","gameName"})
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "game/{gameName}")
    public String enterGame(ModelMap modelMap,@PathVariable("gameName") String gameName){
        modelMap.addAttribute("gameName",gameName);
        return "game";
    }

    @RequestMapping(value = "game/{pathGameName}",method = RequestMethod.POST)
    public String sendForm(ModelMap modelMap,@ModelAttribute("name") String name){
        System.out.println(modelMap.get("gameName"));
        System.out.println(name);
        return "game";
    }
}
