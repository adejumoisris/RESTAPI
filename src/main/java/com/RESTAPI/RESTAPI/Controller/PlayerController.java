package com.RESTAPI.RESTAPI.Controller;

import com.RESTAPI.RESTAPI.Model.Player;
import com.RESTAPI.RESTAPI.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    // Autowired  PlayerService in other to use Methods in PlayerService
    @Autowired
    PlayerService service;


    // to showcase on the URL or PostMAN
    @GetMapping("/welcome")
    public String welcome() {
        return "Tennis Player REST API";
    }

        // to Showcase all the players in the database
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        //call service layer method
        return service.getAllPlayers();
    }

    public Player getPlayer(@PathVariable int id) {
        return service.getPlayer(id);
    }


    // Post Mapping is used to add record to the database
    // @RequetBody The @RequestBody annotation handles this conversion and binds the data in the request body to a method parameter.
    // @RequestBody is use to convert JSON to POJO object

    @PostMapping("/players")
    public Player addPlayer( @RequestBody Player player) {
        player.setId(0);
        return service.addPlayer(player);
    }
    // @PutMapping is used for Updating in the server
    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {
        return service.updatePlayer(id, player);

    }
    // @DeleteMapping is used for Deleting in the server
    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable int id) {
        //call service layer method
        return service.deletePlayer(id);

    }


}
