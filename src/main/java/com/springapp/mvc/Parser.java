package com.springapp.mvc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public abstract class Parser {

    protected String ResultElement ;
    protected String AwayTeamLocator ;
    protected String HomeTeamLocator ;
    protected String TeamNameLocator ;
    protected String TeamScoreLocator ;
    protected String SiteUrl;
    protected String YesterdaysGamesUrl;
    protected String Overtime;
    protected String UserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30";

    public  Map<String,List<ResultData>> parse(){
        try
        {
            Map<String,List<ResultData>> resultList = new HashMap<String, List<ResultData>>() ;      
            List<ResultData> todaysGameList = new ArrayList<ResultData>();
            List<ResultData> yesterdayGameList = new ArrayList<ResultData>();
            resultList.put(SiteUrl,todaysGameList);
            resultList.put(YesterdaysGamesUrl,yesterdayGameList);

            for (Map.Entry<String, List<ResultData>> entry : resultList.entrySet()) {

                List<ResultData> datesGamesList = entry.getValue();
                String url = entry.getKey();

                Document doc = Jsoup.connect(url).userAgent(UserAgent).get();
                Elements games = doc.select(ResultElement);

                for (int i = 0; i < games.size(); i++) {

                    try {
                        Element game = games.get(i);
                        ResultData result = new ResultData();

                        //Get away team details
                        Element awayTeam = game.select(AwayTeamLocator).first();
                        result.AwayTeam.Name = awayTeam.select(TeamNameLocator).text();
                        result.AwayTeam.Score = CheckIsGameOver(awayTeam.select(TeamScoreLocator).text());

                        // Get Home team details
                        Element homeTeam = game.select(HomeTeamLocator).first();
                        result.HomeTeam.Name = homeTeam.select(TeamNameLocator).text();
                        result.HomeTeam.Score = CheckIsGameOver(homeTeam.select(TeamScoreLocator).text());

                        //Set Team Logos
                        LogoFactory logoFactory = new LogoFactory();
                        result.HomeTeam.LogoUrl = logoFactory.GetTeamLogoUrl(result.HomeTeam.Name);
                        result.AwayTeam.LogoUrl = logoFactory.GetTeamLogoUrl(result.AwayTeam.Name);

                        result.Overtime = CalculateOvertime(game);
                        result.CalculateGameStatus();
                        datesGamesList.add(result);
                    }
                    catch (Exception e)
                    {
                        continue;
                    }
                }
            }

            List<ResultData> tmp1 = resultList.get(SiteUrl);
            List<ResultData> tmp2 = resultList.get(YesterdaysGamesUrl);

            resultList.remove(SiteUrl);
            resultList.remove(YesterdaysGamesUrl);

            resultList.put("today", tmp1);
            resultList.put("yesterday",tmp2);

            return resultList;

        }
        catch (Exception e)
        {
            return null;
        }
    }

    public abstract boolean CalculateOvertime(Element gameElement);
    public abstract void SetYesterdaysDateUrl();
    public abstract int CheckIsGameOver(String scoreText);

}
