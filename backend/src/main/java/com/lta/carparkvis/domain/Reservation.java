package com.lta.carparkvis.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carpark_id", nullable = false)
    private Carpark carpark;

    @Column(name = "reservation_time", nullable = false)
    private LocalDateTime reservationTime;

    @Column(name = "expiry_time", nullable = false)
    private LocalDateTime expiryTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    public Reservation(User user, Carpark carpark, LocalDateTime reservationTime, LocalDateTime expiryTime) {
        this.user = user;
        this.carpark = carpark;
        this.reservationTime = reservationTime;
        this.expiryTime = expiryTime;
        this.status = ReservationStatus.ACTIVE;
    }
} 