package com.example.demo.Carro;

import com.example.demo.Conductor.Conductor;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carro {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String placa;

    private String color;

    private String modelo;

    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductorPropietario;

}
