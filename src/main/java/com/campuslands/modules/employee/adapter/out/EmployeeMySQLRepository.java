package com.campuslands.modules.employee.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.campuslands.modules.employee.domain.Employee;
import com.campuslands.modules.employee.infrastructure.EmployeeRepository;

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
                
            } catch (Exception e) {
                // TODO: handle exception
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
        

    




    
}
