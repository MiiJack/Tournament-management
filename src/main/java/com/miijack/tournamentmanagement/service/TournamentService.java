package com.miijack.tournamentmanagement.service;

import com.miijack.tournamentmanagement.model.Tournament;
import com.miijack.tournamentmanagement.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    private final TournamentRepository repository;

    public TournamentService(TournamentRepository repository) {
        this.repository = repository;
    }

    public List<Tournament> getAllTournament(Integer pageNumber, Integer pageSize) {
        return repository.findAll(pageNumber, pageSize);
    }

    public Tournament getTournamentById(long id) {
        return repository.findById(id);
    }

    public Tournament createTournament(Tournament newTournament) {
        repository.save(newTournament);
        return newTournament;
    }

    public Tournament updateTournamentById(long id, Tournament tournament) {
        return repository.update(id, tournament);
    }

    public void deleteTournamentById(long id) {
        repository.deleteById(id);
    }
}