package com.miijack.tournamentmanagement.controller;

import com.miijack.tournamentmanagement.model.Participant;
import com.miijack.tournamentmanagement.service.ParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/participant")
public class ParticipantController {
    private ParticipantService service;

    public ParticipantController(ParticipantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Participant> getAllParticipant(){
        return service.getAllParticipant();
    }

    @GetMapping("/{id}")
    public Participant getParticipantById(@PathVariable long id){
        return service.getParticipantById(id);
    }

    @PostMapping
    public Participant createParticipant(@RequestBody Participant newParticipant){
        return service.createParticipant(newParticipant);
    }

    @PatchMapping("/{id}")
    public Participant updateParticipantById(@PathVariable long id, @RequestBody Participant participant){
        return service.updateParticipantById(id, participant);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipantById(@PathVariable long id){
        service.deleteParticipantById(id);
    }
}