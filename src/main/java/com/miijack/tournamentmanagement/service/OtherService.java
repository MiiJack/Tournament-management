package com.miijack.tournamentmanagement.service;

import com.miijack.tournamentmanagement.repository.MatchRepository;
import com.miijack.tournamentmanagement.repository.ParticipantRepository;
import com.miijack.tournamentmanagement.repository.TournamentRepository;
import com.miijack.tournamentmanagement.model.Participant;
import com.miijack.tournamentmanagement.model.Match;
import com.miijack.tournamentmanagement.model.Tournament;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OtherService {
    private final TournamentRepository tournamentRepository;
    private final ParticipantRepository participantRepository;
    private final MatchRepository matchRepository;

    public OtherService(TournamentRepository tournamentRepository, ParticipantRepository participantRepository, MatchRepository matchRepository) {
        this.tournamentRepository = tournamentRepository;
        this.participantRepository = participantRepository;
        this.matchRepository = matchRepository;
    }

    public Map<String, Participant> displayResults(long matchId) {
        int[] winnerAndLoserIds = matchRepository.getWinnerAndLoserIds(matchId);
        int winnerId = winnerAndLoserIds[0];
        int loserId = winnerAndLoserIds[1];

        Participant winner = participantRepository.findById(winnerId);
        Participant loser = participantRepository.findById(loserId);

        Map<String, Participant> results = new HashMap<>();
        results.put("winner", winner);
        results.put("loser", loser);

        return results;
    }
}
