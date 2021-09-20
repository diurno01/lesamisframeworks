package com.lesamis.lesAmisSpring.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="agencias")
public class AgenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;


}
