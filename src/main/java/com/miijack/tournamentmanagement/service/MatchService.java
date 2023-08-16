package com.miijack.tournamentmanagement.service;

import com.miijack.tournamentmanagement.model.Match;
import com.miijack.tournamentmanagement.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatchService {
    private MatchRepository repository;
    public MatchService(MatchRepository repository) {
        this.repository = repository;
    }
    public List<Match> getAllMatch() {
        return repository.findAll();
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
