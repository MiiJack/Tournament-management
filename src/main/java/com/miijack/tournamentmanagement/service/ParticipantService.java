package com.miijack.tournamentmanagement.service;

import com.miijack.tournamentmanagement.model.Participant;
import com.miijack.tournamentmanagement.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository repository;

    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public List<Participant> getAllParticipant(Integer pageNumber, Integer pageSize) {
        return repository.findAll(pageNumber, pageSize);
    }

    public Participant getParticipantById(long id) {
        return repository.findById(id);
    }

    public List<Participant> getParticipantByTournamentId(long id, Integer pageNumber, Integer pageSize) {
        return repository.findByTournamentId(id, pageNumber, pageSize);
    }

    public Participant createParticipant(Participant newParticipant) {
        repository.save(newParticipant);
        return newParticipant;
    }

    public Participant updateParticipantById(long id, Participant participant) {
        return repository.update(id, participant);
    }

    public void deleteParticipantById(long id) {
        repository.deleteById(id);
    }
}