package com.reports.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reports.backend.converters.CapabilityConverter;
import com.reports.backend.data.CapabilityData;
import com.reports.backend.entities.Capability;
import com.reports.backend.repositories.CapabilityRepository;

@Service
public class CapabilityService {
    @Autowired
    private CapabilityRepository capabilityRepository;

    private final CapabilityConverter capabilityConverter = new CapabilityConverter();

    // List all capabilities
    public List<CapabilityData> findAll() {
        return capabilityConverter.toData(capabilityRepository.findAll());
    }

    // Find capability by ID
    public CapabilityData findById(int id) {
        Optional<Capability> capability = capabilityRepository.findById(id);
        if (capability.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The occupation type doesn't exists");
        }
        return capabilityConverter.toData(capability.get());
    }

    // Add a capability
    public CapabilityData insert(CapabilityData capability) {
        if (capabilityRepository.existsById(capability.getCapabilityID())) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "The capability already exists");
        }
        return capabilityConverter.toData(capabilityRepository.save(capabilityConverter.toEntity(capability)));
    }

    // Delete a capability
    public CapabilityData deleteById(int id) {
        Optional<Capability> capability = capabilityRepository.findById(id);
        if (capability.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Capability doesn`t exists");
        }
        capabilityRepository.deleteById(id);
        return capabilityConverter.toData(capability.get());
    }

}
