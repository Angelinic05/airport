package com.campuslands.modules.manufacture.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.modules.gate.domain.Gate;
import com.campuslands.modules.manufacture.domain.Manufacture;
import com.campuslands.modules.manufacture.infrastructure.ManufactureRepository;

public class ManufactureMySQLRepository implements ManufactureRepository{
    private final String url;
    private final String user;
    private final String password;

    public ManufactureMySQLRepository(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override

    public void save(Manufacture manufacture){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSER INTO manufacture (name) VALUES (?)";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setNString(1, manufacture.getName());
                statement.executeUpdate();
            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Manufacture manufacture){}
    
    @Override
    public Optional<Manufacture> findById(int id){
        return Optional.empty();
    }
    
    @Override
    public void delete(int id){}
    
    @Override
    public List<Manufacture> findAll(){
        List<Manufacture> manufacture = new ArrayList<>();
        return manufacture;
    }
    
}
