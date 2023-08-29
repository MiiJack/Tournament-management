package com.miijack.tournamentmanagement.repository;

import com.miijack.tournamentmanagement.model.Match;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchRepository {
    private final Connection connection;

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

    public List<Match> findAll(Integer pageNumber, Integer pageSize) {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT * FROM \"match\"";
        if (pageNumber != null && pageSize != null) {
            sql += " LIMIT ? OFFSET ?";
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            if (pageNumber != null && pageSize != null) {
                preparedStatement.setInt(1, pageSize);
                preparedStatement.setInt(2, (pageNumber - 1) * pageSize);
            }
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

    public int[] getWinnerAndLoserIds(long matchId) {
        String sql1 = "SELECT participant1_id, participant1_score, participant2_id, participant2_score " +
                "FROM \"match\" " +
                "WHERE id = ? " +
                "AND participant1_score > participant2_score";
        String sql2 = "SELECT participant2_id, participant1_id " +
                "FROM \"match\" " +
                "WHERE id = ? " +
                "AND participant2_score > participant1_score";
        int[] winnerAndLoserIds = new int[2];
        try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
            preparedStatement1.setLong(1, matchId);
            ResultSet result1 = preparedStatement1.executeQuery();
            if (result1.next()) {
                winnerAndLoserIds[0] = result1.getInt("participant1_id");
                winnerAndLoserIds[1] = result1.getInt("participant2_id");
            } else {
                preparedStatement2.setLong(1, matchId);
                ResultSet result2 = preparedStatement2.executeQuery();
                if (result2.next()) {
                    winnerAndLoserIds[0] = result2.getInt("participant2_id");
                    winnerAndLoserIds[1] = result2.getInt("participant1_id");
                } else {
                    winnerAndLoserIds[0] = -1;
                    winnerAndLoserIds[1] = -1;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return winnerAndLoserIds;
    }
}
