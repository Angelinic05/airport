package com.campuslands.modules.tripbookingdetail.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.tripbooking.domain.Tripbooking;
import com.campuslands.modules.tripbooking.infraestructure.TripbookingRepository;
import com.campuslands.modules.tripbookingdetail.domain.Tripbookingdetail;
import com.campuslands.modules.tripbookingdetail.infraestructure.TripbookingdetailRepository;

public class TripbookingdetailService {
    private final TripbookingdetailRepository tripbookingdetailRepository;
    private final TripbookingRepository tripbookingRepository;

    public TripbookingdetailService(TripbookingdetailRepository tripbookingdetailRepository,  TripbookingRepository tripbookingRepository) {
        this.tripbookingdetailRepository = tripbookingdetailRepository;
        this.tripbookingRepository = tripbookingRepository;
    }

    public void createTripbookingdetail(Tripbookingdetail tripbookingdetail) {
        tripbookingdetailRepository.save(tripbookingdetail);
    }

    public void updateTripbookingdetail(Tripbookingdetail tripbookingdetail) {
        tripbookingdetailRepository.update(tripbookingdetail);
    }

    public Optional<Tripbookingdetail> getTripbookingdetailById(int id) {
        return tripbookingdetailRepository.findById(id);
    }

    public void deleteTripbookingdetail(int id) {
        tripbookingdetailRepository.delete(id);
    }

    public List<Tripbookingdetail> getAllTripbookingdetails() {
        return tripbookingdetailRepository.findAll();
    }

    public List<Tripbooking> flightsAvailable(){
        return tripbookingRepository.flightsAvailable();
    }

    public int planeCapacity(int id){
        return tripbookingdetailRepository.planeCapacity(id);
    }

    public List<Integer> SeatsOccupied(){
        return tripbookingdetailRepository.SeatsOccupied();
    } 
}
