package com.example.demo.Pasajero;

import com.example.demo.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Pasajero {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String fotoPerfil;

    private Long latitud;

    private Long longitud;

    @OneToOne(mappedBy = "pasajero")
    private Usuario usuario;


}
