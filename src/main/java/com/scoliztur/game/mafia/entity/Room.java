package com.scoliztur.game.mafia.entity;

import com.scoliztur.game.mafia.logic.role.standard.Player;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Room {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "room_id", unique = true)
    private UUID roomID;

    @Column(name = "roles")
    private List<Player> roles;

    @Column(name = "players")
    private int players;

}