package com.example.demo.Usuario;

import com.example.demo.Conductor.Conductor;
import com.example.demo.Pasajero.Pasajero;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private Integer dni;

    private Date fechaNacminiento;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private Boolean expired;

    private Boolean locked;

    private Boolean credentialsExpired;

    private Boolean enable;

    private Boolean isConductor=false;

    private Boolean isPasajero=false;

    private Role role;

    @OneToOne
    @JoinColumn(name="conductor_id")
    private Conductor conductor;

    @OneToOne
    @JoinColumn(name="pasajero_id")
    private Pasajero pasajero;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    // Método específico para obtener el username (no el email)
    public String getUsernameField() {
        return username;
    }

    public void setUsernameField(String username) {
        this.username = username;
    }
}
