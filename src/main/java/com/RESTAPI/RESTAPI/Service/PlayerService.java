package com.RESTAPI.RESTAPI.Service;

import com.RESTAPI.RESTAPI.Exception.PlayerNotFoundException;
import com.RESTAPI.RESTAPI.Model.Player;
import com.RESTAPI.RESTAPI.Repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository repo;
  // to call list of Players in the database
    public List<Player> getAllPlayers() {
        //call repository method
        return repo.findAll();
    }

        // get the players Id just only the Id
    public Player getPlayer(int id) {
        //find and return the player
//        return repo.findById(id).get();
//        Optional<Player> tempPlayer = repo.findById(id);
//
//        return null;

//        Optional<Player> tempPlayer = repo.findById(id);
//        Player p = null;
//
//        //if the Optional has a value, assign it to p
//        if(tempPlayer.isPresent())
//            p = tempPlayer.get();
//
//        return p;

        Optional<Player> tempPlayer = repo.findById(id);

        Player p = null;

        //if the Optional has a value, assign it to p
        if(tempPlayer.isPresent())
            p = tempPlayer.get();

            //if value is not found, throw a runtime exception
        else
            throw new RuntimeException("Player with id "+ id + " not found.");

        return p;

    }

    public Player addPlayer(Player p) {
        //call repository method to add a player object to the player table
        return repo.save(p);
    }

    public Player updatePlayer(int id, Player p) {
        //call repository method to update the player
        //get player object by Id
        Player player = repo.getOne(id);

        //update player information in database
        //update player details
        player.setName(p.getName());
        player.setNationality(p.getNationality());
        player.setBirthDate(p.getBirthDate());
        player.setTitles(p.getTitles());

        return repo.save(player);
    }

    public String deletePlayer(int id) {
        //call repo method for delete
//        repo.deleteById(id);
//        return "Deleted player with id: "+id;

        try {
            repo.deleteById(id);
        } catch(Exception e) {
            return "Player with id " + id + "not found";
        }

        return "Deleted player with id: " + id;

    }

    @Transactional
    public void updateTitles(int id, int titles) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        repo.updateTitles(id, titles);
    }



}
