package com.miijack.tournamentmanagement.service;

import com.miijack.tournamentmanagement.model.Tournament;
import com.miijack.tournamentmanagement.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<Tournament> getFutureTournament(Integer pageNumber, Integer pageSize) {
        List<Tournament> tournaments = repository.findAll(null, null);
        List<Tournament> futureTournaments = new ArrayList<>();
        for (Tournament tournament : tournaments) {
            if (tournament.getDate().isAfter(LocalDateTime.now())) {
                futureTournaments.add(tournament);
            }
        }
        int startIndex = 0;
        int endIndex = futureTournaments.size();

        if (pageNumber != null && pageSize != null) {
            startIndex = (pageNumber - 1) * pageSize;
            endIndex = Math.min(startIndex + pageSize, futureTournaments.size());
        }
        return futureTournaments.subList(startIndex, endIndex);
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