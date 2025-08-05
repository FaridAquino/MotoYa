package com.example.demo.Conductor;


import com.example.demo.Carro.Carro;
import com.example.demo.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Conductor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long latitud;

    private Long longitud;

    private Integer nroLicencia;

    @OneToMany(mappedBy = "conductorPropietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Carro> carros;

    @OneToOne(mappedBy = "conductor")
    private Usuario usuario;

}
