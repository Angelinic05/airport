package com.campuslands.modules.city.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.modules.city.domain.City;
import com.campuslands.modules.city.infrastructure.CityRepository;


public class CityMySQLRepository implements CityRepository {

    private static final String url = "jdbc:mysql://localhost:3306/campuslands";
    private static final String user = "root";
    private static final String password = "root";

    @Override
    public Optional<City> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM cities WHERE id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idCity = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return Optional.of(new City(name, idCity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(City city) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO cities (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(City city) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE cities SET name =? WHERE id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city.getName());
            statement.setInt(2, city.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM cities WHERE id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM cities";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idCity = resultSet.getInt("id");
                String name = resultSet.getString("name");
                cities.add(new City(name, idCity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
    
    
}
