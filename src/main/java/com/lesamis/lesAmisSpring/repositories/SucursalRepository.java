package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.SucursalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalModel, Long> {
//    Optional<SucursalModel> findByAgencia_Id(Long idAgencia);
//    boolean existsByAgencia_Id(Long agencia);
}
