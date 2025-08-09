package com.lta.carparkvis.web.rest;

import com.lta.carparkvis.service.CarparkService;
import com.lta.carparkvis.web.rest.dto.CarparkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
} 