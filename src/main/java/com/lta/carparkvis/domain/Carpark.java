package com.lta.carparkvis.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "carparks")
@Getter
@Setter
@NoArgsConstructor
public class Carpark {

    @Id
    @Column(name = "carpark_id")
    private String carparkId;

    private String name;

    @Column(columnDefinition = "geography(Point,4326)")
    private Point location;

    @Column(name = "available_lots")
    private int availableLots;

    @Column(name = "total_lots")
    private int totalLots;

    // The 'lot_type' can be 'C' for cars, 'Y' for motorcycles, 'H' for heavy vehicles
    @Column(name = "lot_type")
    private String lotType;

} 