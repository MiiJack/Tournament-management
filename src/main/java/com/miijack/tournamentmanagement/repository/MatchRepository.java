package com.miijack.tournamentmanagement.repository;

import com.miijack.tournamentmanagement.model.Match;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchRepository {
    private Connection connection;

    public MatchRepository(Connection connection) {
        this.connection = connection;
    }

    private Match convertToMatch(ResultSet result) throws SQLException {
        Match match = new Match();
        match.setId(result.getLong("id"));
        match.setTournament_id(result.getLong("tournament_id"));
        match.setParticipant1_id(result.getLong("participant1_id"));
        match.setParticipant2_id(result.getLong("participant2_id"));
        match.setMatch_date(result.getTimestamp("match_date").toLocalDateTime());
        match.setParticipant1_score(result.getInt("participant1_score"));
        match.setParticipant2_score(result.getInt("participant2_score"));
        match.setRound(result.getInt("round"));
        return match;
    }

    private void convertToList(List<Match> matches, ResultSet result) throws SQLException {
        matches.add(new Match(
                result.getLong("id"),
                result.getLong("tournament_id"),
                result.getLong("participant1_id"),
                result.getLong("participant2_id"),
                result.getTimestamp("match_date").toLocalDateTime(),
                result.getInt("participant1_score"),
                result.getInt("participant2_score"),
                result.getInt("round")
        ));
    }
    public List<Match> findAll() {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT * FROM \"match\"";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                 convertToList(matches, result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return matches;
    }


    public Match findById(long id) {
        Match match = null;
        String sql = "SELECT * FROM \"match\" WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                match = convertToMatch(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return match;
    }


    public void save(Match match) {
        String sql = "INSERT INTO \"match\" (tournament_id, participant1_id, participant2_id," +
                     " match_date, participant1_score, participant2_score, round) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, match.getTournament_id());
            preparedStatement.setLong(2, match.getParticipant1_id());
            preparedStatement.setLong(3, match.getParticipant2_id());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(match.getMatch_date()));
            preparedStatement.setInt(5, match.getParticipant1_score());
            preparedStatement.setInt(6, match.getParticipant2_score());
            preparedStatement.setInt(7, match.getRound());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void update(Match match) {
        String sql = "UPDATE \"match\" SET tournament_id = ?, participant1_id = ?, participant2_id = ?," +
                " match_date = ?, participant1_score = ?, participant2_score = ?, round = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, match.getTournament_id());
            preparedStatement.setLong(2, match.getParticipant1_id());
            preparedStatement.setLong(3, match.getParticipant2_id());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(match.getMatch_date()));
            preparedStatement.setInt(5, match.getParticipant1_score());
            preparedStatement.setInt(6, match.getParticipant2_score());
            preparedStatement.setInt(7, match.getRound());
            preparedStatement.setLong(8, match.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteById(long id) {
        String sql = "DELETE FROM \"match\" WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
