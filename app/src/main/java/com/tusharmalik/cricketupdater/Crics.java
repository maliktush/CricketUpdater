package com.tusharmalik.cricketupdater;

/**
 * Created by tushm on 05-02-2018.
 */

public class Crics
{
    private int id;
    private String Team1;
    private String Team2;
    private String Date;
    private String Time;
    private String Type;

    public Crics(int id, String team1, String team2, String date, String time, String type) {
        this.id = id;
        Team1 = team1;
        Team2 = team2;
        Date = date;
        Time = time;
        Type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
