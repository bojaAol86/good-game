package com.springapp.mvc.Parsers;

import com.springapp.mvc.Parser;
import com.springapp.mvc.ResultData;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.Map;

public class CbsParser extends Parser {

    public CbsParser(){
        super.ResultElement = ".scoreBox";
        super.AwayTeamLocator =  "tr.awayTeam";
        super.HomeTeamLocator = "tr.homeTeam";
        super.TeamNameLocator = ".teamLocation a";
        super.TeamScoreLocator = ".finalScore";
        super.SiteUrl = "http://www.cbssports.com/nba/scoreboard";
    }

    public Map<String,List<ResultData>> parse(){
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
