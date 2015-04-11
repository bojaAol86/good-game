angular.module('templates-app', ['about/about.tpl.html', 'home/home.tpl.html']);

angular.module("about/about.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("about/about.tpl.html",
    "<div class=\"row\">\n" +
    "  <h1 class=\"page-header\">\n" +
    "    Was it a good game?\n" +
    "  </h1>\n" +
    "\n" +
    "  <p>Choose the best game from yesterday, and don't ever be disappointed!</p>\n" +
    "</div>\n" +
    "\n" +
    "");
}]);

angular.module("home/home.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("home/home.tpl.html",
    "<div class=\"jumbotron\">\n" +
    "  <div class=\"good-header\">Was it a Good Game?</div>\n" +
    "</div>\n" +
    "<div class=\"marketing\">\n" +
    "    <div class=\"date-header\">Today</div>\n" +
    "    <div  ng-repeat=\"result in todayScores | orderBy:'-WasItAGoodGame'\">\n" +
    "        <div class=\" scoresContainer container\" ng-class=\"{good:result.WasItAGoodGame, bad:!result.WasItAGoodGame,unfinished: result.Score === 'unfinished'}\">\n" +
    "          <div class=\"row row-centered vertical-align\">\n" +
    "            <div class=\"col-xs-5\">\n" +
    "              <img class=\"img-responsive team-logo center-block\" ng-src=\"{{result.HomeTeam.LogoUrl}}\"/>\n" +
    "                <div class=\"row row-centered vertical-align \">\n" +
    "                    <div class=\"text-center span12\">{{result.HomeTeam.Name}}</div>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "            <div class=\"col-xs-2 vs\">\n" +
    "                <div class=\"container\">VS</div>\n" +
    "            </div>\n" +
    "            <div class=\"col-xs-5\">\n" +
    "              <img class=\"img-responsive team-logo center-block\" ng-src=\"{{result.AwayTeam.LogoUrl}}\"/>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "    <div class =\"scoresContainer container no-game\" ng-show=\"todayScores === undefined\">\n" +
    "        <div class=\"row row-centered vertical-align\">\n" +
    "            <div class=\"col-xs-4\">\n" +
    "                <img class=\"img-responsive team-logo center-block\" ng-src=\"assets/NBA.png\"/>\n" +
    "            </div>\n" +
    "            <div class=\"col-xs-8\">No games today</div>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "    <div class=\"date-header\">Yesterday</div>\n" +
    "    <div  ng-repeat=\"result in yesterdayScores | orderBy:'-WasItAGoodGame'\">\n" +
    "        <div class=\" scoresContainer container\" ng-class=\"{good:result.WasItAGoodGame, bad:!result.WasItAGoodGame}\">\n" +
    "            <div class=\"row row-centered vertical-align\">\n" +
    "                <div class=\"col-xs-5\">\n" +
    "                    <img class=\"img-responsive team-logo center-block\" ng-src=\"{{result.HomeTeam.LogoUrl}}\"/>\n" +
    "                </div>\n" +
    "                <div class=\"col-xs-2 vs\">VS</div>\n" +
    "                <div class=\"col-xs-5\">\n" +
    "                    <img class=\"img-responsive team-logo center-block\" ng-src=\"{{result.AwayTeam.LogoUrl}}\"/>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "</div>\n" +
    "\n" +
    "");
}]);
