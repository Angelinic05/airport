package com.campuslands.modules.tripbookingdetail.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.modules.tripbookingdetail.domain.Tripbookingdetail;

public interface TripbookingdetailRepository {
    void save(Tripbookingdetail tripbookingdetail);
    void update(Tripbookingdetail tripbookingdetail);
    Optional<Tripbookingdetail> findById(int id);
    void delete(int id);
    List<Tripbookingdetail> findAll();
    int planeCapacity(int id); //Metodo para sacar la capacidad de un avion en especifico
    List<Integer> SeatsOccupied(); //Metodo para sacar los asientos ocupados de un avion
    void printAvailableSeats(ArrayList<Integer> SeatsOccupied); //Metodo para imprimir todos los asientos disponibles
}
