package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String puesto;
    private String telefono;
    private String email;
}
