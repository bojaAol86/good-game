package com.springapp.mvc;

public class Team {

    public String Name;
    public boolean Winner;
    public int Score;
    public String LogoUrl;


    public Team(){
        Winner = false;
    }

    public boolean equals(Team other) {

        if(this.Name.equals(other.Name) && this.Score == other.Score)
            return true;
        return false;
    }
}
