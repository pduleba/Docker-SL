package com.pduleba.webapp.resource;

import com.pduleba.webapp.dao.PlayerRepository;
import com.pduleba.webapp.model.Player;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/all")
public class Resource {

    private PlayerRepository usersRepository;

    @GetMapping("/")
    public List<Player> all() {
        return usersRepository.findAll();
    }

    @GetMapping("/create")
    public List<Player> users() {

        usersRepository.save(Player.builder()
                .login("test")
                .password("password")
                .score(0)
                .level("Unknown")
                .email("test@emial.com")
                .build());

        return usersRepository.findAll();
    }
}
