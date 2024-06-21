package com.campuslands.modules.revemployee.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.campuslands.modules.plane.domain.Plane;
import com.campuslands.modules.revemployee.domain.Revemployee;
import com.campuslands.modules.revemployee.infrastructure.RevemployeeRepository;

public class RevemployeeMySQLRepository implements RevemployeeRepository {
    private final String url;
    private final String user;
    private final String password;

    public RevemployeeMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Revemployee revemployee){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO revemployee (idEmployee, idRevision) VALUES (?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, revemployee.getIdEmployee());
                statement.setInt(2, revemployee.getIdRevision());
                statement.executeUpdate();
            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Revemployee revemployee){}
    
    @Override
    public Optional<Revemployee> findById(int id){
        return Optional.empty();
    }
    
    @Override
    public void delete(int id){}
    
    @Override
    public List<Revemployee> findAll(){
        List<Revemployee> revemployee = new ArrayList<>();
        return revemployee;
    }
    
}
