package com.lta.carparkvis.repository;

import com.lta.carparkvis.domain.Carpark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarparkRepository extends JpaRepository<Carpark, String> {

    /**
     * Finds carparks within a given distance from a geographic point.
     * Note: The distance is in meters.
     * The query uses ST_DWithin, which can use a spatial index for efficiency.
     * longitude is the x-coordinate, latitude is the y-coordinate.
     *
     * @param longitude The longitude of the center point.
     * @param latitude  The latitude of the center point.
     * @param distance  The distance in meters.
     * @return A list of carparks within the given distance.
     */
    @Query(value = "SELECT * FROM carparks c " +
            "WHERE ST_DWithin(c.location, ST_MakePoint(:longitude, :latitude)::geography, :distance) " +
            "AND c.lot_type = 'C' " + // Only search for car parks
            "AND c.available_lots > 0", nativeQuery = true)
    List<Carpark> findCarparksWithin(
            @Param("longitude") double longitude,
            @Param("latitude") double latitude,
            @Param("distance") double distance
    );
} 