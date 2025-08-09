package com.lta.carparkvis.web.rest;

import com.lta.carparkvis.domain.Reservation;
import com.lta.carparkvis.security.services.UserDetailsImpl;
import com.lta.carparkvis.service.ReservationService;
import com.lta.carparkvis.web.rest.dto.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createReservation(@Valid @RequestBody ReservationRequest reservationRequest,
                                               @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            Reservation reservation = reservationService.createReservation(userDetails.getId(), reservationRequest.getCarparkId());
            // In a real application, we would return a DTO instead of the entity.
            // For simplicity, we return the entity here.
            return ResponseEntity.ok(reservation);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
} 