package com.lta.carparkvis.web.rest;

import com.lta.carparkvis.service.CarparkService;
import com.lta.carparkvis.web.rest.dto.CarparkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CarparkController {

    @Autowired
    private CarparkService carparkService;

    @GetMapping("/carparks")
    public ResponseEntity<List<CarparkDTO>> getAllCarparks() {
        List<CarparkDTO> carparks = carparkService.getAllCarparks();
        return ResponseEntity.ok(carparks);
    }

    @GetMapping("/carparks/search")
    public ResponseEntity<List<CarparkDTO>> searchCarparks(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "500") double distance) {
        List<CarparkDTO> carparks = carparkService.findCarparksNearby(lat, lon, distance);
        return ResponseEntity.ok(carparks);
    }

    @GetMapping("/carparks/search-by-street")
    public ResponseEntity<List<CarparkDTO>> searchCarparksByStreet(
            @RequestParam String street,
            @RequestParam(defaultValue = "1000") double distance) {
        List<CarparkDTO> carparks = carparkService.findCarparksByStreet(street, distance);
        return ResponseEntity.ok(carparks);
    }
} 