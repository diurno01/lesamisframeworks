package com.lesamis.lesAmisSpring.repositories;
import com.lesamis.lesAmisSpring.models.ReservaHotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaHotelRepository extends JpaRepository<ReservaHotelModel, Long> {
}
