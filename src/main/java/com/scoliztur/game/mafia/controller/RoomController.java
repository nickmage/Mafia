package com.scoliztur.game.mafia.controller;

import com.scoliztur.game.mafia.entity.AppUser;
import com.scoliztur.game.mafia.entity.Room;
import com.scoliztur.game.mafia.entity.repositories.RoomRepositories;
import com.scoliztur.game.mafia.entity.repositories.UserRepositories;
import com.scoliztur.game.mafia.filters.JwtAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/room")
public class RoomController {

    private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    private final RoomRepositories roomRepositories;
    private final UserRepositories userRepositories;

    public RoomController(RoomRepositories roomRepositories, UserRepositories userRepositories) {
        this.roomRepositories = roomRepositories;
        this.userRepositories = userRepositories;
    }

    @PostMapping("/create")
    public String createRoom(@RequestParam("name_room") String nameRoom, @RequestParam("max_size") int maxSize) {

        AppUser principalUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        AppUser appUser = userRepositories.findUserByUsername(principalUser.getUsername());


        if(nameRoom == null) {
            log.warn("Room has not name");
            throw new RuntimeException("Write name room");
        }

        Room room = new Room();

        room.setPlayersNow(1);
        room.setName(nameRoom);
        room.setMaxSizePlayers(maxSize);
        room.addUser(appUser);
        userRepositories.save(appUser);
        roomRepositories.save(room);

        return "Create room. Name -> " + nameRoom;
    }

    @PostMapping("/join")
    public String joinRoom(@RequestParam UUID roomId, Principal principal) {

        AppUser appUser = userRepositories.findUserByUsername(principal.getName());

        if(!roomRepositories.existsById(roomId)) {
            throw new RuntimeException("Such a room does not exist");
        } else if(!roomRepositories.existsById(appUser.getId())) {
            log.warn("Such a appUser does not exist");
            throw new RuntimeException("AppUser does not exist");
        }

        roomRepositories.getOne(roomId).getAppUsers().add(appUser);

        roomRepositories.getOne(roomId)
                .setPlayersNow(roomRepositories.getOne(roomId).getPlayersNow() + 1);

        return "AppUser " + userRepositories.getOne(appUser.getId()).getUsername()
                + " join in room -> " + roomRepositories.getOne(roomId).getName();
    }
}
