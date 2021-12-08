package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<HotelModel, Long> {
    Optional<HotelModel> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
