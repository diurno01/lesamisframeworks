package com.lesamis.lesAmisSpring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaHotelRepository extends JpaRepository<ReservaHotelRepository, Long> {
}
