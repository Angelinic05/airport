package com.campuslands.modules.flightconnection.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.modules.employee.domain.Employee;
import com.campuslands.modules.flightconnection.domain.Flightconnection;
import com.campuslands.modules.flightconnection.infrastructure.FlightconnectionRepository;

public class FlightconnectionMySQLRepository implements FlightconnectionRepository{

    private final String url;
    private final String user;
    private final String password;

    public FlightconnectionMySQLRepository(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override

    public void save(Flightconnection flightconnection){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO flightconnection (connectionNumber, idTrip, idPlane, idAirport) VALUES (?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, flightconnection.getConnectionNumber());
                statement.setInt(2, flightconnection.getIdTrip());
                statement.setInt(3, flightconnection.getIdPlane());
                statement.setInt(4, flightconnection.getIdAirport());
                statement.executeUpdate(); //PREGUNTAR BIEN QUE ES ESTO
            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Flightconnection flightconnection){}
    
    @Override
    public Optional<Flightconnection> findById(int id){
        return Optional.empty();
    }
    
    @Override
    public void delete(int id){}
    
    @Override
    public List<Flightconnection> findAll(){
        List<Flightconnection> flightconnection = new ArrayList<>();
        return flightconnection;
    }


    
}
