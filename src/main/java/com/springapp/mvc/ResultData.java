package com.springapp.mvc;

public class ResultData {

    public Team HomeTeam;
    public Team AwayTeam;
    public String Score;
    public boolean WasItAGoodGame;
    public boolean Overtime;

    public ResultData(){
        HomeTeam = new Team();
        AwayTeam = new Team();
        WasItAGoodGame = false;
        Overtime = false;
    }

    public void CalculateGameStatus(){

        if(HomeTeam.Score == -1 || AwayTeam.Score == -1){
            Score = "unfinished";
        }
        int scoreDifference = Math.abs(HomeTeam.Score - AwayTeam.Score);

        if( scoreDifference < 10 || Overtime){
            WasItAGoodGame = true;
        }
    }
}
