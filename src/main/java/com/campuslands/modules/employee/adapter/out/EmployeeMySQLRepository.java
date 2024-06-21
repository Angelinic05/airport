package com.campuslands.modules.employee.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Date; 

import com.campuslands.modules.employee.domain.Employee;
import com.campuslands.modules.employee.infrastructure.EmployeeRepository;
import com.campuslands.modules.status.domain.Status;

public class EmployeeMySQLRepository implements EmployeeRepository{

    private final String url;
    private final String user;
    private final String password;

    public EmployeeMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO employee(id, name, idRol, entryDate, idAirline, idAirport) VALUES (?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, employee.getId());
                statement.setString(2, employee.getName());
                statement.setInt(3, employee.getIdRol());
                statement.setDate(4, employee.getEntryDate());
                statement.setInt(5, employee.getIdAirline());
                statement.setInt(6, employee.getIdAirpot());
                statement.executeUpdate(); //PREGUNTAR BIEN QUE ES ESTO
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE employee SET id = ?, name = ?, idRol = ?, entryDate = ?, idAirline = ?, idAirport = ?  WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                 statement.setInt(1, employee.getId());
                 statement.setString(2, employee.getName());
                 statement.setInt(3, employee.getIdRol());
                 statement.setDate(4, employee.getEntryDate());
                 statement.setInt(5, employee.getIdAirline());
                 statement.setInt(6, employee.getIdAirpot());
                 statement.setInt(7, employee.getId());
                 statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Optional<Employee> findById(int id){
        return Optional.empty();
    }
    
    @Override
    public void delete(int id){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM employee WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Employee> findAll(){
        List<Employee> employee = new ArrayList<>();
        return employee;
    }
}
