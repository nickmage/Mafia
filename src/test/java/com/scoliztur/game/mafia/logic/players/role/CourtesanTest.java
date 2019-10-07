package com.scoliztur.game.mafia.logic.players.role;

import com.scoliztur.game.mafia.logic.players.role.type.BlackPlayers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourtesanTest {

    private Courtesan courtesan;
    private Sheriff sheriff;

    @BeforeEach
    void setUp() {
        courtesan = new Courtesan("Lola");
        sheriff = new Sheriff("Gorge");
    }

    @Test
    void confuse() {
    }

    @Test
    void getRoleName() {
        assertEquals(courtesan.toString(), BlackPlayers.COURTESAN.getNameRole());
    }

    @Test
    void getVictim() {
    }
}