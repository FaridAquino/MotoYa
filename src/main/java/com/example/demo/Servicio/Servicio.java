package com.example.demo.Servicio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Servicio {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Date fechaEmitida;

    private Long latitudPartida;

    private Long lonigtudPartida;

    private Long latitudDestino;

    private Long longitudDestino;

    private Integer cantidadPersonas;

    private Boolean aceptado;

    private Date fechaReservacion;

    private Boolean vigencia;

}
