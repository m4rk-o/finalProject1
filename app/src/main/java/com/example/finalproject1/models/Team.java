package com.example.finalproject1.models;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Team")
public class Team {

    @Column(name = "name")
    public String name;

    @Column(name = "played")
    public int played;

    @Column(name = "won")
    public int won;

    @Column(name = "draws")
    public int draws;

    @Column(name = "lost")
    public int lost;

    @Column(name = "goalsfor")
    public int goalsfor;

    @Column(name = "goalsagainst")
    public int goalsagainst;

    @Column(name = "goaldifference")
    public int goaldifference;

    @Column(name = "points")
    public int points;
}
