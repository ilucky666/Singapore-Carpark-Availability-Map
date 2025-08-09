package com.lta.carparkvis.service;

import com.lta.carparkvis.repository.CarparkRepository;
import com.lta.carparkvis.web.rest.dto.CarparkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarparkService {

    @Autowired
    private CarparkRepository carparkRepository;

    @Autowired
    private GeocodingService geocodingService;

    @Transactional(readOnly = true)
    public List<CarparkDTO> getAllCarparks() {
        // For now, we only get Car parks (LotType 'C'), this can be parameterized later.
        return carparkRepository.findAll().stream()
                .filter(carpark -> carpark.getLocation() != null && "C".equals(carpark.getLotType()))
                .map(CarparkDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CarparkDTO> findCarparksNearby(double lat, double lon, double distance) {
        return carparkRepository.findCarparksWithin(lon, lat, distance).stream()
                .map(CarparkDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CarparkDTO> findCarparksByStreet(String street, double distance) {
        return geocodingService.geocodeStreet(street)
                .map(coords -> findCarparksNearby(coords[0], coords[1], distance))
                .orElse(List.of());
    }
} 