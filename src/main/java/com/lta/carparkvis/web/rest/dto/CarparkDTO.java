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

    public static CarparkDTO fromEntity(Carpark carpark) {
        return new CarparkDTO(
                carpark.getCarparkId(),
                carpark.getName(),
                carpark.getLocation().getY(), // Latitude is the Y coordinate
                carpark.getLocation().getX(), // Longitude is the X coordinate
                carpark.getAvailableLots()
        );
    }
} 