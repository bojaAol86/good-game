package com.springapp.mvc;

public class LogoFactory {

    public String GetTeamLogoUrl(String teamName){

        teamName = teamName.toLowerCase();
        String filename = "";
        if ("miami".equals(teamName )) {
            filename = "miami2";
        }
        else if ("cleveland".equals(teamName )) {
            filename = "cavs2";
        }
        else if ("houston".equals(teamName )) {
            filename = "houston2";
        }
        else if ("dallas".equals(teamName )) {
            filename = "dallas2";
        }
        else if ("phoenix".equals(teamName )) {
            filename = "phoenix2";
        }
        else if ("golden state".equals(teamName )) {
            filename = "golden_state";
        }
        else if ("boston".equals(teamName )) {
            filename = "celtics2";
        }
        else if ("la lakers".equals(teamName )) {
            filename = "lakers2";
        }
        else if ("oklahoma city".equals(teamName )) {
            filename = "okc";
        }
        else if ("denver".equals(teamName )) {
            filename = "denver";
        }
        else if ("new orleans".equals(teamName )) {
            filename = "pelicans";
        }
        else if ("chicago".equals(teamName )) {
            filename = "chicago2";
        }
        else if ("la clippers".equals(teamName )) {
            filename = "clippers";
        }
        else if ("indiana".equals(teamName )) {
            filename = "indiana2";
        }
        else if ("philadelphia".equals(teamName )) {
            filename = "76ers3";
        }
        else if ("orlando".equals(teamName )) {
            filename = "orlando";
        }
        else if ("charlotte".equals(teamName )) {
            filename = "charlotte";
        }
        else if ("sacramento".equals(teamName )) {
            filename = "sacramento";
        }
        else if ("portland".equals(teamName )) {
            filename = "portland2";
        }
        else if ("milwaukee".equals(teamName )) {
            filename = "milwaukee2";
        }
        else if ("toronto".equals(teamName )) {
            filename = "toronto";
        }
        else if ("detroit".equals(teamName )) {
            filename = "detroit";
        }
        else if ("memphis".equals(teamName )) {
            filename = "memphis";
        }
        else if ("brooklyn".equals(teamName )) {
            filename = "brooklyn2";
        }
        else if ("washington".equals(teamName )) {
            filename = "washington";
        }
        else if ("minnesota".equals(teamName )) {
            filename = "minnesota";
        }
        else if ("san antonio".equals(teamName )) {
            filename = "san_antonio";
        }
        else if ("new york".equals(teamName )) {
            filename = "knicks";
        }
        else if ("utah".equals(teamName )) {
            filename = "utah";
        }
        else if ("atlanta".equals(teamName )) {
            filename = "hawks2";
        }

        filename = "src/common/" + filename + ".png";
        return filename;
    }
}
