package com.springapp.mvc;

import com.springapp.mvc.Parsers.NbcParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/scores")
public class ScoresController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Map<String,ArrayList<ResultData>> getScores(ModelMap model) {

		Parser parser = new NbcParser();
		Map<String,ArrayList<ResultData>> results = parser.parse();
		return results;
	}
}