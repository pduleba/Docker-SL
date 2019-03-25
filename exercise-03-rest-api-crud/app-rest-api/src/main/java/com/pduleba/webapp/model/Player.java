package com.pduleba.webapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private Integer score;
    private String email;

}
