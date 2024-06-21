package com.campuslands.modules.model.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.modules.manufacture.domain.Manufacture;
import com.campuslands.modules.model.domain.Model;
import com.campuslands.modules.model.infrastructure.ModelRepository;


public class ModelMySQLRepository implements ModelRepository {
    private final String url;
    private final String user;
    private final String password;

    public ModelMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Model model){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO model (name, idManufactures) VALUES (?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, model.getName());
                statement.setInt(2, model.getIdManufactures());
                statement.executeUpdate();
            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Model model){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE model SET name = ?, idManufactures = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, model.getName());
                statement.setInt(2, model.getIdManufactures());
                statement.setInt(3, model.getId());
                statement.executeUpdate();                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Optional<Model> findById(int id){
        return Optional.empty();
    }
    
    @Override
    public void delete(int id){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM model WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }
    
    @Override
    public List<Model> findAll(){
        List<Model> model = new ArrayList<>();
        return model;
    }

    
    
}
