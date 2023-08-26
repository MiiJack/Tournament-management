package com.miijack.tournamentmanagement.repository;

import com.miijack.tournamentmanagement.model.Participant;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ParticipantRepository {
    private Connection connection;
    public ParticipantRepository(Connection connection) {
        this.connection = connection;
    }
    private void convertToList(List<Participant> participants, ResultSet result) throws SQLException {
        participants.add(new Participant(
                result.getLong("id"),
                result.getString("username"),
                result.getString("name"),
                result.getDate("birthdate").toLocalDate(),
                result.getString("team")
        ));
    }

    private Participant convertToParticipant(ResultSet result) throws SQLException {
        Participant participant = new Participant();
        participant.setId(result.getLong("id"));
        participant.setUsername(result.getString("username"));
        participant.setName(result.getString("name"));
        participant.setBirthdate(result.getDate("birthdate").toLocalDate());
        participant.setTeam(result.getString("team"));
        return participant;
    }
    public List<Participant> findAll() {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM \"participant\"";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                convertToList(participants, result);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return participants;
    }

    public Participant findById(long id) {
        Participant participant = null;
        String sql = "SELECT * FROM \"participant\" WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                participant = convertToParticipant(result);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return participant;
    }

    public void save(Participant participant) {
        String sql = "INSERT INTO \"participant\" (username, name, birthdate, team) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, participant.getUsername());
            preparedStatement.setString(2, participant.getName());
            preparedStatement.setDate(3, Date.valueOf(participant.getBirthdate()));
            preparedStatement.setString(4, participant.getTeam());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Participant update(long id, Participant participant) {
        String sql = "UPDATE \"participant\" SET username = ?, name = ?, birthdate = ?, team = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, participant.getUsername());
            preparedStatement.setString(2, participant.getName());
            preparedStatement.setDate(3, Date.valueOf(participant.getBirthdate()));
            preparedStatement.setString(4, participant.getTeam());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return participant;
    }

    public void deleteById(long id) {
        String sql = "DELETE FROM \"participant\" WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
