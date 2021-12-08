package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.SucursalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalModel, Long> {
    public abstract ArrayList<SucursalModel> findByIdAgencia(Long idAgencia);
}
