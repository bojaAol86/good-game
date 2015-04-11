package com.springapp.mvc.Parsers;

import com.springapp.mvc.Parser;
import com.springapp.mvc.ResultData;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NbaParser extends Parser{

    public NbaParser(){
        super.ResultElement = ".game.post";
        super.AwayTeamLocator =  "tr.awayTeam";
        super.HomeTeamLocator = "tr.homeTeam";
        super.TeamNameLocator = ".teamLocation a";
        super.TeamScoreLocator = ".finalScore";
        super.SiteUrl = "http://stats.nba.com/scores/#!/03/20/2015";
    }

    public Map<String,ArrayList<ResultData>> parse(){
        return super.parse();
    }

    @Override
    public boolean CalculateOvertime(Element gameElement) {
        return false;
    }

    @Override
    public void SetYesterdaysDateUrl() {

    }

    @Override
    public int CheckIsGameOver(String scoreText) {
        return 0;
    }
}
