package com.miijack.tournamentmanagement.service;

import com.miijack.tournamentmanagement.model.Participant;
import com.miijack.tournamentmanagement.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private ParticipantRepository repository;

    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public List<Participant> getAllParticipant() {
        return repository.findAll();
    }

    public Participant getParticipantById(long id) {
        return repository.findById(id);
    }

    public Participant createParticipant(Participant newParticipant) {
        repository.save(newParticipant);
        return newParticipant;
    }

    public Participant updateParticipantById(long id, Participant participant) {
        participant.setId(id);
        repository.update(participant);
        return participant;
    }

    public void deleteParticipantById(long id) {
        repository.deleteById(id);
    }
}