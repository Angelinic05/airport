package com.campuslands.modules.gate.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.modules.flightfare.domain.Flightfare;
import com.campuslands.modules.gate.domain.Gate;
import com.campuslands.modules.gate.infrastructure.GateRepository;


public class GateMySQLRepository implements GateRepository{
    private final String url;
    private final String user;
    private final String password;

    public GateMySQLRepository (String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override

    public void save(Gate gate){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO gate (gateNumber, idAirport)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, gate.getGateNumber());
                statement.setInt(2, gate.getIdAirport());
                statement.executeUpdate();
            } catch (Exception e) {
                e.getStackTrace();
            }  
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Gate gate){}
    
    @Override
    public Optional<Gate> findById(int id){
        return Optional.empty();
    }
    
    @Override
    public void delete(int id){}
    
    @Override
    public List<Gate> findAll(){
        List<Gate> gate = new ArrayList<>();
        return gate;
    }


    
}
