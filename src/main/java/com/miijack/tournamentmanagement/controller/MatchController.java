package com.miijack.tournamentmanagement.controller;

import com.miijack.tournamentmanagement.model.Match;
import com.miijack.tournamentmanagement.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {
    private MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @GetMapping
    public List<Match> getAllMatch(){
        return service.getAllMatch();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable long id){
        return service.getMatchById(id);
    }

    @PostMapping
    public Match createMatch(@RequestBody Match newMatch){
        return service.createMatch(newMatch);
    }

    @PatchMapping("/{id}")
    public Match updateMatchById(@PathVariable long id, @RequestBody Match match){
        return service.updateMatchById(id, match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatchById(@PathVariable long id){
        service.deleteMatchById(id);
    }
}

