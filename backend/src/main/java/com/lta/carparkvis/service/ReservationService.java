package com.lta.carparkvis.service;

import com.lta.carparkvis.domain.Carpark;
import com.lta.carparkvis.domain.Reservation;
import com.lta.carparkvis.domain.User;
import com.lta.carparkvis.repository.CarparkRepository;
import com.lta.carparkvis.repository.ReservationRepository;
import com.lta.carparkvis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class ReservationService {

    private static final int RESERVATION_EXPIRY_MINUTES = 30;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarparkRepository carparkRepository;

    public Reservation createReservation(Long userId, String carparkId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Carpark carpark = carparkRepository.findById(carparkId)
                .orElseThrow(() -> new RuntimeException("Carpark not found"));

        if (carpark.getAvailableLots() <= 0) {
            throw new RuntimeException("No available lots in the carpark");
        }

        // For simplicity, we are not checking if the user already has an active reservation.
        // This could be added later.

        carpark.setAvailableLots(carpark.getAvailableLots() - 1);
        carparkRepository.save(carpark);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiryTime = now.plusMinutes(RESERVATION_EXPIRY_MINUTES);

        Reservation reservation = new Reservation(user, carpark, now, expiryTime);
        return reservationRepository.save(reservation);
    }
} 