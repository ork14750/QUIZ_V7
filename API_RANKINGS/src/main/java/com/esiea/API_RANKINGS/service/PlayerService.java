package com.esiea.API_RANKINGS.service;

import com.esiea.API_RANKINGS.model.Player;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PlayerService {
    void save(Player player);

    Optional<Player> findByUsername(String username);

    void loadDataUsers();

    Collection<Player> getAllUsers();

}
