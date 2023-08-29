package com.miijack.tournamentmanagement.controller;

import com.miijack.tournamentmanagement.model.Match;
import com.miijack.tournamentmanagement.model.Participant;
import com.miijack.tournamentmanagement.service.MatchService;
import com.miijack.tournamentmanagement.service.OtherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/match")
public class MatchController {
    private final MatchService service;
    private final OtherService otherService;

    public MatchController(MatchService service, OtherService otherService) {
        this.service = service;
        this.otherService = otherService;
    }

    @GetMapping
    public List<Match> getAllMatch(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                   @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return service.getAllMatch(pageNumber, pageSize);
    }

    @GetMapping("/{id}/results")
    public Map<String, Participant> displayResults(@PathVariable long id){
        return otherService.displayResults(id);
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable long id) {
        return service.getMatchById(id);
    }

    @PostMapping
    public Match createMatch(@RequestBody Match newMatch) {
        return service.createMatch(newMatch);
    }

    @PatchMapping("/{id}")
    public Match updateMatchById(@PathVariable long id, @RequestBody Match match) {
        return service.updateMatchById(id, match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatchById(@PathVariable long id) {
        service.deleteMatchById(id);
    }
}

