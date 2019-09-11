package com.scoliztur.game.mafia.controller;

import com.scoliztur.game.mafia.entity.Room;
import com.scoliztur.game.mafia.logic.players.role.*;
import com.scoliztur.game.mafia.services.PrepareGame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class RolesController {

    private final PrepareGame prepareGame;
    private final Room room;


    public RolesController(PrepareGame prepareGame, Room room) {
        this.prepareGame = prepareGame;
        this.room = room;
    }

    @GetMapping("/add/Don")
    public String addDon() {

        Don don = new Don();
        prepareGame.addRole(don);

        return "Added " + don.getName();
    }

    @GetMapping("/add/Mafia")
    public String addMafia() {

        Mafia mafia = new Mafia();
        prepareGame.addRole(mafia);

        return "Added " + mafia.getName();
    }

    @GetMapping("/add/Courtesan")
    public String addCourtesan() {

        Courtesan courtesan = new Courtesan();
        prepareGame.addRole(courtesan);

        return "Added " + courtesan.getName();
    }

    @GetMapping("/add/Sheriff")
    public String addSheriff() {

        Sheriff sheriff = new Sheriff();
        prepareGame.addRole(sheriff);

        return "Added " + sheriff.getName();
    }

    @GetMapping("/add/Barman")
    public String addBarman() {

        Barman barman = new Barman();
        prepareGame.addRole(barman);

        return "Added " + barman.getName();
    }

    @GetMapping("/add/Sheriff")
    public String addDoctor() {

        Doctor doctor = new Doctor();
        prepareGame.addRole(doctor);

        return "Added " + doctor.getName();
    }

    @GetMapping("/add/Civilian")
    public String addCivilian() {

        Civilian civilian = new Civilian();
        prepareGame.addRole(civilian);

        return "Added " + civilian.getName();
    }
}
