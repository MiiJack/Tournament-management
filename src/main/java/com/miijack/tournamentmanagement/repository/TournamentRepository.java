package com.miijack.tournamentmanagement.repository;

import com.miijack.tournamentmanagement.model.Tournament;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TournamentRepository {
    private Connection connection;

    public TournamentRepository(Connection connection) {
        this.connection = connection;
    }
    private Tournament convertToTournament(ResultSet result) throws SQLException {
        Tournament tournament = new Tournament();
        tournament.setId(result.getLong("id"));
        tournament.setName(result.getString("name"));
        tournament.setType(result.getString("type"));
        tournament.setDate(result.getTimestamp("date"));
        tournament.setLocation(result.getString("location"));
        tournament.setDescription(result.getString("description"));
        return tournament;
    }
    private void convertToList(List<Tournament> tournaments, ResultSet result) throws SQLException {
        tournaments.add(new Tournament(
                result.getLong("id"),
                result.getString("name"),
                result.getString("type"),
                result.getTimestamp("date"),
                result.getString("location"),
                result.getString("description")
        ));
    }
    public List<Tournament> findAll() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM \"tournament\"";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                convertToList(tournaments, result);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return tournaments;
    }

    public Tournament findById(long id) {
        Tournament tournament = null;
        String sql = "SELECT * FROM \"tournament\" WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                tournament = convertToTournament(result);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return tournament;
    }

    public void save(Tournament tournament) {
        String sql = "INSERT INTO \"tournament\" (name, type, date, location, description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tournament.getName());
            preparedStatement.setString(2, tournament.getType());
            preparedStatement.setTimestamp(3, tournament.getDate());
            preparedStatement.setString(4, tournament.getLocation());
            preparedStatement.setString(5, tournament.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Tournament update(long id, Tournament tournament) {
        String sql = "UPDATE \"tournament\" SET name = ?, type = ?, date = ?," +
                     " location = ?, description = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tournament.getName());
            preparedStatement.setString(2, tournament.getType());
            preparedStatement.setTimestamp(3, tournament.getDate());
            preparedStatement.setString(4, tournament.getLocation());
            preparedStatement.setString(5, tournament.getDescription());
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tournament;
    }

    public void deleteById(long id) {
        String sql = "DELETE FROM \"tournament\" WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}