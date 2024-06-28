package com.campuslands.modules.airline.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.airline.domain.Airline;

public interface AirlineRepository{
    void save(Airline airline); //guardar aerolinea, le pasamos como parametro un objeto de tipo aerolinea que vamos a guardar
    void update(Airline airline); //Actualiar aerolinea, le pasamos como parametro un objeto de tipo aerolinea, que vamos a actualizar 
    Optional<Airline> findById(int id); //Utilizamos Optional cuando es posible que el programa no encuentre lo que estamos buscando, pasamos como parametro el id que queremos buscar
    void delete(int id); //eliminar aerolinea, le pasamos como parametro el id de la aerolinea que vamos a actualizar 
    List<Airline> findAll();
}

//Definimos cada metodo o funcion que vamos a utilizar con esta clase en especifico