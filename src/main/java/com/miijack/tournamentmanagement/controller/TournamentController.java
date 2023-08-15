package com.miijack.tournamentmanagement.controller;

import com.miijack.tournamentmanagement.model.Tournament;
import com.miijack.tournamentmanagement.service.TournamentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tournament")
public class TournamentController {
        private TournamentService service;

    public TournamentController(TournamentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tournament> getAllTournament(){
        return service.getAllTournament();
    }

    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable long id){
        return service.getTournamentById(id);
    }

    @PostMapping
    public Tournament createTournament(@RequestBody Tournament newTournament){
        return service.createTournament(newTournament);
    }

    @PatchMapping("/{id}")
    public Tournament updateTournamentById(@PathVariable long id, @RequestBody Tournament tournament){
        return service.updateTournamentById(id, tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournamentById(@PathVariable long id){
        service.deleteTournamentById(id);
    }
}

