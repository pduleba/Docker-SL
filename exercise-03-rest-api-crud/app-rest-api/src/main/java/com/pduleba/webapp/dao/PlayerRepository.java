package com.pduleba.webapp.dao;

import com.pduleba.webapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player, Integer> {
}
