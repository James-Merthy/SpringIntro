package be.digitalcity.demointrospring.controllers.controllers;

import be.digitalcity.demointrospring.controllers.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/player")
public class PlayerController {

    private final PlayerService playerService ;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(path = "/all" , method = RequestMethod.GET)

    public ModelAndView  getAllPlayers(){

        ModelAndView mv = new ModelAndView("player/all");
        mv.addObject ("players",this.playerService.getAll());
        return mv ;
    }

    @RequestMapping(path = "/one/{id}")
    public ModelAndView getOnePlayersById(@PathVariable long id){

        return null ;
    }
}
