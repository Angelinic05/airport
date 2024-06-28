package com.campuslands.modules.airline.adapter.out;

import com.campuslands.modules.airline.infrastructure.AirlineRepository;
import com.campuslands.modules.airline.domain.Airline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//importacion de todas las herramientas que utilizaremos 

public class AirlineMySQLRepository implements AirlineRepository { //IMPLEMENTAMOS LA INTERFAZ AirlineRepository, ya que aqui es donde vamos a crear el cuerpo de cada metodo/funcion que definimos en esta interface

    private final String url; //definimos los atributos que vamos a utilizar
    private final String user;
    private final String password;


    public AirlineMySQLRepository(String url, String user, String password) { //inicializamos con constructor
        this.url = url;
        this.user = user;
        this.password = password;
    }

    //realizamos polimorfismo de los metodos definidos en la interface y les creamos el cuerpo
    
    @Override
    public void save(Airline airline) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) { //creamos la conexion con la base de datos.
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO airline (name) VALUES (?)");) { 
                statement.setString(1, airline.getName());
                statement.executeUpdate();
                System.out.println("Aerolinea guardada con exito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airline airline) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement("UPDATE airline SET name =? WHERE id =?");) {
                statement.setString(1, airline.getName());
                statement.setInt(2,airline.getId());
                statement.executeUpdate();
                System.out.println("Aerolinea actualizada con exito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Airline> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM airline WHERE id =?");) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Airline(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM airline WHERE id =?");) {
                statement.setInt(1, id);
                statement.executeUpdate();
                System.out.println("Aerolinea eliminada con exito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airline> findAll() {
        List<Airline> airlines = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM airline");) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    airlines.add(new Airline(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airlines;
    }


}
