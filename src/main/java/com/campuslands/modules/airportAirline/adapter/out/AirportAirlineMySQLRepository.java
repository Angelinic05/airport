package com.campuslands.modules.airportAirline.adapter.out;

import com.campuslands.modules.airportAirline.domain.AirportAirline;
import com.campuslands.modules.airportAirline.infrastructure.AirportAirlineRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportAirlineMySQLRepository implements AirportAirlineRepository {
    
    private String url = "jdbc:mysql://localhost:3306/airport";
    private String user = "root";
    private String password = "root";

    @Override
    public void save(AirportAirline airportAirline) {
        try (Connection connection = DriverManager.getConnection(url, user, password);){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO airportairline (idAirport, idAirline) VALUES (?, ?)");
            statement.setInt(1, airportAirline.getIdAirport());
            statement.setInt(2, airportAirline.getIdAirline());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }        
    }

    @Override
    public Optional<AirportAirline> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM airportairline WHERE id =?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(new AirportAirline(
                        resultSet.getInt("id"),
                        resultSet.getInt("idAirport"),
                        resultSet.getInt("idAirline")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<AirportAirline> findAll() {
        List<AirportAirline> airportAirlines = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM airportairline");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                airportAirlines.add(new AirportAirline(
                        resultSet.getInt("id"),
                        resultSet.getInt("idAirport"),
                        resultSet.getInt("idAirline")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airportAirlines;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM airportairline WHERE id =?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(AirportAirline airportAirline) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("UPDATE airportairline SET idAirport =?, idAirline =? WHERE id =?");
            statement.setInt(1, airportAirline.getIdAirport());
            statement.setInt(2, airportAirline.getIdAirline());
            statement.setInt(3, airportAirline.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
