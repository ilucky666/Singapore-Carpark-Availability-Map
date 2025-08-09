package com.lta.carparkvis.web.rest.dto;

import com.lta.carparkvis.domain.Carpark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarparkDTO {
    private String carpark_id;
    private String name;
    private double lat;
    private double lon;
    private int available_lots;
    private int total_lots;
    private double parking_tension_index;

    public static CarparkDTO fromEntity(Carpark carpark) {
        double tensionIndex = 0;
        if (carpark.getTotalLots() > 0) {
            tensionIndex = (double) carpark.getAvailableLots() / carpark.getTotalLots();
        }

        return new CarparkDTO(
                carpark.getCarparkId(),
                carpark.getName(),
                carpark.getLocation().getY(), // Latitude is the Y coordinate
                carpark.getLocation().getX(), // Longitude is the X coordinate
                carpark.getAvailableLots(),
                carpark.getTotalLots(),
                tensionIndex
        );
    }
} 