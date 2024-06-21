package com.campuslands.modules.tripcrew.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.tripcrew.domain.Tripcrew;
import com.campuslands.modules.tripcrew.infraestructure.TripcrewRepository;

public class TripcrewService {
    private final TripcrewRepository tripcrewRepository;

    public TripcrewService(TripcrewRepository tripcrewRepository) {
        this.tripcrewRepository = tripcrewRepository;
    }

    public void createTripcrew(Tripcrew tripcrew) {
        tripcrewRepository.save(tripcrew);
    }

    public void updateTripcrew(Tripcrew tripcrew) {
        tripcrewRepository.update(tripcrew);
    }

    public Optional<Tripcrew> getTripcrewById(int id) {
        return tripcrewRepository.findById(id);
    }

    public void deleteTripcrew(int id) {
        tripcrewRepository.delete(id);
    }

    public List<Tripcrew> getAllTripcrews() {
        return tripcrewRepository.findAll();
    }
}
