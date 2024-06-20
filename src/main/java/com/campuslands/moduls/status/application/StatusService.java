package com.campuslands.moduls.status.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.moduls.status.domain.Status;
import com.campuslands.moduls.status.infraestructure.StatusRepository;

public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository ciudadRepository) {
        this.statusRepository = ciudadRepository;
    }

    public void createStatus(Status ciudad) {
        statusRepository.save(ciudad);
    }

    public void updateStatus(Status ciudad) {
        statusRepository.update(ciudad);
    }

    public Optional<Status> getStatusById(int id) {
        return statusRepository.findById(id);
    }

    public void deleteStatus(int id) {
        statusRepository.delete(id);
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }
}
