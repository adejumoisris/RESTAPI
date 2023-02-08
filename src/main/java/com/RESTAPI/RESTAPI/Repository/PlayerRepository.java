package com.RESTAPI.RESTAPI.Repository;

import com.RESTAPI.RESTAPI.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
  public void updateTitles(int id, int titles);
}
