package com.campuslands.modules.airport.adapter.out;

import com.campuslands.modules.airport.domain.Airport;
import com.campuslands.modules.airport.infrastructure.AirportRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportMySQLRepository implements AirportRepository {
    private final String url = "jdbc:mysql://localhost:3306/airport_db";
    private final String username = "root";
    private final String password = "root";

    public AirportMySQLRepository() {}

    @Override
    public void save(Airport airport) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO airports (name, idCity, xPosition, yPosition) VALUES (?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airport.getName());
                statement.setInt(2, airport.getIdCity());
                statement.setDouble(3, airport.getyPosition());
                statement.setDouble(4, airport.getxPosition());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Airport airport) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE airports SET name =?, idCity =?, xPosition =?, yPosition=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airport.getName());
                statement.setInt(2, airport.getIdCity());
                statement.setDouble(3, airport.getxPosition());
                statement.setDouble(4, airport.getyPosition());
                statement.setInt(5, airport.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Airport> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM airports WHERE id =?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(new Airport(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("idCity"),
                            resultSet.getDouble("xPosition"),
                            resultSet.getDouble("yPosition")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM airports WHERE id =?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Airport> findAll() {
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM airports";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    airports.add(new Airport(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("idCity"),
                        resultSet.getDouble("xPosition"),
                        resultSet.getDouble("yPosition")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }


}
