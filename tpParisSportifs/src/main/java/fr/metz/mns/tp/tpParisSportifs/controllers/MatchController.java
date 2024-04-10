package fr.metz.mns.tp.tpParisSportifs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.metz.mns.tp.tpParisSportifs.services.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

	public MatchService getMatchService() {
		return matchService;
	}

    // FIXME Points de terminaison pour obtenir des matchs, créer de nouveaux matchs.
}