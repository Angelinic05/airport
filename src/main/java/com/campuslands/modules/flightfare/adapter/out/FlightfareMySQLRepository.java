package com.campuslands.modules.flightfare.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.modules.flightconnection.domain.Flightconnection;
import com.campuslands.modules.flightfare.domain.Flightfare;
import com.campuslands.modules.flightfare.infrastructure.FlightfareRepository;


public class FlightfareMySQLRepository implements FlightfareRepository {

    private final String url;
    private final String user;
    private final String password;

    public FlightfareMySQLRepository(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Flightfare flightfare){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO flightfare (description,details,value) VALUES (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, flightfare.getDescription());
                statement.setString(2, flightfare.getDetails());
                statement.setDouble(3, flightfare.getValue());
                statement.executeUpdate(); //PREGUNTAR BIEN QUE ES ESTO
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Flightfare flightfare){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE flightfare SET description = ?, details = ?, values = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, flightfare.getDescription());
                statement.setString(2, flightfare.getDetails());
                statement.setDouble(3, flightfare.getValue());
                statement.setInt(4, flightfare.getId());
                statement.executeUpdate();   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Optional<Flightfare> findById(int id){
        return Optional.empty();
    }
    
    @Override
    public void delete(int id){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM flightfare WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Flightfare> findAll(){
        List<Flightfare> flightfare = new ArrayList<>();
        return flightfare;
    }




    
}
