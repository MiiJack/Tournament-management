package com.miijack.tournamentmanagement.service;

import com.miijack.tournamentmanagement.model.Match;
import com.miijack.tournamentmanagement.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository repository;

    public MatchService(MatchRepository repository) {
        this.repository = repository;
    }

    public List<Match> getAllMatch(Integer pageNumber, Integer pageSize) {
        return repository.findAll(pageNumber, pageSize);
    }

    public Match getMatchById(long id) {
        return repository.findById(id);
    }

    public Match createMatch(Match newMatch) {
        repository.save(newMatch);
        return newMatch;
    }

    public Match updateMatchById(long id, Match match) {
        match.setId(id);
        repository.update(match);
        return match;
    }

    public void deleteMatchById(long id) {
        repository.deleteById(id);
    }
}
