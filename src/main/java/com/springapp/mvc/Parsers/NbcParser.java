package com.springapp.mvc.Parsers;

import com.springapp.mvc.Parser;
import com.springapp.mvc.ResultData;
import org.jsoup.nodes.Element;

import java.text.SimpleDateFormat;
import java.util.*;

public class NbcParser extends Parser {

    public NbcParser(){
        super.ResultElement = ".shsScoreboardCol";
        super.AwayTeamLocator = "tr:nth-child(2) ";
        super.HomeTeamLocator = "tr:nth-child(3)";
        super.TeamNameLocator = ".shsNamD a";
        super.TeamScoreLocator = "td:nth-child(6)";
        super.SiteUrl = "http://scores.nbcsports.msnbc.com/nba/scoreboard.asp";
        super.Overtime = ".shsTeamCol.shsNamD";
        this.SetYesterdaysDateUrl();
    }

    public Map<String,ArrayList<ResultData>> parse(){
        return super.parse();
    }

    @Override
    public  boolean CalculateOvertime(Element gameElement){
        return gameElement.select(Overtime).text().equals("Final-OT");
    }

    @Override
    public void SetYesterdaysDateUrl() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        super.YesterdaysGamesUrl = SiteUrl + "?day=" + ft.format(date)+ "&meta=true";
    }

    @Override
    public int CheckIsGameOver(String scoreText) {

        try{
            return Integer.parseInt(scoreText);
        }
        catch (NumberFormatException  ex){
            return -1;
        }
    }
}
