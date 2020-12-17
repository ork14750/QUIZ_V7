package com.esiea.API_RANKINGS;

import com.esiea.API_RANKINGS.model.Player;
import com.esiea.API_RANKINGS.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;


@Controller
public class ApiController {
    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/players")
    public ResponseEntity<Collection<Player>> getAllUsers() {
        Collection<Player> players = playerService.getAllUsers();
        return new ResponseEntity<Collection<Player>>(players, HttpStatus.FOUND);
    }
}
