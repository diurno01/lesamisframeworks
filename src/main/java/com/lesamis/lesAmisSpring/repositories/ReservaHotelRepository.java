package com.lesamis.lesAmisSpring.repositories;
import com.lesamis.lesAmisSpring.models.ReservaHotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaHotelRepository extends JpaRepository<ReservaHotelModel, Long> {
    List<ReservaHotelModel> findByUsuario_Id(Long id);
    List<ReservaHotelModel> findByHotel_Id(Long id);
    boolean existsByUsuario_Id(Long id);
    boolean existsByHotel_Id(Long id);
}
