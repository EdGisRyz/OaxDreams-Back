package ito.OaxacaDream.models;

import ito.OaxacaDream.models.Tour;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdUsuario;
    private String Nombre;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private String correo_Electronico;
    private String contrasena;
    private String Telefono;
    private String Rol;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "UsuarioTour",
            joinColumns = @JoinColumn(name = "IdUsuario"),
            inverseJoinColumns = @JoinColumn(name = "IdTour"))
    private Set<Tour> tours = new HashSet<>();
}
